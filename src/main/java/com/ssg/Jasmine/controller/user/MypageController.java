package com.ssg.Jasmine.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.BidService;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CategoryService;
import com.ssg.Jasmine.service.UserService;

@Controller
public class MypageController {
	@Autowired
	UserService userService; 
	@Autowired
	BookService bookService;
	@Autowired
	BidService bidService;
	@Autowired
	AuctionService auctionService;
	
	@RequestMapping(value="/user/book", method=RequestMethod.GET)
	public ModelAndView userBook(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("user/book");
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		List<Book> bookList = (List<Book>) bookService.getBookByUserId(userSession.getUser().getUserId());
		mav.addObject("bookList", bookList);		
		
		return mav;
	}
	
	@RequestMapping(value="/user/auction", method=RequestMethod.GET)
	public ModelAndView userAuction(HttpServletRequest request, SessionStatus sessionStatus, HttpSession session ){
		ModelAndView mav = new ModelAndView("user/auction");
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		List<Auction> auctionList = auctionService.getAuctionListByUserId(userSession.getUser().getUserId());
		if (auctionList == null) {
			System.out.println("[DetailAuctionController] auctionList가 null");
		} else {
			mav.addObject("auctionList", auctionList);			
		}
		session.removeAttribute("bidForm");
		sessionStatus.setComplete();
		
		String page = request.getParameter("page");
		PagedListHolder<Auction> pagedAuctionList;
		if (page == null) {
			pagedAuctionList = new PagedListHolder<Auction>(auctionList);
			pagedAuctionList.setPageSize(3);
			request.getSession().setAttribute("MypageController_auctionList", pagedAuctionList);
		}
		else {
			pagedAuctionList = (PagedListHolder<Auction>)request.getSession().getAttribute("MypageController_auctionList");
			if (pagedAuctionList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				pagedAuctionList.nextPage();
			}
			else if ("previous".equals(page)) {
				pagedAuctionList.previousPage();
			}	
		}
		
		return new ModelAndView("user/auction", "auctionList", pagedAuctionList);
		
	}
	
	
	@RequestMapping(value="/user/bid", method=RequestMethod.GET)
	public ModelAndView userSuccessBid(HttpServletRequest request, SessionStatus sessionStatus, HttpSession session ){
		ModelAndView mav = new ModelAndView("user/bid");
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		//List<Auction> successBidList = auctionService.getAuctionListByUserId(userSession.getUser().getUserId());
		
		List<Bid> bidList = bidService.getBidByUserId(userSession.getUser().getUserId());
		if (bidList == null) {
			System.out.println("[MypageController] bidList가 null");
		} else {
			mav.addObject("bidList", bidList);		
		}
		
		return mav;
		
	}
	
	
}
