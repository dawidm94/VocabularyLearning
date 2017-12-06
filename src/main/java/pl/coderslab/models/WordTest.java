package pl.coderslab.models;

import pl.coderslab.entities.Word;

public class WordTest {

	private Word word;
	private Boolean answer;
	private String userAnswer;

	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public Boolean getAnswer() {
		return answer;
	}
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}
	
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public WordTest(Word word, Boolean answer, String userAnswer) {
		this.word = word;
		this.answer = answer;
		this.userAnswer = userAnswer;
	}
	
	
}
