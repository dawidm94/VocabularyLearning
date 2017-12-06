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
public class UserAddController {	
	
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
		model.addAttribute("wordGroup",wordGroup);
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
		return "redirect:/add_word/"+wordGroup.getId();
	}
	
	@RequestMapping("/add_word")
	public String showListToAddWord(Model model,HttpSession session) {
		List<WordGroup> wordGroups = wordGroupRepository.findNoBasicWordGroupByUserId((Long) session.getAttribute("user_id"));
		model.addAttribute("groups", wordGroups);
		return "showListToAddWord";
	}
	
	@RequestMapping(value = "/add_word/{id}", method = RequestMethod.GET)
	public String addWordGET(Model model,HttpSession session,@PathVariable long id) {
		long userId = (Long) session.getAttribute("user_id");
		WordGroup wg = wordGroupRepository.findOne(id);
		List<Word> wgList = wordRepository.findByWordGroupId(id);
		if(wg.getUser().getId()!=userId) {
			return "errors/notAccess";
		}
		Word word = new Word();
		model.addAttribute("word", word);
		model.addAttribute("group",wgList);
		return "userAddWord";
	}
	
	@RequestMapping(value = "/add_word/{id}", method = RequestMethod.POST)
	public String addWordPOST(@PathVariable long id,@ModelAttribute Word word,Model model) {
		word.setWordGroup(wordGroupRepository.findOne(id));
		wordRepository.save(word);
		word.getWordGroup().setLastUpdate(new Date());
		wordGroupRepository.save(word.getWordGroup());
		List<User> users = userRepository.findAll();
		for( User user: users) {
			Probability probability = new Probability(user, word, 1.0);
			probabilityRepository.save(probability);
		}
		model.addAttribute("addedWord", word);
		word = new Word();
		model.addAttribute("word", word);
		List<Word> wgList = wordRepository.findByWordGroupId(id);
		model.addAttribute("group",wgList);
		return "userAddWord";
	}
}
