package com.ssg.Jasmine.controller.auction;

import java.io.Serializable;

import javax.validation.Valid;

import dongduk.cs.ssd.domain.Auction;


@SuppressWarnings("serial")
public class AuctionForm implements Serializable{
	
	@Valid
	private Auction auction;

	private boolean newAuction;
	
	public AuctionForm() {
		this.auction = new Auction();
		this.newAuction = true;
	}
	
	public AuctionForm(Auction auction) {
		this.auction = auction;
		this.newAuction = false;
	}
	
	public Auction getAuction() {
		return auction;
	}

	public boolean isNewAuction() {
		return newAuction;
	}

	@Override
	public String toString() {
		return "AuctionForm [auction=" + auction + ", newAuction=" + newAuction + "]";
	}

}
