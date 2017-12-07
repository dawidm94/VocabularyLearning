package pl.coderslab.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entities.Probability;
import pl.coderslab.entities.User;
import pl.coderslab.entities.Word;
import pl.coderslab.entities.WordGroup;
import pl.coderslab.repositories.ProbabilityRepository;
import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.WordGroupRepository;
import pl.coderslab.repositories.WordRepository;

@Controller
public class UserPanelController {

	@Autowired
	WordGroupRepository wordGroupRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	WordRepository wordRepository;

	@Autowired
	ProbabilityRepository probabilityRepository;

	@RequestMapping(value = "/add_category", method = RequestMethod.GET)
	public String addCategoryGET(Model model) {
		WordGroup wordGroup = new WordGroup();
		model.addAttribute("wordGroup", wordGroup);
		return "userAddWordGroup";
	}

	@RequestMapping(value = "/add_category", method = RequestMethod.POST)
	public String addCategoryPOST(@ModelAttribute WordGroup wordGroup, HttpSession session, Model model) {
		Date date = new Date();
		wordGroup.setIfBasicGroup(false);
		wordGroup.setCreated(date);
		wordGroup.setLastUpdate(date);
		wordGroup.setUser(userRepository.findOne((Long) session.getAttribute("user_id")));
		wordGroupRepository.save(wordGroup);
		return "redirect:/add_word/" + wordGroup.getId();
	}

	@RequestMapping("/add_word")
	public String showListToAddWord(Model model, HttpSession session) {
		List<WordGroup> wordGroups = wordGroupRepository
				.findNoBasicWordGroupByUserId((Long) session.getAttribute("user_id"));
		model.addAttribute("groups", wordGroups);
		return "showListToAddWord";
	}

	@RequestMapping(value = "/add_word/{id}", method = RequestMethod.GET)
	public String addWordGET(Model model, HttpSession session, @PathVariable long id) {
		long userId = (Long) session.getAttribute("user_id");
		WordGroup wg = wordGroupRepository.findOne(id);
		List<Word> wgList = wordRepository.findByWordGroupId(id);
		if (wg.getUser().getId() != userId) {
			return "errors/notAccess";
		}
		Word word = new Word();
		model.addAttribute("word", word);
		model.addAttribute("group", wgList);
		return "userAddWord";
	}

	@RequestMapping(value = "/add_word/{id}", method = RequestMethod.POST)
	public String addWordPOST(@PathVariable long id, @ModelAttribute Word word, Model model) {
		word.setWordGroup(wordGroupRepository.findOne(id));
		wordRepository.save(word);
		word.getWordGroup().setLastUpdate(new Date());
		wordGroupRepository.save(word.getWordGroup());
		List<User> users = userRepository.findAll();
		for (User user : users) {
			Probability probability = new Probability(user, word, 1.0);
			probabilityRepository.save(probability);
		}
		model.addAttribute("addedWord", word);
		word = new Word();
		model.addAttribute("word", word);
		List<Word> wgList = wordRepository.findByWordGroupId(id);
		model.addAttribute("group", wgList);
		return "userAddWord";
	}

	@RequestMapping("/my_categories")
	public String showMyCategories(Model model, HttpSession session) {
		List<WordGroup> wordGroups = wordGroupRepository
				.findNoBasicWordGroupByUserId((Long) session.getAttribute("user_id"));
		model.addAttribute("groups", wordGroups);
		return "showMyCategories";
	}
	
	@RequestMapping(value="/my_categories/edit/{id}", method = RequestMethod.GET)
	public String userEditCategory(Model model, HttpSession session, @PathVariable long id) {
		WordGroup wg = wordGroupRepository.findOne(id);
		long userId = (Long) session.getAttribute("user_id");
		if (wg.getUser().getId() != userId) {
			return "errors/notAccess";
		}
		model.addAttribute("wordGroup", wg);
		return "userEditWordGroup";
	}
	
	@RequestMapping(value="/my_categories/edit/{id}", method = RequestMethod.POST)
	public String userEditCategoryPOST(@ModelAttribute WordGroup wordGroup, Model model, HttpSession session, @PathVariable long id) {
		WordGroup wordGroupToUpdate = wordGroupRepository.findOne(id);
		wordGroupToUpdate.setName(wordGroup.getName());
		wordGroupToUpdate.setLastUpdate(new Date());
		wordGroupRepository.save(wordGroupToUpdate);
		return "redirect:/my_categories";
	}
	
	@RequestMapping(value="/my_categories/delete/{id}", method = RequestMethod.GET)
	public String userDeleteCategory(Model model, HttpSession session, @PathVariable long id) {
		WordGroup wg = wordGroupRepository.findOne(id);
		long userId = (Long) session.getAttribute("user_id");
		if (wg.getUser().getId() != userId) {
			return "errors/notAccess";
		}
		model.addAttribute("wordGroup", wg);
		return "userDeleteWordGroup";
	}
	
	@RequestMapping(value="/my_categories/delete/{id}", method = RequestMethod.POST)
	public String userDeleteCategoryPOST(@PathVariable long id) {
		WordGroup wg = wordGroupRepository.findOne(id);
		wordGroupRepository.delete(wg);
		return "redirect:/my_categories";
	}

	@RequestMapping("/my_categories/{id}")
	public String editDeleteWords(@PathVariable long id, HttpSession session, Model model) {
		long userId = (Long) session.getAttribute("user_id");
		WordGroup wg = wordGroupRepository.findOne(id);
		List<Word> wgList = wordRepository.findByWordGroupId(id);
		if (wg.getUser().getId() != userId) {
			return "errors/notAccess";
		}
		model.addAttribute("group", wgList);
		model.addAttribute("wg", wg);
		return "userWordList";
	}
	@RequestMapping(value = "/my_categories/{wgId}/edit/{id}", method = RequestMethod.GET)
	public String editWordGET(@PathVariable long wgId, @PathVariable long id, HttpSession session, Model model) {
		long userId = (Long) session.getAttribute("user_id");
		WordGroup wg = wordGroupRepository.findOne(wgId);
		if (wg.getUser().getId() != userId) {
			return "errors/notAccess";
		}
		Word word = wordRepository.findOne(id);
		model.addAttribute("word", word);
		return "userEditWord";
	}
	
	@RequestMapping(value = "/my_categories/{wgId}/edit/{id}", method = RequestMethod.POST)
	public String editWordPOST(@ModelAttribute Word word,@PathVariable long wgId, @PathVariable long id) {
		Word wordToUpdate = wordRepository.findOne(id);
		wordToUpdate.getWordGroup().setLastUpdate(new Date());
		wordGroupRepository.save(wordToUpdate.getWordGroup());
		wordToUpdate.setEng(word.getEng());
		wordToUpdate.setPl(word.getPl());
		wordRepository.save(wordToUpdate);
		return "redirect:/my_categories/"+wgId;
	}
	
	@RequestMapping(value = "/my_categories/{wgId}/delete/{id}", method = RequestMethod.GET)
	public String deleteWordGET(Model model, HttpSession session,@PathVariable long wgId, @PathVariable long id) {
		long userId = (Long) session.getAttribute("user_id");
		WordGroup wg = wordGroupRepository.findOne(wgId);
		if (wg.getUser().getId() != userId) {
			return "errors/notAccess";
		}
		model.addAttribute("word", wordRepository.findOne(id));
		return "userDeleteWord";
	}
	
	@RequestMapping(value = "/my_categories/{wgId}/delete/{id}", method = RequestMethod.POST)
	public String deleteWordPOST(@PathVariable long wgId, @PathVariable long id) {
		Word word = wordRepository.findOne(id);
		wordRepository.delete(word);
		return "redirect:/my_categories/"+wgId;
	}
}
