package pl.coderslab.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.repositories.WordGroupRepository;
import pl.coderslab.repositories.WordRepository;

@Controller
public class CategoriesController {

	@Autowired
	WordGroupRepository wordGroupRepository;
	
	@Autowired
	WordRepository wordRepository;
	
	@RequestMapping("/categories")
	public String selectTypeofCategory() {
		return "categoryTypeSelect";
	}
	
	@RequestMapping("/categories/basic")
	public String basicCategories() {
		return "categoriesBasic";
	}
	
	@RequestMapping("/categories/user")
	public String usersCategories(Model model) {
		List<WordGroup> usersCategories = wordGroupRepository.findByNoBasicWordGroupOrderByLastUpdate();
		model.addAttribute("userCategories", usersCategories);
		return "categoriesUser";
	}
	
	@RequestMapping("/categories/user/{id}")
	public String userWordsCategory(Model model, @PathVariable long id) {
		List<Word> words = wordRepository.findByWordGroupId(id);
		WordGroup wordGroup = wordGroupRepository.findOne(id);
		model.addAttribute("words", words);
		model.addAttribute("group", wordGroup);
		return "wordsByWordGroup";
	}
}
