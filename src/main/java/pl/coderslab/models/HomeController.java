package pl.coderslab.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.WordRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	WordRepository wordRepository;
	
	@RequestMapping("/test")
	public String hello() {
		return "login";
	}
	
	@RequestMapping("/")
	public String loginRegister(HttpSession session) {
		if(session.getAttribute("user_id")!=null) {
			return "index";
		}else {
		return "loginRegister";
		}
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
		User user = userRepository.findByLogin(login);
		session.setAttribute("user_id", user.getId());
		return "redirect:./";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:./";
	}
	
	@RequestMapping("/admin")
	public String adminPanel() {
		return "adminPanel";
	}
	
	@RequestMapping("/random")
	public String random(Model model) {
		int randomWordsNumber = 10;
		List<Word> words = wordRepository.findAll();
		List<Word> randomWords = new ArrayList<Word>();
		Random random = new Random();
		Collections.shuffle(words);
		for(int i=0; i<randomWordsNumber; i++) {
			randomWords.add(words.get(i));
		}
		model.addAttribute("randomWords",randomWords);
		return "random10";
	}
	
	@RequestMapping("/categories")
	public String selectTypeofCategory() {
		return "categoryTypeSelect";
	}
	
	@RequestMapping("/categories/basic")
	public String basicCategories() {
		return "categoriesBasic";
	}
	
	@RequestMapping("/categories/users")
	public String usersCategories() {
		return "categoriesBasic";
	}

}
