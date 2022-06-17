package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Community;

@Mapper
public interface AuctionMapper { // AuctionMapper.xml에서 구현한 method 이름과 일치해야함!
	
	Auction getAuction(int auctionId) throws DataAccessException;
	
	Auction getAuctionWithBids(int auctionId) throws DataAccessException;
	
	int createAuction(Auction auction) throws DataAccessException;
	
	int updateAuction(Auction auction) throws DataAccessException;
	
	int updateStateAuction(@Param("auctionId")int auctionId, @Param("state")String state) throws DataAccessException;
	
	void updateAuctionMaxPrice(@Param("maxPrice")int maxPrice, @Param("auctionId")int auctionId) throws DataAccessException;
	
	void deleteAuction(int auctionId) throws DataAccessException;
	
	int deleteAuctionByUserId(int userId) throws DataAccessException;
	
	List<Auction> getAuctionList() throws DataAccessException;
	
	List<Auction> getAuctionTop3() throws DataAccessException;
	
	List<Auction> getSearchAuctionList(String keyword) throws DataAccessException;
	
	List<Auction> getAuctionListByUserId(String userId) throws DataAccessException;
	
	List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException;
	
	List<Auction> getRecentAuctionList() throws DataAccessException;
	
	void increaseCount(Auction auction) throws DataAccessException;
	
	void closeEvent(Date curTime);
	
	String getSuccessBidderUserId(int auctionId);
	
	List<Auction> auctionListByKeyword(String keyword);	

	// 검색 후 proceed로 정렬
	List<Auction> getSearchProceedAuctionList(String keyword) throws DataAccessException;

	// 그냥 proceed로 정렬
	List<Auction> getAuctionProceedList(String sortItem) throws DataAccessException;

	// 검색 후 closed으로 정렬
	List<Auction> getSearchClosedAuctionList(String keyword) throws DataAccessException;

	// 그냥 closed로 정렬
	List<Auction> getAuctionClosedList(String sortItem) throws DataAccessException;


}
