package com.ssg.Jasmine.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

public interface SuccessBidderDao {

	SuccessBidder getSuccessBidder(int bidId) throws DataAccessException;
	
	int createSuccessBidder(SuccessBidder successBidder) throws DataAccessException;

	List<Auction> getSuccessBidderListByUserId(String userId) throws DataAccessException;
	
	List<SuccessBidder> getSuccessBidderList() throws DataAccessException;

	public String getSuccessBidderUserId(String userId) throws DataAccessException;
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) throws DataAccessException;
}
