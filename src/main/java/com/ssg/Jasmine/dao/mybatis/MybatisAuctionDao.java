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
	public Integer getSuccessBidderUserId(int auctionId) {
		return auctionMapper.getSuccessBidderUserId(auctionId);
	}
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) {
		return successBidderMapper.getSuccessBidderByAuctionId(auctionId);
	}
	
//	keyword로 검색
	public List<Auction> auctionListByKeyword(String keyword) {
		return auctionMapper.auctionListByKeyword(keyword);
	}
}