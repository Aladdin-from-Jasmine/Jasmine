package com.ssg.Jasmine.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.BookDao;
import com.ssg.Jasmine.dao.mybatis.mapper.BookMapper;
import com.ssg.Jasmine.domain.Book;

@Repository
public class MybatisBookDao implements BookDao{

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public Book getBookByBookId(int BookId) {
		// TODO Auto-generated method stub
		return bookMapper.getBookByBookId(BookId);
	}

	@Override
	public void insertBook(Book book) {
		// TODO Auto-generated method stub
		
		bookMapper.createBook(book);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.updateBook(book);
		
	}
	
	
	public void deleteBook(Book book) {
		bookMapper.deleteBook(book);
	}
	

}
