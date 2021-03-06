package com.ssg.Jasmine.controller.order;

import java.io.Serializable;

import com.ssg.Jasmine.domain.Order;

@SuppressWarnings("serial")
public class OrderForm implements Serializable {
	
	private Order order;
	
	private boolean newOrder;
	
	public OrderForm() {
		this.order = new Order();
		this.newOrder = true;
	}
	
	public OrderForm(Order order) {
		this.order = order;
		this.newOrder = false;
	}

	public Order getOrder() {
		return order;
	}

	public boolean isNewOrder() {
		return newOrder;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "OrderForm [order=" + order.toString() + ", newOrder=" + newOrder + "]";
	}
	
}
