package pl.coderslab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.User;
import pl.coderslab.entities.WordGroup;
import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.WordGroupRepository;
import pl.coderslab.repositories.WordRepository;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	WordRepository wordRepository;
	
	@Autowired
	WordGroupRepository wordGroupRepository;
	
	@RequestMapping("")
	public String showProfile(HttpSession session, Model model) {
		long userId = (Long) session.getAttribute("user_id");
		User user = userRepository.findOne(userId);
		List<WordGroup> userWordGroups = wordGroupRepository.findNoBasicWordGroupByUserId(userId);
		model.addAttribute("user", user);
		model.addAttribute("wordGroups", userWordGroups);
		return "profile";
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String changeEmail() {
		return "profileChangeEmail";
	}
	
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String changeEmail(HttpSession session, Model model, @RequestParam String mail, @RequestParam String confirmMail, @RequestParam String password) {
		User user = userRepository.findOne((Long) session.getAttribute("user_id"));
		if(BCrypt.checkpw(password, user.getPassword())) {
			if(mail.equals(confirmMail)) {
				user.setEmail(mail);
				userRepository.save(user);
				String message = "E-mail changed";
				model.addAttribute("changed", message);
			}else {
				String message = "E-mails are not the same";
				model.addAttribute("failedMatch", message);
			}
		}else {
			String message = "Password is not correct";
			model.addAttribute("wrongPassword", message);
		}
		return "profileChangeEmail";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String changePassword() {
		return "profileChangePassword";
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String changePassword(HttpSession session, Model model, @RequestParam String newPassword, @RequestParam String confirmNewPassword, @RequestParam String password) {
		User user = userRepository.findOne((Long) session.getAttribute("user_id"));
		if(BCrypt.checkpw(password, user.getPassword())) {
			if(newPassword.equals(confirmNewPassword)) {
				user.setEmail(newPassword);
				userRepository.save(user);
				String message = "Password changed";
				model.addAttribute("changed", message);
			}else {
				String message = "Passwords are not the same";
				model.addAttribute("failedMatch", message);
			}
		}else {
			String message = "Password is not correct";
			model.addAttribute("wrongPassword", message);
		}
		return "profileChangePassword";
	}
}
