package com.ssg.Jasmine.controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.CartItem;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CartService;
import com.ssg.Jasmine.service.UserService;

@Controller
public class DeleteCartController {
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	
	@RequestMapping("/cart/delete/{bookId}")
	public String bookList(@PathVariable("bookId") int bookId, SessionStatus sessionStatus, HttpServletRequest request, HttpSession session){
		UserSession userSession  = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession != null) {
			String userId = userSession.getUser().getUserId();		
			List<CartItem> delete = cartService.getCartItemByBookIdAndUserId(bookId, userId);
			
			for(CartItem c : delete) {		
				cartService.deleteCartItem(c.getCartItemId());
			}	
		}
		return "redirect:/user/cart";	
	}
}
