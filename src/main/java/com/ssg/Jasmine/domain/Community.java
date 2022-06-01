package com.ssg.Jasmine.domain;

import java.io.Serializable;

public class Community implements Serializable{
	
	private int communityId;
	private String title;
	private String communityDate;
	private String content;
	
	public Community() {
		
	}
	
	public Community(int communityId, String title, String communityDate, String content) {
		this.communityId = communityId;
		this.communityDate = communityDate;
		this.content = content;
		this.title = title;
	}
	
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCommunityDate() {
		return communityDate;
	}
	public void setCommunityDate(String communityDate) {
		this.communityDate = communityDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
