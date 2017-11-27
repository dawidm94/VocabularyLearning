package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.models.Probability;
import pl.coderslab.models.ProbabilityDao;
import pl.coderslab.models.User;
import pl.coderslab.models.UserDao;
import pl.coderslab.models.Word;
import pl.coderslab.models.WordDao;
import pl.coderslab.models.WordGroup;
import pl.coderslab.models.WordGroupDao;

@Controller
@RequestMapping("/words")
public class WordController {
	
	@Autowired
	WordDao wordDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProbabilityDao probabilityDao;
	@Autowired
	WordGroupDao wordGroupDao;
	
	@RequestMapping("/save")
	public String save(@RequestParam String pl, @RequestParam String eng, @RequestParam long wordGroupId) {
		WordGroup wordGroup = wordGroupDao.findById(wordGroupId);
		Word word = new Word(pl, eng, wordGroup);
		wordDao.save(word);
		List<User> users = userDao.getList();
		for( User user: users) {
			Probability probability = new Probability(user, word, 1);
			probabilityDao.save(probability);
		}
		return "redirect:../admin";
	}
	
//	@RequestMapping("/read/{id}")
//	public String read(@PathVariable long id) {
//		return wordDao.findById(id).toString();
//	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		Word word = wordDao.findById(id);
		wordDao.delete(word);
	}
}