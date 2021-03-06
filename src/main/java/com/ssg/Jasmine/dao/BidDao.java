package com.ssg.Jasmine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Bid;

public interface BidDao {
	
	Bid getBid(int bidId) throws DataAccessException;
	
	Bid getBidByAuctionId(int bidId, int auctionId) throws DataAccessException;
	
	String getMaxPrice(int auctionId);
	
	Bid getBidByMaxPrice(int bidPrice, int auctionId);
	
	void createBid(Bid bid) throws DataAccessException;	
	
	List<Bid> getBidByUserId(int userId) throws DataAccessException;
	
	Bid getSuccessBidByAuctionId(int auctionId) throws DataAccessException;
	
	Bid getBidByUserIdAndAuctionId(int userId, int auctionId);
	
	void updateBid(Bid bid) throws DataAccessException;
	
}
