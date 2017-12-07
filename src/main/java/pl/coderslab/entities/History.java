package pl.coderslab.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private WordGroup wordGroup;
	private int percentageOfResult;
	private Date solveDate;
	
	public History(User user, WordGroup wordGroup, int percentageOfResult, Date solveDate) {
		super();
		this.user = user;
		this.wordGroup = wordGroup;
		this.percentageOfResult = percentageOfResult;
		this.solveDate = solveDate;
	}
	
	public History() {
		super();
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public WordGroup getWordGroup() {
		return wordGroup;
	}
	public void setWordGroup(WordGroup wordGroup) {
		this.wordGroup = wordGroup;
	}
	public int getPercentageOfResult() {
		return percentageOfResult;
	}
	public void setPercentageOfResult(int percentageOfResult) {
		this.percentageOfResult = percentageOfResult;
	}
	public Date getSolveDate() {
		return solveDate;
	}
	public void setSolveDate(Date solveDate) {
		this.solveDate = solveDate;
	}
	public long getId() {
		return id;
	}
	
	
	
	
	
}

