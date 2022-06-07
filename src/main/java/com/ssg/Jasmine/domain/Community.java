package com.ssg.Jasmine.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

public class Community implements Serializable{

	private int postId;
	private String title;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date communityDate;
	private String content_;
	private String userId;
	
	public Community() { }
	
	public Community(int postId, String title, Date communityDate, String content_, String userId) {
		this.postId = postId;
		this.communityDate = communityDate;
		this.content_ = content_;
		this.title = title;
		this.userId = userId;
	}
	
	public Community(String title,String content_, String userId) {
		this.content_ = content_;
		this.title = title;
		this.userId = userId;
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
	public String getContent_() {
		return content_;
	}
	public void setContent_(String content_) {
		this.content_ = content_;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
