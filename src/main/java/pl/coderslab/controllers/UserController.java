package pl.coderslab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDao userDao;
	@Autowired
	WordDao wordDao;
	@Autowired
	ProbabilityDao probabilityDao;
	
	@RequestMapping("/save")
	public String save(HttpSession session,@RequestParam String login, @RequestParam String password, @RequestParam String email) {
		User user = new User(login, password, email);
		userDao.save(user);
		System.out.println("Added user id: " + user.getId());
		session.setAttribute("login", login);
		List<Word> words = wordDao.getList();
		for(Word word: words) {
			Probability probability = new Probability(user, word, 1);
			probabilityDao.save(probability);
		}
		return "redirect:../admin";
	}
	
//	@RequestMapping("/read/{id}")
//	public String read(@PathVariable long id) {
//		return userDao.findById(id).toString();
//	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		User user = userDao.findById(id);
		userDao.delete(user);
	}
}
