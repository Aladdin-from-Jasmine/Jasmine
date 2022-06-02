package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.User;

@Mapper
public interface UserMapper {

	User getUser(String userId, String password);
	
	User getUserByEmail(String email);
	
	User getUserByUserId(String userId);
	
	void createUser(User user);

	int updateUser(User user);

	int deleteUser(User user);
	
//	List<Order> getAuctionOrderList(String userId);
//	
//	List<Order> getGroupBuyOrderList(String userId);
//	
//	List<GroupBuy> getGroupBuyList(String userId); // 마이페이지 공동구매 등록 목록 보기
//	
	List<Auction> getAuctionList(String userId); // 마이페이지 경매 등록 목록 보기
}

