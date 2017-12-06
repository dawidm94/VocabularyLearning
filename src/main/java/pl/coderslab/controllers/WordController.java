package pl.coderslab.controllers;

import java.util.Date;
import java.util.List;

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
@RequestMapping("/admin/word")
public class WordController {
	
	@Autowired
	WordRepository wordRepository;
	@Autowired
	WordGroupRepository wordGroupRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProbabilityRepository probabilityRepository;
	
	@ModelAttribute(name = "groups")
	public List<WordGroup> getGroups(){
		return wordGroupRepository.findAll();
	}
	
	@ModelAttribute(name = "users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@ModelAttribute(name = "words")
	public List<Word> getWords(){
		return wordRepository.findAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addWordForm(Model model) {
		Word word = new Word();
		model.addAttribute("word", word);
		return "addWordForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addWord(@ModelAttribute Word word, Model model) {
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
		return "addWordForm";
	}
	
	@RequestMapping("/editlist")
	public String editWordList(Model model) {
		return "wordsEditList";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editWordForm(Model model, @PathVariable long id) {
		Word word = wordRepository.findOne(id);
		model.addAttribute("word",word);
		return "editWordForm";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editWord(@ModelAttribute Word word, @PathVariable long id) {
		Word wordToUpdate = wordRepository.findOne(id);
		wordToUpdate.getWordGroup().setLastUpdate(new Date());
		wordGroupRepository.save(wordToUpdate.getWordGroup());
		wordToUpdate.setEng(word.getEng());
		wordToUpdate.setPl(word.getPl());
		wordToUpdate.setWordGroup(word.getWordGroup());
		wordRepository.save(wordToUpdate);
		return "redirect:/admin/word/editlist";
	}
	
	@RequestMapping("/delete")
	public String deleteWord(Model model) {
		return "deleteWord";
	}
	
	@RequestMapping("/read/{id}")
	public String read(@PathVariable long id) {
		return wordRepository.findOne(id).toString();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		Word word = wordRepository.findOne(id);
		wordRepository.delete(word);
		return "redirect:/admin/word/delete";
	}
}