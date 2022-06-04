package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Book;

public interface BookService {
	Book getBook(String bookId);
	
	int createBook(Book book);
	
	int updateBook(Book book);
	
	List<Book> getBookList();
}