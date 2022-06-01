package com.ssg.Jasmine.controller.user;

import java.io.Serializable;

import com.ssg.Jasmine.domain.User;

@SuppressWarnings("serial")
public class UserSession implements Serializable {
	
	private User user;

	public UserSession(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
