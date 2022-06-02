package com.ssg.Jasmine.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

public interface AuctionService {
	
	Auction getAuction(int auctionId);
	
	int createAuction(Auction auction);
	
	int updateAuction(Auction auction);
	
	int updateAuctionMaxPrice(int maxPrice, int auctionId);
	
	List<Auction> deleteAuction(int auctionId);
	
	List<Auction> getAuctionList();
	
	boolean isAuctionClosed(int auctionId, Date endDate);
	
	void increaseCount(Auction auction);
	
	List<Auction> getRecentAuctionList();
	
	public void deadLineScheduler(Date endDate, int auctionId);
	
	public Integer getSuccessBidderUserId(int auctionId);
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId);
	
}
