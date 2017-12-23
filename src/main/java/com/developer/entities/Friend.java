package com.developer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="friend") 
public class Friend {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer friend_one ;
	private Integer friend_two ; 
	private FriendshipStatus status ;
	
	
	public Friend(int friend_one , int friend_two , FriendshipStatus status){
		this.id = null;
		this.friend_one=friend_one ; 
		this.friend_two=friend_two ; 
		this.status = status ; 
		
	}
	
	
	public int getFriend_one() {
		return friend_one;
	}
	public void setFriend_one(int friend_one) {
		this.friend_one = friend_one;
	}
	public int getFriend_two() {
		return friend_two;
	}
	public void setFriend_two(int friend_two) {
		this.friend_two = friend_two;
	}
	public FriendshipStatus getStatus() {
		return status;
	}
	public void setStatus(FriendshipStatus status) {
		this.status = status;
	} 
	
	
}
