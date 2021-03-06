package com.ssg.Jasmine.controller.user;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginForm implements Serializable {

	private String userId;
	private String password;

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

	@Override
	public String toString() {
		return "LoginForm [id=" + userId + ", password=" + password + "]";
	}

}
