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
	public ModelAndView indexAuctionList(SessionStatus sessionStatus, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("index");
		
		List<Auction> auctionList = null;
		auctionList = auctionService.getAuctionTop3();
		
		if (auctionList == null) {
			System.out.println("[IndexController] auctionList가 null");
		} else {
			mav.addObject("auctionList", auctionList);			
		}
		
		return mav;
	}
}
