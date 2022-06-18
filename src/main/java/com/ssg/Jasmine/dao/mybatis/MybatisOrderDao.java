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
	public Order getOrderWithLineGroupBuys(int orderId) throws DataAccessException {
		return orderMapper.getOrderWithLineGroupBuys(orderId);
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
		return orderMapper.getAuctionId(orderId);
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
