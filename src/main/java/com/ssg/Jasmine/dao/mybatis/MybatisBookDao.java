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
		return bookMapper.getBookByBookId(BookId);
	}

	@Override
	public int insertBook(Book book) {
		return bookMapper.createBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookMapper.updateBook(book);	
	}	
	
	@Override
	public void deleteBook(int bookId) {
		bookMapper.deleteBook(bookId);
	}
	
	
	public List<Book> getBookList() {
		return bookMapper.getBookList();
	}

	@Override
	public List<Book> getBookByUserId(String userId) {
		return bookMapper.getBookByUserId(userId);
	}

	@Override
	public List<Book> getBookRecent3() {
		// TODO Auto-generated method stub
		return bookMapper.getBookRecent3();
	}

	@Override
	public List<Book> getSearchBookList(String keyword) {
		// TODO Auto-generated method stub
		return bookMapper.getSearchBookList(keyword);
	}

}
