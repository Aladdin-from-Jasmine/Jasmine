package com.ssg.Jasmine.domain;

import java.io.Serializable;

public class SuccessBidder implements Serializable{
	int bidId;
	String userId;
	int orderId;
	int auctionId;
	
	String orderState;

	public SuccessBidder() {}
	public SuccessBidder(int bidId, String userId, int auctionId) {
		this.bidId = bidId;
		this.userId = userId;
		this.auctionId = auctionId;
	}
	
	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public String getOrderState() {
		return orderState;
	}
	
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	@Override
	public String toString() {
		return "SuccessBidder [bidId=" + bidId + ", userId=" + userId + ", orderId=" + orderId + ", auctionId="
				+ auctionId + "]";
	}
	
}
