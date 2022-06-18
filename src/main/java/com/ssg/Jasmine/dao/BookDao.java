package com.ssg.Jasmine.dao;

import java.util.List;

import com.ssg.Jasmine.domain.Book;

public interface BookDao {
	Book getBookByBookId(int bookId);
	
	List<Book> getBookByUserId(String userId);
	
	int insertBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(int bookId); 
	
	List<Book> getBookList();
	
	List<Book> getBookRecent3();
	
	List<Book> getSearchBookList(String keyword);

	
}
