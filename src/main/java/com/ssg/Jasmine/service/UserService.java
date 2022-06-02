package com.ssg.Jasmine.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
//import com.ssg.Jasmine.domain.GroupBuy;
//import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.User;

public interface UserService {

	User getUser(String emailId, String password); // 로그인 시 사용
	
	User getUserByEmail(String email);
	
	User getUserByUserId(int userId) throws DataAccessException;
	
	void createUser(User user);

	int updateUser(User user);

	int deleteUser(User user);
	
//	List<Order> getAuctionOrderList(int userId);
//	
//	List<Order> getGroupBuyOrderList(int userId);
//	
//	List<GroupBuy> getGroupBuyList(int userId); // 마이페이지 공동구매 등록 목록 보기
	
	List<Auction> getAuctionList(int userId); // 마이페이지 경매 등록 목록 보기
	
	boolean isUnClosedExist(int userId);
}
