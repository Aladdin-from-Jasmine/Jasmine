package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.CommunityDao;
import com.ssg.Jasmine.dao.mybatis.mapper.CommunityMapper;
import com.ssg.Jasmine.domain.Community;

@Repository
public class MybatisCommunityDao implements CommunityDao {
	
	@Autowired
	private CommunityMapper communityMapper;
	
	public Community getCommunity(int postId) throws DataAccessException
	{
		return communityMapper.getCommunity(postId);		
	}
	
	public Community getCommunityByUserId(String userId) throws DataAccessException
	{
		return communityMapper.getCommunityByUserId(userId);
	}
	
	public void createPost(Community community) throws DataAccessException
	{
		communityMapper.createPost(community);
	}

	public void updatePost(Community community) throws DataAccessException
	{
		communityMapper.updatePost(community);
	}

	public void deletePost(int postId) throws DataAccessException
	{
		communityMapper.deletePost(postId);
	}

	public List<Community> getCommunityList() throws DataAccessException
	{
		return communityMapper.getCommunityList();
	}
	
	public List<Community> getUserCommunityList(String userId) throws DataAccessException
	{
		return communityMapper.getUserCommunityList(userId);
	}
}