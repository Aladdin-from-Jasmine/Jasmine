package com.ssg.Jasmine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.domain.User;

public interface CommunityDao {

	Community getCommunity(int communityId) throws DataAccessException;
	
	Community getCommunityByUserId(String userId) throws DataAccessException;

	void createPost(Community community) throws DataAccessException;

	void updatePost(Community community) throws DataAccessException;

	void deletePost(int communityId) throws DataAccessException;

	List<Community> getCommunityList() throws DataAccessException;	

	List<Community> getUserCommunityList(String userId) throws DataAccessException;	
}