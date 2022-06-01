package com.ssg.Jasmine.dao.mybatis.mapper;

import com.ssg.Jasmine.domain.SuccessBidder;

public interface SuccessBidderMapper {
	
	int insertSuccessBidder(SuccessBidder successBidder);
	
	SuccessBidder getSuccessBidderByAuctionId(int auctionId);
}
