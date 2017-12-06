package pl.coderslab.models;

import pl.coderslab.entities.Word;

public class WordTest {

	private Word word;
	private Boolean answer;

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
	public WordTest(Word word, Boolean answer) {
		this.word = word;
		this.answer = answer;
	}
	
	
}
