package com.ssg.Jasmine.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.Book;

@Mapper
public interface BookMapper {

	//Book getBook(String BookId, String password);
	
	//Book getBookByEmail(String email);
	
	Book getBookByBookId(int BookId);
	
	void createBook(Book book);

	int updateBook(Book book);

	int deleteBook(Book book);
}
