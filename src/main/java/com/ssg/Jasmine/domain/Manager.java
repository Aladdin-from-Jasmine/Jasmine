package com.ssg.Jasmine.domain;

import java.io.Serializable;

public class Manager implements Serializable{

	private	String managerId;
	private	String managerPw;
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPw() {
		return managerPw;
	}
	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}
	
}
