package com.ssg.Jasmine.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.AuctionDao;
import com.ssg.Jasmine.dao.mybatis.mapper.AuctionMapper;
import com.ssg.Jasmine.dao.mybatis.mapper.SuccessBidderMapper;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

@Repository
public class MybatisAuctionDao implements AuctionDao {

	private static final String closed = "closed";
	
	@Autowired
	protected AuctionMapper auctionMapper;
	@Autowired
	protected SuccessBidderMapper successBidderMapper;
	
	@Override
	public Auction getAuction(int auctionId) throws DataAccessException {
		Auction auction = auctionMapper.getAuctionWithBids(auctionId);
		if (auction == null) {
			auction = auctionMapper.getAuction(auctionId);			
		}
		return auction;
	}

	@Override
	public int createAuction(Auction auction) throws DataAccessException {
		auctionMapper.createAuction(auction);
		return auction.getAuctionId();
	}

	@Override
	public int updateAuction(Auction auction) throws DataAccessException {
		auctionMapper.updateAuction(auction);
		System.out.println(auction.getAuctionId());
		return auction.getAuctionId();
	}
	
	@Override
	public int updateStateAuction(int auctionId, String state) throws DataAccessException {
		auctionMapper.updateStateAuction(auctionId, state);
		return auctionId;
	}
	
	@Override
	public int updateAuctionMaxPrice(int maxPrice, int auctionId) throws DataAccessException {
		auctionMapper.updateAuctionMaxPrice(maxPrice, auctionId);
		return auctionId;
	}

	@Override
	public void deleteAuction(int auctionId) throws DataAccessException {
		auctionMapper.deleteAuction(auctionId);
	}

	@Override
	public List<Auction> getAuctionList() throws DataAccessException {
		return auctionMapper.getAuctionList();
	}
	
	@Override
	public List<Auction> getSearchAuctionList(String keyword) throws DataAccessException {
		return auctionMapper.getSearchAuctionList(keyword);
	}

	@Override
	public List<Auction> getAuctionListByKeyword(String keyword) throws DataAccessException {
		return auctionMapper.getAuctionListByKeyword(keyword);
	}

	@Override
	public boolean isAuctionClosed(int auctionId, Date currentTime) throws DataAccessException {
		Auction auction = auctionMapper.getAuction(auctionId);
		if (auction.getEndDate().compareTo(currentTime) == 0) {
			auction.setState(closed);
			updateAuction(auction);
			return true;
		}
		else
			return false;
	}

	@Override
	public void increaseCount(Auction auction) throws DataAccessException {
		auctionMapper.increaseCount(auction);
	}
	
	public List<Auction> getRecentAuctionList() throws DataAccessException {
		return auctionMapper.getRecentAuctionList();
	}
//	스케줄러
	public void closeEvent(Date curTime) {
		auctionMapper.closeEvent(curTime);
	}
		
	@Override
	public String getSuccessBidderUserId(int auctionId) {
		return auctionMapper.getSuccessBidderUserId(auctionId);
	}
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) {
		return successBidderMapper.getSuccessBidderByAuctionId(auctionId);
	}
	
//	keyword로 검색
	public List<Auction> auctionListByKeyword(String keyword) {
		return auctionMapper.auctionListByKeyword(keyword);
	}

	@Override
	public List<Auction> getAuctionListByUserId(String userId) throws DataAccessException {
		return auctionMapper.getAuctionListByUserId(userId);
	}

	@Override
	public List<Auction> getAuctionTop3() throws DataAccessException {
		return auctionMapper.getAuctionTop3();
	}

	@Override
	public List<Auction> getSearchProceedAuctionList(String keyword) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionMapper.getSearchProceedAuctionList(keyword);
	}

	@Override
	public List<Auction> getAuctionProceedList(String sortItem) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionMapper.getAuctionProceedList(sortItem);
	}

	@Override
	public List<Auction> getSearchClosedAuctionList(String keyword) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionMapper.getSearchClosedAuctionList(keyword);
	}

	@Override
	public List<Auction> getAuctionClosedList(String sortItem) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionMapper.getAuctionClosedList(sortItem);
	}
}
