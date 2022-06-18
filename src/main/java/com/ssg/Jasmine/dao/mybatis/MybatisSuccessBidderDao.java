package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.SuccessBidderDao;
import com.ssg.Jasmine.dao.mybatis.mapper.SuccessBidderMapper;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

@Repository
public class MybatisSuccessBidderDao implements SuccessBidderDao {

	@Autowired
	protected SuccessBidderMapper successBidderMapper;
	
	@Override
	public SuccessBidder getSuccessBidder(int bidId) throws DataAccessException {
		return successBidderMapper.getSuccessBidder(bidId);
	}

	@Override
	public int createSuccessBidder(SuccessBidder successBidder) throws DataAccessException {
		return successBidderMapper.createSuccessBidder(successBidder);
	}

	@Override
	public List<SuccessBidder> getSuccessBidderList() throws DataAccessException {
		return successBidderMapper.getSuccessBidderList();
	}
	
	@Override
	public String getSuccessBidderUserId(String userId) throws DataAccessException {
		return successBidderMapper.getSuccessBidderUserId(userId);
	}

	@Override
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId) throws DataAccessException {
		return successBidderMapper.getSuccessBidderByAuctionId(auctionId);
	}

	@Override
	public List<Auction> getSuccessBidderListByUserId(String userId) throws DataAccessException {
		return successBidderMapper.getSuccessBidderListByUserId(userId);
	}
}
