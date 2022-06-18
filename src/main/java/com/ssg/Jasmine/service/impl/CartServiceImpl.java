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
	public CartItem getCartItem(int cartId) {
		// TODO Auto-generated method stub
		return cartDao.getCartItem(cartId);
	}

	@Override
	public int registerCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartDao.registerCartItem(cartItem);
	}	
	
	@Override
	public void deleteCartItem(int cartId) {
		// TODO Auto-generated method stub
		cartDao.deleteCartItem(cartId);
		
	}

	@Override
	public List<CartItem> getCartItemListbyUserId(String userId) {
		// TODO Auto-generated method stub
		return cartDao.getCartItemListbyUserId(userId);
	}

	@Override
	public int getCartIdByUserId(String userId) {
		// TODO Auto-generated method stub
		return cartDao.getCartIdByUserId(userId);
	}
	

}
