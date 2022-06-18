package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.AuctionDao;
import com.ssg.Jasmine.dao.BookDao;
import com.ssg.Jasmine.dao.OrderDao;
import com.ssg.Jasmine.dao.UserDao;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;

	@Override
	public User getUser(String emailId) {
		return userDao.getUserByEmail(emailId);
	}

	@Override
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}
	
	@Override
	public int getOrderByAuctionId(int auctionId) {
		return orderDao.getOrderByAuctionId(auctionId);
	}
	
	@Override
	public int getOrderByBookId(int bookId) {
		return orderDao.getOrderByBookId(bookId);
	}
	
	@Override
	public Order getOrderByBookId2(int bookId) {
		return orderDao.getOrderByBookId2(bookId);
	}

	@Override
	public int createAuctionOrder(Order order) {
		try {
			orderDao.createAuctionOrder(order);
		} catch(DataAccessException ex) {
			return 0;
		}
		return 1;
	}
	
	@Override
	public int createBookOrder(Order order) {
		try {
			orderDao.createBookOrder(order);
		} catch(DataAccessException ex) {
			return 0;
		}
		return 1;
	}
	
	public Auction getAuction(int orderId) {
		int auctionId = orderDao.getAuctionId(orderId);
		if(auctionId > 0) {
			return auctionDao.getAuction(auctionId);
		}
		else {
			return null;
		}
	}
	
	public Book getBook(int orderId) {
		int bookId = orderDao.getBookId(orderId);
		return bookDao.getBookByBookId(bookId);
	}
	
	public List<Order> setAuctionInfo(List<Order> auctionOrderList) {
		
		if (auctionOrderList == null) {
			return null;
		}
		
		for (Order order : auctionOrderList) {
			int auctionId = order.getAuctionId();
			order.setAuction(auctionDao.getAuction(auctionId));
		}
		return auctionOrderList;
	}

	@Override
	public List<Order> getOrderListByUserId(String userId) {
		return orderDao.getOrderListByUserId(userId);
	}

	@Override
	public List<Auction> getAuctionListByUserId(String userId) {
		return orderDao.getAuctionListByUserId(userId);
	}

}
