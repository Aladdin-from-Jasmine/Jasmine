package com.ssg.Jasmine.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.domain.SuccessBidder;

public interface AuctionService {
	
	Auction getAuction(int auctionId);
	
	int createAuction(Auction auction);
	
	int updateAuction(Auction auction);
	
	int updateStateAuction(int auctionId, String state);
	
	int updateAuctionMaxPrice(int maxPrice, int auctionId);
	
	List<Auction> deleteAuction(int auctionId);
	
	List<Auction> getAuctionList();
	
	// 검색 후 proceed로 정렬
	List<Auction> getSearchProceedAuctionList(String keyword) throws DataAccessException;

	// 그냥 proceed로 정렬
	List<Auction> getAuctionProceedList(String sortItem) throws DataAccessException;

	// 검색 후 closed으로 정렬
	List<Auction> getSearchClosedAuctionList(String keyword) throws DataAccessException;

	// 그냥 closed로 정렬
	List<Auction> getAuctionClosedList(String sortItem) throws DataAccessException;
	
	List<Auction> getSearchAuctionList(String keyword);
	
	List<Auction> getAuctionListByUserId(String userId);
	
	List<Auction> getAuctionTop3();
	
	boolean isAuctionClosed(int auctionId, Date endDate);
	
	void increaseCount(Auction auction);
	
	List<Auction> getRecentAuctionList();
	
	public void deadLineScheduler(Date endDate, int auctionId);
	
	public String getSuccessBidderUserId(int auctionId);
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId);
	
}
