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
	public int registerCartItem(CartItem cartItem) {
		return cartMapper.registerCartItem(cartItem);
	}	

	@Override
	public void deleteCartItem(int cartId) {
		cartMapper.deleteCartItem(cartId);	
	}

	@Override
	public List<CartItem> getCartItemListbyUserId(String userId) {
		return cartMapper.getCartItemListbyUserId(userId);
	}

	@Override
	public int getCartIdByUserId(String userId) {
		return cartMapper.getCartIdByUserId(userId);
	}

	@Override
	public int registerCartbyUserId(String userId) {
		return cartMapper.registerCartbyUserId(userId);
	}

	@Override
	public List<CartItem> getCartItemByBookIdAndUserId(int bookId, String userId) {
		return cartMapper.getCartItemByBookIdAndUserId(bookId, userId);
	}

}
