package com.ssg.Jasmine.service;

import java.util.List;
import java.util.Map;

import com.ssg.Jasmine.controller.book.ListBookCriteria;
import com.ssg.Jasmine.domain.Book;

public interface BookService {
	Book getBookByBookId(int bookId);
	
	List<Book> getBookByUserId(String userId);
	
	int createBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(int bookId);

	List<Book> getBookList();

	int bookListCnt();
	
	List<Book> bookList(ListBookCriteria cri);

}