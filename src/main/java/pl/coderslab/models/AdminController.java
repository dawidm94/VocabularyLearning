package pl.coderslab.models;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("")
	public String adminPanel() {
		return "adminPanel";
	}
	
}
