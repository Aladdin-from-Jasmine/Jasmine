package com.ssg.Jasmine.dao;

import java.util.List;

import com.ssg.Jasmine.domain.Book;

public interface BookDao {
	Book getBookByBookId(int bookId);
	
	List<Book> getBookByUserId(String userId);
	
	int insertBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(Book book); //근데 bookId로 하는게 나을거같기두..???
	
	List<Book> getBookList();

	
}
