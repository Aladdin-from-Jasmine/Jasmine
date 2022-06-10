package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

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
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		
		return bookMapper.createBook(book);
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.updateBook(book);
		
	}
	
	
	public int deleteBook(Book book) {
		return bookMapper.deleteBook(book);
	}
	
	
	public List<Book> getBookList() {
		return bookMapper.getBookList();
	}

}
