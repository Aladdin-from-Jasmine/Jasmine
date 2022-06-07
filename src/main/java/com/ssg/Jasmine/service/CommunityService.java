package com.ssg.Jasmine.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.domain.User;

public interface CommunityService {

	Community getCommunity(int postId) throws DataAccessException;
	
	Community getCommunityByUserId(String userId) throws DataAccessException;
	
	void createPost(Community community) throws DataAccessException;

	void updatePost(Community community) throws DataAccessException;

	void deletePost(int postId) throws DataAccessException;

	List<Community> getCommunityList() throws DataAccessException;
	
	List<Community> getUserCommunityList(String userId) throws DataAccessException;
}
