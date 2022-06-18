package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.Jasmine.dao.OrderDao;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.dao.mybatis.mapper.OrderMapper;
import com.ssg.Jasmine.dao.mybatis.mapper.SuccessBidderMapper;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	@Autowired
	protected SuccessBidderMapper successBidderMapper;
	
	@Override
	public Order getOrder(int orderId) throws DataAccessException {
	    Order order = orderMapper.getOrder(orderId);
	    return order;
	}
	
	@Override
	public int getOrderByAuctionId(int auctionId) throws DataAccessException {
	    return orderMapper.getOrderByAuctionId(auctionId);
	}
	
	@Override
	public Order getOrderByAuctionId2(int auctionId) throws DataAccessException {
	    return orderMapper.getOrderByAuctionId2(auctionId);
	}

	@Override
	public int getOrderByBookId(int bookId) throws DataAccessException {
	    return orderMapper.getOrderByBookId(bookId);
	}
	
	@Override
	public Order getOrderByBookId2(int bookId) throws DataAccessException {
	    return orderMapper.getOrderByBookId2(bookId);
	}

	@Override
	@Transactional
	public void createAuctionOrder(Order order) throws DataAccessException{
		orderMapper.createAuctionOrder(order);
	}

	@Override
	@Transactional
	public void createBookOrder(Order order) throws DataAccessException{
		orderMapper.createBookOrder(order);
	}

	@Override
	public int getAuctionId(int orderId) throws DataAccessException { // From SuccessBidders
		int auctionId = orderMapper.getAuctionId(orderId);
		if(auctionId > 0) {
			return auctionId;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public int getBookId(int orderId) throws DataAccessException {
		return orderMapper.getBookId(orderId);
	}

	@Override
	public List<Order> getOrderListByUserId(String userId) throws DataAccessException {
		return orderMapper.getOrderListByUserId(userId);
	}

	@Override
	public List<Auction> getAuctionListByUserId(String userId) throws DataAccessException {
		return orderMapper.getAuctionListByUserId(userId);
	}

	
}
