package pl.coderslab.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.repositories.ProbabilityRepository;
import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.WordRepository;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	WordRepository wordRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProbabilityRepository probabilityRepository;
	
	@ModelAttribute(name = "users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUserForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		userRepository.save(user);
		List<Word> words = wordRepository.findAll();
		for(Word word: words) {
			Probability probability = new Probability(user, word, 1);
			probabilityRepository.save(probability);
		}
		return "redirect:/admin";
	}
	
	@RequestMapping("/editlist")
	public String editWordList() {
		return "usersEditList";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUserForm(Model model, @PathVariable long id) {
		User user = userRepository.findOne(id);
		model.addAttribute("user",user);
		return "editUserForm";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editUser(@ModelAttribute User user, @PathVariable long id) {
		User userToUpdate = userRepository.findOne(id);
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setEmail(user.getEmail());
		userRepository.save(userToUpdate);
		return "redirect:/admin";
	}
	
	@RequestMapping("/delete")
	public String deleteWord(Model model) {
		return "deleteUser";
	}

	@RequestMapping("/read/{id}")
	public String read(@PathVariable long id) {
		return userRepository.findOne(id).toString();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		User user = userRepository.findOne(id);
		userRepository.delete(user);
		return "redirect:/admin";
	}
}
