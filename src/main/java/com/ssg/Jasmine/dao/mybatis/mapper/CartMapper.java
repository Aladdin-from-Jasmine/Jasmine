package com.ssg.Jasmine.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.Jasmine.domain.CartItem;

@Mapper
public interface CartMapper {
	CartItem getCartItem (int cartId);
	
	int registerCartItem(CartItem cartItem);

	void deleteCartItem(int cartId);
	
	List<CartItem> getCartItemListbyUserId(String userId);
	
	int getCartIdByUserId(String userId);
	
	int registerCartbyUserId(String userId);


}
