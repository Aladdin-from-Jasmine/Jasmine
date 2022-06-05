package com.ssg.Jasmine.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Bid  implements Serializable{
	int bidId;
	String userId;
	int auctionId;
	@NotNull
	int bidPrice;
	boolean isBidded;
	Date bidDate;
	User user = new User();
	
	public Bid() {
		
	}
	
	public Bid(String userId, int auctionId, int bidPrice, Date bidDate) {
		this.userId = userId;
		this.auctionId = auctionId;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public int getAuctionId() {
		return auctionId;
	}
	
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public int getBidPrice() {
		return bidPrice;
	}
	
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	public boolean getIsBidded() {
		return isBidded;
	}
	
	public void setIsBidded(boolean isBidded) {
		this.isBidded = isBidded;
	}
	
	public Date getBidDate() {
		return bidDate;
	}
	
	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}
	
	public String toString() {
		String str = "Bid [ bidId: " + bidId + ", userId" + userId + ", auctionId" + auctionId 
				 + ", bidPrice" + bidPrice + ", isBidded" + isBidded + ", bidDate" + bidDate;
		
		return str;
	}
}
