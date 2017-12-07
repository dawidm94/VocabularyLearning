package pl.coderslab.models;

import java.io.Serializable;

import pl.coderslab.entities.Word;

@SuppressWarnings("serial")
public class WordTest implements Serializable {

	private Word word;
	private String userAnswer;

	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public WordTest(Word word, String userAnswer) {
		this.word = word;
		this.userAnswer = userAnswer;
	}
	
	
}
