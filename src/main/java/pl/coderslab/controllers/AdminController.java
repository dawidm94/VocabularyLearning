package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.models.User;
import pl.coderslab.models.UserDao;
import pl.coderslab.models.Word;
import pl.coderslab.models.WordDao;
import pl.coderslab.models.WordGroup;
import pl.coderslab.models.WordGroupDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	WordGroupDao wordGroupDao;
	@Autowired
	WordDao wordDao;
	@Autowired
	UserDao userDao;

	@RequestMapping("")
	public String adminPanel() {
		return "adminPanel";
	}
	
	//WORD
	
	@RequestMapping("/word/add")
	public String addWord(Model model) {
		List<WordGroup> wordGroups = wordGroupDao.getList();
		model.addAttribute("groups",wordGroups);
		return "addWordForm";
	}
	
	@RequestMapping("/word/editlist")
	public String editWordList(Model model) {
		List<Word> words = wordDao.getList();
		model.addAttribute("words",words);
		return "wordsEditList";
	}
	
	@RequestMapping("/word/edit/{id}")
	public String editWordForm(Model model, @PathVariable long id) {
		Word word = wordDao.findById(id);
		model.addAttribute("word",word);
		List<WordGroup> wordGroups = wordGroupDao.getList();
		model.addAttribute("groups",wordGroups);
		return "editWordForm";
	}
	
	@RequestMapping("/word/edit2")
	public String editWord(@RequestParam long id, @RequestParam String pl, @RequestParam String eng, @RequestParam long wordGroupId) {
		WordGroup wordGroup = wordGroupDao.findById(wordGroupId);
		Word word = wordDao.findById(id);
		word.setPl(pl);
		word.setEng(eng);
		word.setWordGroup(wordGroup);
		wordDao.update(word);
		return "redirect:./editlist";
	}
	
	@RequestMapping("/word/delete")
	public String deleteWord(Model model) {
		List<Word> words = wordDao.getList();
		model.addAttribute("words",words);
		return "deleteWord";
	}
	
	//WORD GROUP
	
	@RequestMapping("/wordGroup/add")
	public String addWordGroup() {
		return "addWordGroupForm";
	}
	
	@RequestMapping("/wordGroup/edit")
	public String editWordGroup(Model model) {
		List<WordGroup> wordGroups = wordGroupDao.getList();
		model.addAttribute("groups",wordGroups);
		return "editWordGroup";
	}
	
	@RequestMapping("/wordGroup/delete")
	public String deleteWordGroup(Model model) {
		List<WordGroup> wordGroups = wordGroupDao.getList();
		model.addAttribute("groups",wordGroups);
		return "deleteWordGroup";
	}
	
	//USER
	
	@RequestMapping("/user/add")
	public String addUser() {
		return "addUserForm";
	}
	
	@RequestMapping("/user/editlist")
	public String userEditList(Model model) {
		List<User> users = userDao.getList();
		model.addAttribute("users",users);
		return "usersEditList";
	}
	
	@RequestMapping("/user/edit/{id}")
	public String editUserForm(Model model, @PathVariable long id) {
		User user = userDao.findById(id);
		model.addAttribute("users",user);
		return "editUserForm";
	}
	
	@RequestMapping("/user/edit2")
	public String editUser(@RequestParam String login, @RequestParam String password, @RequestParam String email ,@RequestParam long id) {
		User user = userDao.findById(id);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);
		userDao.update(user);
		return "redirect:./editlist";
	}
	
	@RequestMapping("/user/delete")
	public String deleteUser(Model model) {
		List<User> users = userDao.getList();
		model.addAttribute("users",users);
		return "deleteUsers";
	}
}
