package com.ssg.Jasmine.dao;
//
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.Community;
//import com.ssg.Jasmine.domain.GroupBuy; - 우리에겐 없는 기능인듯
import com.ssg.Jasmine.domain.SuccessBidder;

public interface AuctionDao {
	
	Auction getAuction(int auctionId) throws DataAccessException;
	
//	Return auctionID
	int createAuction(Auction auction) throws DataAccessException;
//	Return auctionID
	int updateAuction(Auction auction) throws DataAccessException;
	
	int updateStateAuction(int auctionId, String state) throws DataAccessException;
	
	int updateAuctionMaxPrice(int maxPrice, int auctionId) throws DataAccessException;
	
	void deleteAuction(int auctionId) throws DataAccessException;
	
	List<Auction> getAuctionList() throws DataAccessException;
	
	List<Auction> getSearchAuctionList(String keyword) throws DataAccessException;
	
	List<Auction> getAuctionListByUserId(String userId) throws DataAccessException;
	
	List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException;
	
	List<Auction> getAuctionTop3() throws DataAccessException;
	
	boolean isAuctionClosed(int auctionId, Date currentTime) throws DataAccessException;
	
	void increaseCount(Auction auction) throws DataAccessException;
	
	List<Auction> getRecentAuctionList() throws DataAccessException;
//	스케줄러
	void closeEvent(Date curTime);
	
	public String getSuccessBidderUserId(int auctionId);
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId);
	
//	keyword로 검색
	public List<Auction> auctionListByKeyword(String keyword);
	

	// 검색 후 proceed로 정렬
	List<Auction> getSearchProceedAuctionList(String keyword) throws DataAccessException;

	// 그냥 proceed로 정렬
	List<Auction> getAuctionProceedList(String sortItem) throws DataAccessException;

	// 검색 후 closed으로 정렬
	List<Auction> getSearchClosedAuctionList(String keyword) throws DataAccessException;

	// 그냥 closed로 정렬
	List<Auction> getAuctionClosedList(String sortItem) throws DataAccessException;	



}
