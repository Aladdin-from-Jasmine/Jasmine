package com.ssg.Jasmine.domain;

import java.io.Serializable;

import javax.persistence.Entity;


@SuppressWarnings("serial")
public class User implements Serializable {

	/* Private Fields */
	private String userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String phone;

	/* JavaBeans Properties */
	public User() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}


}