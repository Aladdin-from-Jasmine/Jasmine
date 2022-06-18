package com.ssg.Jasmine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Order;

public interface OrderDao {

	  Order getOrder(int orderId) throws DataAccessException;

	  void createOrder(Order order) throws DataAccessException;
	  
	  int getOrderByAuctionId(int auctionId) throws DataAccessException;
	  
	  Order getOrderWithLineGroupBuys(int orderId) throws DataAccessException;
		
	  List<Order> getOrderListByUserId(String userId) throws DataAccessException;
	  
	  List<Auction> getAuctionListByUserId(String userId) throws DataAccessException;

	  int getAuctionId(int orderId) throws DataAccessException; 
}
