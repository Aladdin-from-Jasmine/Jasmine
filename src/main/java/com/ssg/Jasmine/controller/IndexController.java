package com.ssg.Jasmine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.BidService;
import com.ssg.Jasmine.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private static final String AUCTION_LIST = "auction/auction_list";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	AuctionService auctionService;
	@Autowired
	UserService userService;
	@Autowired
	BidService bidService;

//	@GetMapping(value= {"", "index"})
//	public String index() {
//		return "index";
//	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView indexauctionList(SessionStatus sessionStatus, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = null;
		auctionList = auctionService.getAuctionList();
		
		if (auctionList == null) {
			System.out.println("[DetailAuctionController] auctionList가 null");
		} else {
			mav.addObject("auctionList", auctionList);			
		}
		
		
		
		String page = request.getParameter("page");
		PagedListHolder<Auction> pagedAuctionList;
		if (page == null) {
			pagedAuctionList = new PagedListHolder<Auction>(auctionList);
			pagedAuctionList.setPageSize(3);
			request.getSession().setAttribute("AuctionController_auctionList", pagedAuctionList);
		}
		else {
			pagedAuctionList = (PagedListHolder<Auction>)request.getSession().getAttribute("AuctionController_auctionList");
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
		
		
		
		
		return new ModelAndView("index", "auctionList", pagedAuctionList);
	}
}
