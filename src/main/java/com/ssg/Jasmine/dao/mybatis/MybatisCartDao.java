package com.ssg.Jasmine.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.Jasmine.dao.CartDao;
import com.ssg.Jasmine.dao.mybatis.mapper.CartMapper;
import com.ssg.Jasmine.domain.CartItem;

@Repository
public class MybatisCartDao implements CartDao{

	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public CartItem getCartItem(int cartId) {
		// TODO Auto-generated method stub
		return cartMapper.getCartItem(cartId);
	}

	@Override
	public int registerCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartMapper.registerCartItem(cartItem);
	}

	@Override
	public void deleteCartItem(int cartId) {
		// TODO Auto-generated method stub
		cartMapper.deleteCartItem(cartId);
		
	}

	@Override
	public List<CartItem> getCartItemListbyUserId(String userId) {
		// TODO Auto-generated method stub
		return cartMapper.getCartItemListbyUserId(userId);
	}

	@Override
	public int getCartIdByUserId(String userId) {
		// TODO Auto-generated method stub
		return cartMapper.getCartIdByUserId(userId);
	}

}
