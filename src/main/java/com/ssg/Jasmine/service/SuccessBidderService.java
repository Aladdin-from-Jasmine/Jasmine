package com.ssg.Jasmine.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

public interface SuccessBidderService {
	
	SuccessBidder getSuccessBidder(int bidId);
	
	int createSuccessBidder(SuccessBidder successBidder);
	
	//int updateAuction(Auction auction);
	
	//int updateStateAuction(int auctionId, String state);
	
	//int updateAuctionMaxPrice(int maxPrice, int auctionId);
	
	//List<SuccessBidder> deleteAuction(int auctionId);
	
	List<SuccessBidder> getSuccessBidderList();
	
	List<Auction> getSuccessBidderListByUserId(String userId);
	
	//List<Auction> getSearchAuctionList(String keyword);
	
	public String getSuccessBidderUserId(String userId);
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId);
	
}
