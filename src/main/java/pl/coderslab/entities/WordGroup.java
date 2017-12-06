package pl.coderslab.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "word_groups")
public class WordGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany(mappedBy = "wordGroup",cascade = CascadeType.REMOVE)
	private List<Word> words = new ArrayList<Word>();
	@Column(unique = true)
	private String name;
	@ManyToOne
	private User user;
	private boolean ifBasicGroup;
	@Column
	@Type(type="date")
	private Date created;
	@Column
	@Type(type="timestamp")
	private Date lastUpdate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WordGroup(String name) {
		this.name = name;
	}

	public WordGroup() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public boolean isIfBasicGroup() {
		return ifBasicGroup;
	}

	public void setIfBasicGroup(boolean ifBasicGroup) {
		this.ifBasicGroup = ifBasicGroup;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date date) {
		this.lastUpdate = date;
	}

}
