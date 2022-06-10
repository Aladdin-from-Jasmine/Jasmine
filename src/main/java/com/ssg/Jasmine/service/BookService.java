package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Book;

public interface BookService {
	Book getBookByBookId(int bookId);
	
	int createBook(Book book);
	
	int updateBook(Book book);
	
	int deleteBook(Book book);

	List<Book> getBookList();
}