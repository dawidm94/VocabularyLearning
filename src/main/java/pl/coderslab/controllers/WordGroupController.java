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
@RequestMapping("/wordGroups")
public class WordGroupController {
	
	@Autowired
	WordDao wordDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProbabilityDao probabilityDao;
	@Autowired
	WordGroupDao wordGroupDao;
	
	@RequestMapping("/save")
	public String save(@RequestParam String name) {
		WordGroup wordGroup = new WordGroup(name);
		wordGroupDao.save(wordGroup);
		return "redirect:../admin";
	}
	
//	@RequestMapping("/read/{id}")
//	public String read(@PathVariable long id) {
//		return wordGroupDao.findById(id).toString();
//	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		WordGroup wordGroup = wordGroupDao.findById(id);
		wordGroupDao.delete(wordGroup);
	}
}