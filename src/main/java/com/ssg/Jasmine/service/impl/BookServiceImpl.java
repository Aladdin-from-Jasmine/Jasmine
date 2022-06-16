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
	
	@Autowired
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
		return bookDao.insertBook(book);
	}

	@Override
	public void updateBook(Book book) {
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}
	
	@Override
	public List<Book> getBookByUserId(String userId) {
		return bookDao.getBookByUserId(userId);
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(bookId);
	}
	
}