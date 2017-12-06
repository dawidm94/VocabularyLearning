package pl.coderslab.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String login;
	private String password;
	@Column(unique = true)
	private String email;
	@OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
	private List<Probability> probabilities= new ArrayList<Probability>();
	@OneToMany(mappedBy = "user")
	private List<WordGroup> wordGroups = new ArrayList<WordGroup>();
	private String permission;

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public User() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permissions) {
		this.permission = permissions;
	}

}
