package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.Bid;

@Mapper
public interface BidMapper {

	Bid getBid(int bidId);
	
	Bid getBidByAuctionId(int bidId, int auctionId);
	
	String getMaxPrice(int auctionId);
	
	Bid getBidByMaxPrice(int bidPrice, int auctionId);
	
	void createBid(Bid bid);
	
	List<Bid> getBidByUserId(int userId);
	
	Bid getSuccessBidByAuctionId(int auctionId);

	Bid getBidByUserIdAndAuctionId(int userId, int auctionId); // 수정위해(bid 참여한 적이 있는지 확인위해).
	
	void updateBid(Bid bid);
	
}
