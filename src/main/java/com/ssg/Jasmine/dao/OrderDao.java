package com.ssg.Jasmine.dao;

import org.springframework.dao.DataAccessException;
import com.ssg.Jasmine.domain.Order;

public interface OrderDao {

	  Order getOrder(int orderId) throws DataAccessException;

	  void createOrder(Order order) throws DataAccessException;

	  Order getOrderWithLineGroupBuys(int orderId) throws DataAccessException;

	// orderList에서 공동구매 정보 출력을 위해서 필요
//	  int getGroupBuyId(int orderId) throws DataAccessException; // From LineGroupBuys

	// orderList에서 경매 정보 출력을 위해서 필요
	  int getAuctionId(int orderId) throws DataAccessException; // From SuccessBidders
}
