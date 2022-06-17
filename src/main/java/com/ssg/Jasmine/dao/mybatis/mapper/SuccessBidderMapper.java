package com.ssg.Jasmine.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.SuccessBidder;

@Mapper
public interface SuccessBidderMapper {
	
	int insertSuccessBidder(SuccessBidder successBidder);
	
	SuccessBidder getSuccessBidderByAuctionId(int auctionId);
}
