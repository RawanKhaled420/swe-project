package com.developer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notification")
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id ;
	private Integer userID;
	private String noti;
	Notification ()
	{id=null;
	userID=null;
	noti="";
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getNoti() {
		return noti;
	}
	public void setNoti(String noti) {
		this.noti = noti;
	}
}
