package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Book;

public interface BookService {
	Book getBookByBookId(int bookId);
	
	List<Book> getBookByUserId(String userId);
	
	int createBook(Book book);
	
	int updateBook(Book book);
	
	int deleteBook(Book book);

	List<Book> getBookList();
}