package com.ssg.Jasmine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
//import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.User;


public interface UserDao {

	User getUser(String emailId, String password) throws DataAccessException; // login시 필요
	
	User getUserByEmail(String email) throws DataAccessException; // email로 user객체 얻어옴
	
	User getUserByUserId(String userId) throws DataAccessException; // userId로 user객체 얻어옴
	
	void createUser(User user) throws DataAccessException;

	int updateUser(User user) throws DataAccessException;

	int deleteUser(User user) throws DataAccessException;

	List<Auction> getAuctionList(String userId); // 마이페이지 경매 등록 목록 보기
	
}
