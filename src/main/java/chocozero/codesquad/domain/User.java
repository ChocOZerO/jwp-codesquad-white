package chocozero.codesquad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="u_id", length=20, nullable=false)
	String userId;
	
	@Column(nullable=false)
	String password;
	
	@Column(length=20)
	String name;
	
	@Column(length=40)
	String email;
	
	public boolean isUser(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}
	public boolean update(User user) {
		if (isUser(user.getPassword())) {
			this.name = user.name;
			this.email = user.email;
			return true;
		}
		return false;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
