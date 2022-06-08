package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.CommunityDao;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.service.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDao communityDao;

	@Override
	public Community getCommunity(int communityId) throws DataAccessException {
		return communityDao.getCommunity(communityId);
	}

	@Override
	public Community getCommunityByUserId(String userId) throws DataAccessException {
		return communityDao.getCommunityByUserId(userId);
	}
	
	@Override
	public void createPost(Community community) throws DataAccessException {
		communityDao.createPost(community);
	}

	@Override
	public void updatePost(Community community) throws DataAccessException {
		communityDao.updatePost(community);
	}

	@Override
	public void deletePost(int communityId) throws DataAccessException {
		communityDao.deletePost(communityId);
	}

	@Override
	public List<Community> getCommunityList() throws DataAccessException {
		return communityDao.getCommunityList();
	}
	
	@Override
	public List<Community> getCommunitySortedList(String sortItem) throws DataAccessException {
		return communityDao.getCommunitySortedList(sortItem);
	}
	
	public List<Community> getUserCommunityList(String userId) throws DataAccessException {
		return communityDao.getUserCommunityList(userId);
	}
}
