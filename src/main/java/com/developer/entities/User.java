package com.developer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;
	private Integer password;
	private String email;
	private Integer friendCount;
	
	
	
	public int getUserID() {
		return id;
	}
	
	public User(int id, String username, int password, String email, int friendCount) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.friendCount = friendCount;
	}
	public void setUserID(int userID) {
		this.id = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFriendCount() {
		return friendCount;
	}
	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}
	
}
