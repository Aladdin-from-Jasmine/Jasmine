package com.ssg.Jasmine.controller.community;

import java.io.Serializable;

import com.ssg.Jasmine.domain.Community;

@SuppressWarnings("serial")
public class CommunityForm implements Serializable { 
	
	private Community community;
	private boolean newCommunity;

	public CommunityForm() {
		this.community = new Community();
		this.newCommunity = true;
	}
	
	public CommunityForm(Community user) {
		this.community = user;
		this.newCommunity = false;
	}
	
	public Community getCommunity() {
		return community;
	}
	
	public boolean isNewCommunity() {
		return newCommunity;
	}
	
	@Override
	public String toString() {
		return "[ CommunityForm : " + community + "]";
	}
}
