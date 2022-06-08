package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.BookDao;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired(required=false)
	private BookDao bookDao;
	
	@Autowired(required=false)
	private ThreadPoolTaskScheduler scheduler;

	@Override
	public Book getBookByBookId(int bookId) {
		// TODO Auto-generated method stub
		return bookDao.getBookByBookId(bookId);
	}

	@Override
	public int createBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.insertBook(book);
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}