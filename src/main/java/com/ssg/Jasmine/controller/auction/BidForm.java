package com.ssg.Jasmine.controller.auction;

import javax.validation.Valid;

import com.ssg.Jasmine.domain.Bid;


public class BidForm {
	@Valid
	private Bid bid;
	private boolean newBid;
	
	public BidForm() { // create
		this.bid = new Bid();
		this.newBid = true;
	}
	
	public BidForm(Bid bid) { //update
		this.bid = bid;
		this.newBid = false;
	}
	
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	
	public Bid getBid() {
		return bid;
	}
	
	public boolean isNewBid() {
		return newBid;
	}
	
}
