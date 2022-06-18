package com.ssg.Jasmine.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	int orderId;
	String cardBank;
	String cardNo;
	String validDate;
	String cvc;
	String address;
	String phone;
	String refundBank;
	String refundAccount;
	int totalPrice;
	Date orderDate;
	String userId;

	String status;
	
	SuccessBidder successBidder;
	Auction auction;
	Book book;
	int bookId;
	int auctionId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public SuccessBidder getSuccessBidder() {
		return successBidder;
	}

	public void setSuccessBidder(SuccessBidder successBidder) {
		this.successBidder = successBidder;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCardBank() {
		return cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRefundBank() {
		return refundBank;
	}

	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public void initAuctionOrder(User user, Auction auction) {
		userId = user.getUserId();
		address = user.getAddress();
		phone = user.getPhone();
		
		totalPrice = 0;
	
		if (auction != null) {
			List<Bid> bids = auction.getBids();
			totalPrice = auction.getMaxPrice();
			auctionId = auction.getAuctionId();
			this.auction = auction;
			
		}
	}
		
	public void initBookOrder(User user, Book book) {
		userId = user.getUserId();
		address = user.getAddress();
		phone = user.getPhone();
		
		totalPrice = book.getPrice();
		bookId = book.getBookId();
		this.book = book;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cardBank=" + cardBank + ", cardNo=" + cardNo + ", validDate="
				+ validDate + ", cvc=" + cvc + ", address=" + address + ", phone=" + phone + ", refundBank=" + refundBank + ", refundAccount=" + refundAccount
				+ ", userId=" + userId + ", successBidder=" + successBidder + ", auction=" + auction + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", auctionId=" + auctionId + "]";
	}

}
