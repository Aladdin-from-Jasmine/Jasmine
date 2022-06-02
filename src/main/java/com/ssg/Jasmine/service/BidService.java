package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Bid;

public interface BidService {
	
	Bid getBid(int bidId);
	
	Bid getBidByAuctionId(int bidId, int auctionId);
	
	String getMaxPrice(int auctionId);
	
	Bid getBidByMaxPrice(int bidPrice, int auctionId);
	
	void createBid(Bid bid);
	
	List<Bid> getBidByUserId(String userId);
	
	Bid getBidByUserIdAndAuctionId(String userId, int auctionId);
	
	void updateBid(Bid bid);
	
}
