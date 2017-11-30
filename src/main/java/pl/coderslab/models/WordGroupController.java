package pl.coderslab.models;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.repositories.UserRepository;
import pl.coderslab.repositories.WordGroupRepository;

@Controller
@RequestMapping("/admin/wordGroup")
public class WordGroupController {
	
	@Autowired
	WordGroupRepository wordGroupRepository;
	
	@Autowired
	UserRepository userRepository;

	@ModelAttribute(name = "groups")
	public List<WordGroup> getGroups(){
		return wordGroupRepository.findAll();
	}
		
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addWordGroupForm(Model model) {
		WordGroup wordGroup = new WordGroup();
		model.addAttribute("wordGroup", wordGroup);
		return "addWordGroupForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addWord(@ModelAttribute WordGroup wordGroup, Model model, HttpSession session) {
		User user = userRepository.findOne((Long) session.getAttribute("user_id"));
		System.out.println(user.getEmail() + "email");
		System.out.println(user.getLogin() + "login");
		System.out.println(user.getId() + "id");
		wordGroup.setUser(user);
		wordGroupRepository.save(wordGroup);
		model.addAttribute("addedWordGroup", wordGroup);
		wordGroup = new WordGroup();
		model.addAttribute("wordGroup", wordGroup);
		return "addWordGroupForm";
	}

	@RequestMapping("/editlist")
	public String editWordGroup(Model model) {
		return "wordGroupsEditList";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editWordGroupForm(Model model, @PathVariable long id) {
		WordGroup wordGroup = wordGroupRepository.findOne(id);
		model.addAttribute("wordGroup",wordGroup);
		return "editWordGroupForm";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editWordGroup(@ModelAttribute WordGroup wordGroup, @PathVariable long id) {
		WordGroup wordGroupToUpdate = wordGroupRepository.findOne(id);
		wordGroupToUpdate.setName(wordGroup.getName());
		wordGroupRepository.save(wordGroupToUpdate);
		return "redirect:/admin/wordGroup/editlist";
	}
	
	@RequestMapping("/delete")
	public String deleteWordGroup(Model model) {
		return "deleteWordGroup";
	}
	
	@RequestMapping("/read/{id}")
	public String read(@PathVariable long id) {
		return wordGroupRepository.findOne(id).toString();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		WordGroup wordGroup = wordGroupRepository.findOne(id);
		wordGroupRepository.delete(wordGroup);
		return "redirect:/admin/wordGroup/delete";
	}
}