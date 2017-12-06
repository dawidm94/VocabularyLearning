package pl.coderslab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "probabilities")
public class Probability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Word word;
	@Column(scale=2, precision=4)
	private Double probability;

	public Probability(User user, Word word, Double probability) {
		this.user = user;
		this.word = word;
		this.probability = probability;
	}

	public Probability() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public Double getProbability() {
		return probability;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}

	public long getId() {
		return id;
	}

}
