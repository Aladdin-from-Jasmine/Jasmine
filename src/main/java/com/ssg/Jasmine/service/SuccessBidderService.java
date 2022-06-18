package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

public interface SuccessBidderService {
	
	SuccessBidder getSuccessBidder(int bidId);
	
	int createSuccessBidder(SuccessBidder successBidder);
	
	List<SuccessBidder> getSuccessBidderList();
	
	List<Auction> getSuccessBidderListByUserId(String userId);
	
	public String getSuccessBidderUserId(String userId);
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId);
	
}
