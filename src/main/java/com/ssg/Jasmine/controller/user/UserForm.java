package com.ssg.Jasmine.controller.user;

import java.io.Serializable;

import com.ssg.Jasmine.domain.User;

@SuppressWarnings("serial")
public class UserForm implements Serializable { 
	
	private User user;
	private boolean newUser;
	private String repeatedPassword;
	
	public UserForm() {
		this.user = new User();
		this.newUser = true;
	}
	
	public UserForm(User user) {
		this.user = user;
		this.newUser = false;
	}
	
	public User getUser() {
		return user;
	}
	
	public boolean isNewUser() {
		return newUser;
	}
	
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}
	
	public String getRepeatedPassword() {
		return repeatedPassword;
	}
}
