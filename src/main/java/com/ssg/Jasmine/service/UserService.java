package com.ssg.Jasmine.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.User;

public interface UserService {

	User getUser(String userId, String password); 
	
	User getUserByUserId(String userId) throws DataAccessException;
	
	void createUser(User user);

	int updateUser(User user);

	int deleteUser(User user);
	
	List<Auction> getAuctionList(String userId); 
	
	boolean isUnClosedExist(String userId);

	User getUserByEmail(String email);
	
}
