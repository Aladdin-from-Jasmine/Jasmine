package com.ssg.Jasmine.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.CartItem;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CartService;
import com.ssg.Jasmine.service.CategoryService;
import com.ssg.Jasmine.service.UserService;

@Controller
@RequestMapping("/book/cart/{bookId}")
public class CartBookController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CartService cartService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView addToCart (@PathVariable("bookId") int bookId, HttpServletRequest request, HttpSession session) {
		System.out.println("cart??");
		
		Book book =  bookService.getBookByBookId(bookId);
		
		String genre = categoryService.getGenreByCategoryId(book.getCategoryId());
		
		boolean isUser = false;
		boolean isManager = false;
		
		String bookUserId = book.getUserId();

		UserSession userSession  = (UserSession)request.getSession().getAttribute("userSession");
		if(userSession != null) {
			String userId = userSession.getUser().getUserId();
			if(userId.equals(bookUserId)) {
				isUser = true;
			}
			if(userId.equals("admin")) {
				isManager = true;
			}
		}
		
			ModelAndView mav = new ModelAndView("redirect:/book/detail/"+bookId);

			mav.addObject("book", book);
			mav.addObject("genre", genre);
			mav.addObject("isUser", isUser);
			mav.addObject("isManager", isManager);
			mav.addObject("bookId", bookId);

			System.out.println(book.getCategoryId());
			
			CartItem cartItem = new CartItem();
			System.out.print("bookId"+book.getBookId());
			cartItem.setBookId(book.getBookId());
			
			cartItem.setQuantity(1);
			
			int cartId = cartService.getCartIdByUserId(userSession.getUser().getUserId());
			System.out.println("this is "+cartId);
			cartItem.setCartId(cartId);
			
			cartService.registerCartItem(cartItem);
			
			return mav;
	
	}
	
	
}

