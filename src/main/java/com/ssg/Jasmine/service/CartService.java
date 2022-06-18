package com.ssg.Jasmine.service;

import java.util.List;

import com.ssg.Jasmine.domain.CartItem;


public interface CartService {
	CartItem getCartItem (int cartId);
	
	int registerCartItem(CartItem cartItem);

	void deleteCartItem(int cartId);
	
	List<CartItem> getCartItemListbyUserId(String userId);
	
	int getCartIdByUserId(String userId);
	
	int registerCartbyUserId(String userId);


}
