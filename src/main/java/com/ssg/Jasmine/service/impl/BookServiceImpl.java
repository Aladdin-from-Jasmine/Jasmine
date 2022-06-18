package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.BookDao;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	public Book getBookByBookId(int bookId) {
		return bookDao.getBookByBookId(bookId);
	}

	@Override
	public int createBook(Book book) {
		return bookDao.insertBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
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
	public List<Book> getBookRecent3() {
		return bookDao.getBookRecent3();
	}
	
	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public List<Book> getSearchBookList(String keyword) {
		return bookDao.getSearchBookList(keyword);	
	}
}