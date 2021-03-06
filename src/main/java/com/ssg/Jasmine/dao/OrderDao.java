package com.ssg.Jasmine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Order;

public interface OrderDao {

	  Order getOrder(int orderId) throws DataAccessException;

	  void createAuctionOrder(Order order) throws DataAccessException;

	  void createBookOrder(Order order) throws DataAccessException;
	  
	  int getOrderByAuctionId(int auctionId) throws DataAccessException;
	  
	  Order getOrderByAuctionId2(int auctionId) throws DataAccessException;
	
	  int getOrderByBookId(int bookId) throws DataAccessException;
	  
	  Order getOrderByBookId2(int bookId) throws DataAccessException;
	  
	  List<Order> getOrderListByUserId(String userId) throws DataAccessException;
	  
	  List<Auction> getAuctionListByUserId(String userId) throws DataAccessException;

	  // orderList에서 경매 정보 출력을 위해서 필요
	  int getAuctionId(int orderId) throws DataAccessException; // From SuccessBidders

	  int getBookId(int orderId) throws DataAccessException;
}
