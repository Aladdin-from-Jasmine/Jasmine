package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.UserDao;
import com.ssg.Jasmine.dao.mybatis.mapper.UserMapper;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.User;

@Repository
public class MybatisUserDao implements UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String userId, String password) throws DataAccessException {
		return userMapper.getUser(userId, password);
	}
	
	public User getUserByEmail(String userId) throws DataAccessException {
		return userMapper.getUserByEmail(userId);
	}
	
	public User getUserByUserId(String userId) throws DataAccessException {
		return userMapper.getUserByUserId(userId);
	}
	
	public void createUser(User user) throws DataAccessException {
		userMapper.createUser(user);
	}

	public int updateUser(User user) throws DataAccessException {
		return userMapper.updateUser(user);
	}

	public int deleteUser(User user) throws DataAccessException {
		return userMapper.deleteUser(user);
	}

	@Override
	public List<Auction> getAuctionList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

