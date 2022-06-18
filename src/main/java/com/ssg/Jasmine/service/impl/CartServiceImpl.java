package com.ssg.Jasmine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.Jasmine.dao.CartDao;
import com.ssg.Jasmine.domain.CartItem;
import com.ssg.Jasmine.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;

	@Override
	public int registerCartItem(CartItem cartItem) {
		return cartDao.registerCartItem(cartItem);
	}	
	
	@Override
	public void deleteCartItem(int cartId) {
		cartDao.deleteCartItem(cartId);
	}

	@Override
	public List<CartItem> getCartItemListbyUserId(String userId) {
		return cartDao.getCartItemListbyUserId(userId);
	}

	@Override
	public int getCartIdByUserId(String userId) {
		return cartDao.getCartIdByUserId(userId);
	}

	@Override
	public int registerCartbyUserId(String userId) {
		return cartDao.registerCartbyUserId(userId);
	}

	@Override
	public List<CartItem> getCartItemByBookIdAndUserId(int bookId, String userId) {
		return cartDao.getCartItemByBookIdAndUserId(bookId, userId);
	}
	

}
