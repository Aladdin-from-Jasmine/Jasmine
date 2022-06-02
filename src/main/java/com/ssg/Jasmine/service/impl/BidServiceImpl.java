package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.BidDao;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.service.BidService;


@Service
public class BidServiceImpl implements BidService{

	@Autowired(required=false)
	private BidDao bidDao;
	
	public Bid getBid(int bidId) {
		return bidDao.getBid(bidId);
	}

	public Bid getBidByAuctionId(int bidId, int auctionId) {
		return bidDao.getBidByAuctionId(bidId, auctionId);
	}
	
	public String getMaxPrice(int auctionId) {
		return bidDao.getMaxPrice(auctionId);
	}
	
	public Bid getBidByMaxPrice(int bidPrice, int auctionId) {
		return bidDao.getBidByMaxPrice(bidPrice, auctionId);
	}

	public void createBid(Bid bid) {
		bidDao.createBid(bid);
	}

	public List<Bid> getBidByUserId(int userId) {
		return bidDao.getBidByUserId(userId);
	}
	
	public Bid getBidByUserIdAndAuctionId(int userId, int auctionId) {
		return bidDao.getBidByUserIdAndAuctionId(userId, auctionId);
	}
	
	public void updateBid(Bid bid) {
		bidDao.updateBid(bid);
	}

	@Override
	public List<Bid> getBidByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bid getBidByUserIdAndAuctionId(String userId, int auctionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
