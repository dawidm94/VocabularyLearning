package pl.coderslab.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.History;
import pl.coderslab.entities.Probability;
import pl.coderslab.entities.User;
import pl.coderslab.entities.Word;
import pl.coderslab.entities.WordGroup;
import pl.coderslab.models.WordTest;
import pl.coderslab.repositories.HistoryRepository;
import pl.coderslab.repositories.ProbabilityRepository;
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
	
	@Autowired
	ProbabilityRepository probabilityRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
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
	public String login(Model model, @RequestParam String login, @RequestParam String password, HttpSession session) {
		String wrong = "";
		try {
			User user = userRepository.findByLogin(login);
			if (BCrypt.checkpw(password, user.getPassword())) {
				session.setAttribute("user_id", user.getId());
				session.setAttribute("user_permission", user.getPermission());
				return "redirect:./";
			} else {
				wrong = "WRONG PASSWORD!!";
				
			} 
		} catch (NullPointerException e) {
			wrong = "WRONG LOGIN!!";
		}
			User user = new User();
			model.addAttribute("user", user);
			model.addAttribute("wrong", wrong);
			return "login";

	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result, Model model, HttpSession session) {
		
		
		
		if(result.hasErrors()) {
			return "login";
		}
		
		String password = user.getPassword();
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		user.setPassword(hashedPassword);
		user.setPermission("user");
		userRepository.save(user);
		List<Word> words = wordRepository.findAll();
		for(Word word: words) {
			Probability probability = new Probability(user, word, 1.0);
			probabilityRepository.save(probability);
		}
		
			session.setAttribute("user_id", user.getId());
			session.setAttribute("user_permission", user.getPermission());
			String message = "Witaj " + user.getLogin() + "! Twoja rejestracja przebiegła pomyślnie.";
			model.addAttribute("message", message);
			return "index";
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
	public String random(Model model,HttpSession session) {
		int randomWordsNumber = 20;
		List<Word> words = wordRepository.findAll();
		List<Word> randomWords = new ArrayList<Word>();
		@SuppressWarnings("unused")
		Random random = new Random();
		Collections.shuffle(words);
		for(int i=0; i<randomWordsNumber; i++) {
			randomWords.add(words.get(i));
		}
		model.addAttribute("randomWords",randomWords);
		session.setAttribute("randomList", randomWords);
		return "random";
	}

	@RequestMapping(value="/random/test", method = RequestMethod.GET)
	public String randomTest(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Word> randomWords = (List<Word>) session.getAttribute("randomList");
		List<WordTest> wordTestList = new ArrayList<WordTest>();
		for(Word word: randomWords) {
			wordTestList.add(new WordTest(word, null));
			
		}
		Collections.shuffle(wordTestList);
		session.setAttribute("testList", wordTestList);
		session.setAttribute("actuallQuestion", 0);
		return"test";
	}
	
	@RequestMapping(value="/random/test", method = RequestMethod.POST)
	public String randomTestPOST(HttpSession session, @RequestParam String userAnswer) {
		final long RANDOMID = 22;
		@SuppressWarnings("unchecked")
		List<WordTest> wordTestList = (List<WordTest>) session.getAttribute("testList");
		int actuallQuestion = (Integer) session.getAttribute("actuallQuestion");
		String correctAnswer = wordTestList.get(actuallQuestion).getWord().getEng();
		long userId = (Long) session.getAttribute("user_id");
		Probability probability = probabilityRepository.findOneByUserIdAndWordId(userId, wordTestList.get(actuallQuestion).getWord().getId());
		Double actuallProbability = probability.getProbability();
		
		wordTestList.get(actuallQuestion).setUserAnswer(userAnswer);
		
		if(correctAnswer.toLowerCase().equals(userAnswer.toLowerCase())){
			probability.setProbability(actuallProbability*0.6);
		}else {
			probability.setProbability(actuallProbability*2);
		}
		
		probabilityRepository.save(probability);
		actuallQuestion++;
		
		if(wordTestList.size()<=actuallQuestion) {
			User user = userRepository.findOne(userId);
			WordGroup wg = wordGroupRepository.findOne(RANDOMID);
			int correctAnswers = 0;
			for(WordTest wt: wordTestList) {
				if(wt.getUserAnswer().equals(wt.getWord().getEng())) {
					correctAnswers++;
				}
			}
			int percentageOfCorrectAnswers = Math.round((float)correctAnswers*100/(float)wordTestList.size());
			History history = new History(user, wg, percentageOfCorrectAnswers, new Date());
			session.removeAttribute("actuallQuestion");
			historyRepository.save(history);
			return "testResult";
		}else {
			session.setAttribute("actuallQuestion", actuallQuestion);
			return "test";
		}
	}
	
	@RequestMapping("/not_permission")
	public String notPermission() {
		return "/errors/notAccess";
	}
}
