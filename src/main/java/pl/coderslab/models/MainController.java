package pl.coderslab.models;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/test")
	public String hello() {
		return "login";
	}
	
	@RequestMapping("/")
	public String loginRegister(HttpSession session) {
		if(session.getAttribute("login")!=null) {
			return "index";
		}else {
		return "loginRegister";
		}
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String login, @RequestParam String password, HttpSession session) {
		session.setAttribute("login", login);
		return "redirect:./";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:./";
	}

}
