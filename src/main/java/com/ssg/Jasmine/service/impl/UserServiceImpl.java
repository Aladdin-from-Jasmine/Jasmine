package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.UserDao;
import com.ssg.Jasmine.domain.Auction;
//import com.ssg.Jasmine.domain.GroupBuy;
//import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	//@Autowired(required=false)
	@Autowired
	private UserDao userDao;
	
	public User getUser(String userId, String password) {
		return userDao.getUser(userId, password);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public User getUserByUserId(String userId) throws DataAccessException {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return userDao.deleteUser(user);
	}
//
//	@Override
//	public List<Order> getAuctionOrderList(int userId) { // 마이페이지 결제 목록 보기
//		return userDao.getAuctionOrderList(userId);
//	}
//	
//	@Override
//	public List<Order> getGroupBuyOrderList(int userId) { // 마이페이지 결제 목록 보기
//		return userDao.getGroupBuyOrderList(userId);
//	}
//	
//	@Override	
//	public List<GroupBuy> getGroupBuyList(int userId) { // 마이페이지 공동구매 등록 목록 보기
//		return userDao.getGroupBuyList(userId);
//	}
//	
	@Override	
	public List<Auction> getAuctionList(String userId) { // 마이페이지 경매 등록 목록 보기
		return userDao.getAuctionList(userId);
	}
	
	public boolean isUnClosedExist(String userId) {
//		List<GroupBuy> groupBuys = userDao.getGroupBuyList(userId);
		List<Auction> auctions = userDao.getAuctionList(userId);
		
//		if (groupBuys != null && auctions != null) {
//			for (GroupBuy groupBuy : groupBuys) {
//				if (!groupBuy.getState().equals("closed")) {
//					return true;
//				}
//			}
//			
			for (Auction auction : auctions) {
				if (!auction.getState().equals("closed")) {
					return true;
				}
			}
		
		return false;
	}

}