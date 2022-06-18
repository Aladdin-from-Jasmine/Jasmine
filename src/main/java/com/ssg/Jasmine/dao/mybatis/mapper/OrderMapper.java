package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Order;

@Mapper
public interface OrderMapper {

	  Order getOrder(int orderId) throws DataAccessException;

	  int getOrderByAuctionId(int auctionId) throws DataAccessException; // From SuccessBidders
	  
	  Order getOrderByAuctionId2(int auctionId) throws DataAccessException;
	  
	  int getOrderByBookId(int bookId) throws DataAccessException; 
	  
	  Order getOrderByBookId2(int bookId) throws DataAccessException; 
	  
	  int createAuctionOrder(Order order) throws DataAccessException;
	  
	  int createBookOrder(Order order) throws DataAccessException;
	  
	  List<Order> getOrderListByUserId(String userId) throws DataAccessException;
	  
	  List<Auction> getAuctionListByUserId(String userId) throws DataAccessException;

	  // orderList에서 경매 정보 출력을 위해서 필요
	  int getAuctionId(int orderId) throws DataAccessException; // From SuccessBidders
	  
	  int getBookId(int orderId) throws DataAccessException;
	  
	  int deleteOrderByUserId(int userId) throws DataAccessException; // 회원 탈퇴 시 실행
}
