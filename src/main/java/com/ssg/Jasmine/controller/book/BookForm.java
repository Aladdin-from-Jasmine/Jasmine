package com.ssg.Jasmine.controller.book;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class BookForm implements Serializable {
	
	private int bookId;
	//등록한사람이 누군지는.. 알아야되니까....
	//private String userName;
	private String isbn;
	private int price;
	private int categoryId;
	private String title;
	private String author;
	private String publisher;
	private String img;
	private MultipartFile report;

	
	public BookForm bookForm(){
		System.out.println("test bookform");
		return new BookForm();
	}
	
	
	
	
	public int getBookId() {
		return bookId;
	}




	public void setBookId(int bookId) {
		this.bookId = bookId;
	}




	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getReport() {
		return report;
	}

	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
	

}
