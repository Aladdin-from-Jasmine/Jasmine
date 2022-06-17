package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.AuctionDao;
import com.ssg.Jasmine.dao.OrderDao;
import com.ssg.Jasmine.dao.UserDao;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	//@Autowired
	private OrderDao orderDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String emailId) {
		return userDao.getUserByEmail(emailId);
	}

	@Override
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	@Override
	public int createOrder(Order order) {
		try {
			orderDao.createOrder(order);
		} catch(DataAccessException ex) {
			return 0;
		}
		return 1;
	}
	
//	@Override
//	public Order getOrderWithLineGroupBuys(int orderId) {
//		return orderDao.getOrderWithLineGroupBuys(orderId);
//	}
	
	public Auction getAuction(int orderId) {
		int auctionId = orderDao.getAuctionId(orderId);
		return auctionDao.getAuction(auctionId);
	}
	
	public List<Order> setAuctionInfo(List<Order> auctionOrderList) {
		
		if (auctionOrderList == null) {
			return null;
		}
		
		for (Order order : auctionOrderList) {
			int auctionId = order.getAuctionId();
			order.setAuction(auctionDao.getAuction(auctionId));
			order.setMenuId(1);
		}
		return auctionOrderList;
	}
	
//	public List<Order> setGroupBuyInfo(List<Order> groupBuyOrderList) {
//		
//		if (groupBuyOrderList == null) {
//			return null;
//		}
//		
//		for (Order order : groupBuyOrderList) {
//			int groupBuyId = order.getGroupBuyId();
//			order.setGroupBuy(groupBuyDao.getGroupBuy(groupBuyId));
//			order.setMenuId(2);
//		}
//		return groupBuyOrderList;
//	}

}
