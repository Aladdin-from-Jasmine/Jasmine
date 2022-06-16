package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Book;

public interface BookService {
	Book getBookByBookId(int bookId);
	
	List<Book> getBookByUserId(String userId);
	
	int createBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(int bookId);

	List<Book> getBookList();
}