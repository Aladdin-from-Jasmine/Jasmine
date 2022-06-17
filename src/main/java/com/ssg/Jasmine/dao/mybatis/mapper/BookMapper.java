package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.controller.book.ListBookCriteria;
import com.ssg.Jasmine.domain.Book;

@Mapper
public interface BookMapper {
	
	Book getBookByBookId(int BookId);
	
	List<Book> getBookByUserId(String userId);
	
	int createBook(Book book);

	void updateBook(Book book);

	void deleteBook(int BookId);
	
	List<Book> getBookList();
	
	int bookListCnt();
	
	List<Book> bookList(ListBookCriteria cri);
}
