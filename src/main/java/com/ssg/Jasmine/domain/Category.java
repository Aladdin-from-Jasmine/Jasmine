package com.ssg.Jasmine.domain;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Category implements Serializable{
	private int categoryId;
	private String genre;

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
