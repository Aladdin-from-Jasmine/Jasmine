package com.ssg.Jasmine.controller.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.CartItem;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CartService;
import com.ssg.Jasmine.service.UserService;

@Controller
@RequestMapping("/user/cart")

public class ListCartController {

	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView bookList(SessionStatus sessionStatus, HttpServletRequest request, HttpSession session)
	{
		ModelAndView mav = new ModelAndView("cart/list");
		
		
		boolean isUser = false;
		boolean isManager = false;
		

		UserSession userSession  = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession != null) {
			String userId = userSession.getUser().getUserId();
			
			List<CartItem> cartItemList = cartService.getCartItemListbyUserId(userId);
			
			List<Book> booklist = new ArrayList<Book>();

			if(cartItemList!=null) {
				for(CartItem c : cartItemList) {
					Book b = bookService.getBookByBookId(c.getBookId());
					
					if(b!=null) {
						System.out.println("카트 책 이름 : "+b.getTitle());	
						booklist.add(b);
					}
					
				}
				
			}
			
			mav.addObject("bookList", booklist);		
			mav.addObject("listSize", booklist.size());
			
			return mav;
			
		}
		
		return new ModelAndView("book/detail_error");
		
	}
	
	
	
	

}
