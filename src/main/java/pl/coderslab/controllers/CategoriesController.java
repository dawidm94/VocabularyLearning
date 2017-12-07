package pl.coderslab.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

@RequestMapping("/categories")
@Controller
public class CategoriesController {

	@Autowired
	WordGroupRepository wordGroupRepository;
	
	@Autowired
	WordRepository wordRepository;
	
	@Autowired
	ProbabilityRepository probabilityRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HistoryRepository historyRepository;
	
	@RequestMapping("")
	public String selectTypeofCategory() {
		return "categoryTypeSelect";
	}
	
	@RequestMapping("/basic")
	public String basicCategories() {
		return "categoriesBasic";
	}
	
	@RequestMapping("/basic/{id}")
	public String basicWordsCategory(Model model, @PathVariable long id) {
		List<Word> words = wordRepository.findByWordGroupId(id);
		WordGroup wordGroup = wordGroupRepository.findOne(id);
		model.addAttribute("words", words);
		model.addAttribute("group", wordGroup);
		return "wordsByBasicWordGroup";
	}
	
	@RequestMapping("/user")
	public String usersCategories(Model model) {
		List<WordGroup> usersCategories = wordGroupRepository.findByNoBasicWordGroupOrderByLastUpdate();
		model.addAttribute("userCategories", usersCategories);
		return "categoriesUser";
	}
	
	@RequestMapping("/user/{id}")
	public String userWordsCategory(Model model, @PathVariable long id) {
		List<Word> words = wordRepository.findByWordGroupId(id);
		model.addAttribute("words", words);
		WordGroup wordGroup = wordGroupRepository.findOne(id);
		model.addAttribute("group", wordGroup);
		return "wordsByUsersWordGroup";
	}
	
	@RequestMapping(value= {"/user/{id}/test","/basic/{id}/test"}, method = RequestMethod.GET)
	public String test(@PathVariable long id, HttpSession session) {
		List<Word> words = wordRepository.findByWordGroupId(id); 
		long userId = (Long) session.getAttribute("user_id");
		Random random = new Random();
		/////////////////////////////////////////////////////////////
		int numberOfWordsInTest = 20;
		List<Word> testWords = new ArrayList<Word>();
		if(words.size()>numberOfWordsInTest) {
			List<Double> probabilities = new ArrayList<Double>(); //B2
			List<Long> wordIds = new ArrayList<Long>(); 			//A1
			for(Word word: words) {
				// B2 pobiera probability na podstawie user z sesji i word.id
				probabilities.add(probabilityRepository.findOneByUserIdAndWordId(userId, word.getId()).getProbability());
				// A1 pobiera id word i wrzuca do osobnej listy
				wordIds.add(word.getId());
			}
			//PK1 --> punkt kontrolny 1 -> stworzona lista A1 i B2
			List<Integer> intProbabilities = new ArrayList<Integer>();
			for(double prob: probabilities) {
				prob=Math.round(prob*100);
				intProbabilities.add((int)prob);
			}
			//PK2 
			while(testWords.size()<20) {
				int probabilitiesSum = 0;
				for(int prob: intProbabilities) {
					System.out.println("prob = " + prob);
					probabilitiesSum+=prob;
				}
				//Number to picking word
				int randNumber = random.nextInt(probabilitiesSum)+1;
				// zmienna sprawdzajaca w ktorym przedziale znajduje sie randNumber
				int checkingNumber = 0;
				
				for(int i=0;i<intProbabilities.size();i++) {
					checkingNumber+=intProbabilities.get(i);
					if(randNumber<=checkingNumber) {
						testWords.add(wordRepository.findOne(wordIds.get(i)));
						wordIds.remove(i);
						intProbabilities.remove(i);
						break;
					}
				}
			}
		}else {
			testWords = words;
		}/////////////////////////////////////////////////////////////
		List<WordTest> wordTestList = new ArrayList<WordTest>();
		for(Word word: testWords) {
			wordTestList.add(new WordTest(word, null));
			
		}
		Collections.shuffle(wordTestList);
		session.setAttribute("testList", wordTestList);
		session.setAttribute("actuallQuestion", 0);
		
		return "test";
	}
	
	@RequestMapping(value= {"/user/{id}/test","/basic/{id}/test"}, method = RequestMethod.POST)
	public String testPOST(Model model, @RequestParam String userAnswer, @PathVariable long id, HttpSession session) {
	
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
			WordGroup wg = wordGroupRepository.findOne(id);
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
}
