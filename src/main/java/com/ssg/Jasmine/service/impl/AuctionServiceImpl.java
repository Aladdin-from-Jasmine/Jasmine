package com.ssg.Jasmine.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.AuctionDao;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.service.AuctionService;


@Service
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	private AuctionDao auctionDao;
	
	public Auction getAuction(int auctionId) throws DataAccessException {
		return auctionDao.getAuction(auctionId);
	}
	
	public List<Auction> getAuctionList() {
		return auctionDao.getAuctionList();
	}
	
	public List<Auction> getSearchAuctionList(String keyword) {
		return auctionDao.getSearchAuctionList(keyword);
	}

	public int createAuction(Auction auction) {
		return auctionDao.createAuction(auction);
	}

	public int updateAuction(Auction auction) {
		return auctionDao.updateAuction(auction);
	}
	
	public int updateStateAuction(int auctionId, String state) {
		return auctionDao.updateStateAuction(auctionId, state);
	}
	
	public int updateAuctionMaxPrice(int maxPrice, int auctionId) {
		return auctionDao.updateAuctionMaxPrice(maxPrice, auctionId);
	}

	public List<Auction> deleteAuction(int auctionId) {
		auctionDao.deleteAuction(auctionId);			
		return auctionDao.getAuctionList();
	}
	
	public boolean isAuctionClosed(int auctionId, Date endDate) {
		return auctionDao.isAuctionClosed(auctionId, endDate);
	}

	public void increaseCount(Auction auction) {
		auctionDao.increaseCount(auction);
	}
	
	public List<Auction> getRecentAuctionList() {
		return auctionDao.getRecentAuctionList();
	}

	public String getSuccessBidderUserId(int auctionId) {
		return auctionDao.getSuccessBidderUserId(auctionId);
	}
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) {
		return auctionDao.getSuccessBidderByAuctionId(auctionId);
	}

	@Override
	public List<Auction> getAuctionListByUserId(String userId) {
		return auctionDao.getAuctionListByUserId(userId);
	}

	@Override
	public List<Auction> getAuctionTop3() {
		return auctionDao.getAuctionTop3();
	}

	// 검색 후 proceed로 정렬
	@Override
	public List<Auction> getSearchProceedAuctionList(String keyword) throws DataAccessException {
		return auctionDao.getSearchProceedAuctionList(keyword);
	}

	// 그냥 proceed로 정렬
	@Override
	public List<Auction> getAuctionProceedList(String sortItem) throws DataAccessException {
		return auctionDao.getAuctionProceedList(sortItem);
	}

	// 검색 후 closed으로 정렬
	@Override
	public List<Auction> getSearchClosedAuctionList(String keyword) throws DataAccessException {
		return auctionDao.getSearchClosedAuctionList(keyword);
	}

	// 그냥 closed로 정렬
	@Override
	public List<Auction> getAuctionClosedList(String sortItem) throws DataAccessException {
		return auctionDao.getAuctionClosedList(sortItem);
	}	
	
}
