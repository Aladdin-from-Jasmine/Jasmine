package com.ssg.Jasmine.controller.book;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookForm implements Serializable {
	
	//private int bookId;
	//등록한사람이 누군지는.. 알아야되니까....
	//private String userName;
	private int isbn;
	private int price;
	private String categoryId;
	private String title;
	private String author;
	private String publisher;
	
	public BookForm bookForm(){
		System.out.println("test bookform");
		return new BookForm();
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	

}
