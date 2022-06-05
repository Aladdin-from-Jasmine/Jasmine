package com.ssg.Jasmine.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Community implements Serializable{
	
	private int postId;
	private String title;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date communityDate;
	private String content;
	
	public Community() { }
	
	public Community(int postId, String title, Date communityDate, String content) {
		this.postId = postId;
		this.communityDate = communityDate;
		this.content = content;
		this.title = title;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCommunityDate() {
		return communityDate;
	}
	public void setCommunityDate(Date communityDate) {
		this.communityDate = communityDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
