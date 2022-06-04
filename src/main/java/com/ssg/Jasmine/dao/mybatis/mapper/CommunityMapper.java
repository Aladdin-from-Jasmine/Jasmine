package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import org.apache.ibatis.annotations.Mapper;
import com.ssg.Jasmine.domain.Community;

@Mapper
public interface CommunityMapper {
	
	Community getCommunity(int postId) throws DataAccessException;
	
	Community getCommunityByUserId(String userId) throws DataAccessException;
	
	void createPost(Community community) throws DataAccessException;

	void updatePost(Community community) throws DataAccessException;

	void deletePost(int postId) throws DataAccessException;

	List<Community> getCommunityList() throws DataAccessException;	

	List<Community> getUserCommunityList(String userId) throws DataAccessException;	
}
