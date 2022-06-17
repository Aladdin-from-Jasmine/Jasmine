package com.ssg.Jasmine.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.AuctionDao;
import com.ssg.Jasmine.dao.BidDao;
import com.ssg.Jasmine.dao.SuccessBidderDao;
//import com.ssg.Jasmine.dao.NotificationDao;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.SuccessBidderService;


@Service
public class SuccessBidderServiceImpl implements SuccessBidderService {
	
	@Autowired
	private SuccessBidderDao successBidderDao;

	@Override
	public SuccessBidder getSuccessBidder(int bidId) throws DataAccessException {
		return successBidderDao.getSuccessBidder(bidId);
	}

	@Override
	public int createSuccessBidder(SuccessBidder successBidder) throws DataAccessException {
		return successBidderDao.createSuccessBidder(successBidder);
	}

	@Override
	public List<SuccessBidder> getSuccessBidderList() throws DataAccessException {
		return successBidderDao.getSuccessBidderList();
	}
	
	@Override
	public String getSuccessBidderUserId(String userId) throws DataAccessException {
		return successBidderDao.getSuccessBidderUserId(userId);
	}

	@Override
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) throws DataAccessException {
		return successBidderDao.getSuccessBidderByAuctionId(auctionId);
	}

	@Override
	public List<Auction> getSuccessBidderListByUserId(String userId) {
		return successBidderDao.getSuccessBidderListByUserId(userId);
	}

}
