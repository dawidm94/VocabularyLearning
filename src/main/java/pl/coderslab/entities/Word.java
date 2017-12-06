package pl.coderslab.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "words")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String pl;
	private String eng;
	@ManyToOne
	private WordGroup wordGroup;
	@OneToMany(mappedBy = "word", cascade = CascadeType.REMOVE)
	private List<Probability> probabilities= new ArrayList<Probability>();

	public Word(String pl, String eng, WordGroup wordGroup) {
		this.pl = pl;
		this.eng = eng;
		this.wordGroup = wordGroup;
	}

	public Word() {
	}

	public long getId() {
		return id;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public WordGroup getWordGroup() {
		return wordGroup;
	}

	public void setWordGroup(WordGroup wordGroup) {
		this.wordGroup = wordGroup;
	}

}
