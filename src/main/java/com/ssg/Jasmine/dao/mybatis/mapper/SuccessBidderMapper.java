package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.SuccessBidder;

@Mapper
public interface SuccessBidderMapper {
	
	SuccessBidder getSuccessBidder(int bidId);
	
	int createSuccessBidder(SuccessBidder successBidder);
	
	List<SuccessBidder> getSuccessBidderList();
	
	public String getSuccessBidderUserId(String userId);
	
	public SuccessBidder getSuccessBidderByAuctionId(int auctionId);
}
