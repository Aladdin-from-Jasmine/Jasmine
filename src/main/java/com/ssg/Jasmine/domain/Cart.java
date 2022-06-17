package com.ssg.Jasmine.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cart implements Serializable{
	private int cartId;
	private int totalPrice;
	private int userId;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
