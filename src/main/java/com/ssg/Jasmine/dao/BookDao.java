package com.ssg.Jasmine.dao;

import com.ssg.Jasmine.domain.Book;

public interface BookDao {
	Book getBook(String name);
	
	void insertBook(Book book);
	
	void updateBook(Book book);
	
}
