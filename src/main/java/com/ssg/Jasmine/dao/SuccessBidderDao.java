package com.ssg.Jasmine.dao;
//
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Bid;
//import com.ssg.Jasmine.domain.GroupBuy; - 우리에겐 없는 기능인듯
import com.ssg.Jasmine.domain.SuccessBidder;

public interface SuccessBidderDao {

	SuccessBidder getSuccessBidder(int bidId) throws DataAccessException;
	
	int createSuccessBidder(SuccessBidder successBidder) throws DataAccessException;
	
	//int updateAuction(Auction auction);
	
	//int updateStateAuction(int auctionId, String state);
	
	//int updateAuctionMaxPrice(int maxPrice, int auctionId);
	
	//List<SuccessBidder> deleteAuction(int auctionId);
	List<Auction> getSuccessBidderListByUserId(String userId) throws DataAccessException;
	
	List<SuccessBidder> getSuccessBidderList() throws DataAccessException;
	
	//List<Auction> getSearchAuctionList(String keyword);

	public String getSuccessBidderUserId(String userId) throws DataAccessException;
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) throws DataAccessException;
}
