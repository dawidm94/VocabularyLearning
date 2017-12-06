package pl.coderslab.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.User;
import pl.coderslab.entities.Word;
import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.WordGroupRepository;
import pl.coderslab.repositories.WordRepository;

@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	WordRepository wordRepository;
	
	@Autowired
	WordGroupRepository wordGroupRepository;
	
	@RequestMapping("/")
	public String loginRegister(HttpSession session, Model model) {
		if(session.getAttribute("user_id")!=null) {
			return "index";
		}else {
			User user = new User();
			model.addAttribute("user",user);
			return "login";
		}
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
		User user = userRepository.findByLogin(login);
		session.setAttribute("user_id", user.getId());
		session.setAttribute("user_permission", user.getPermission());
		return "redirect:./";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		session.removeAttribute("user_permission");
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
		@SuppressWarnings("unused")
		Random random = new Random();
		Collections.shuffle(words);
		for(int i=0; i<randomWordsNumber; i++) {
			randomWords.add(words.get(i));
		}
		model.addAttribute("randomWords",randomWords);
		return "random10";
	}

}
