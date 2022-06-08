package com.ssg.Jasmine.controller.book;

import java.util.List;
//hihi
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import com.ssg.Jasmine.controller.user.UserSession;
//import com.ssg.Jasmine.domain.Auction;
//import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.service.BookService;
//import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.Book;
//import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.domain.User;
//import com.ssg.Jasmine.service.BidService;

@Controller

public class BookController {
	
	private static final String BOOK_LIST = "book/list";
	//private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

		
	@RequestMapping(value="book/list", method=RequestMethod.GET)
	public ModelAndView bookList(SessionStatus sessionStatus, HttpSession session){
		ModelAndView mav = new ModelAndView(BOOK_LIST);
		List<Book> bookList = null;
		bookList = bookService.getBookList();
		if (bookList == null) {
			System.out.println("BookController] auctionList가 null");
		} else {
			mav.addObject("bookList", bookList);			
		}
		//session.removeAttribute("bidForm");
		sessionStatus.setComplete();
		return mav;
	}
}