package com.ssg.Jasmine.service;

import java.util.List;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.User;

public interface OrderService {
	
	public User getUser(String userId);
	
	public Order getOrder(int orderId); // DetailOrderController에서 사용
	
	public int createOrder(Order order);
	
	public Auction getAuction(int orderId);
	
	public List<Order> getOrderListByUserId(String userId);
	
	public List<Auction> getAuctionListByUserId(String userId);
	
	public List<Order> setAuctionInfo(List<Order> orderList);
	
}
