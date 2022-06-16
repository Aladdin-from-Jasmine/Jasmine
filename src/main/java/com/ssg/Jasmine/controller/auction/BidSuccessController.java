package com.ssg.Jasmine.controller.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.service.BidService;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.UserService;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.service.AuctionService;

@Controller
@SessionAttributes("bidForm")	
@EnableJpaRepositories(basePackages="/validation.properties")
@RequestMapping("/auction/bid/success")
public class BidSuccessController {

	private static final String AUCTION_DETAIL = "auction/auction_detail";

	@Autowired
	BidService bidService;

	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}

	@Autowired
	UserService userService;

	@Autowired
	AuctionService auctionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView create(HttpServletRequest request, @Valid @ModelAttribute("auctionForm") AuctionForm auctionForm, BindingResult result,
			Model model, SessionStatus sessionStatus, HttpSession session) {
			ModelAndView mav = new ModelAndView(AUCTION_DETAIL);
			
			int auctionId = Integer.parseInt(request.getParameter("auctionId"));
			auctionService.updateStateAuction(auctionId, "closed");
			Auction auction = auctionService.getAuction(auctionId);
			model.addAttribute("auction", auction);

			UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
			session.setAttribute("bidForm", new BidForm());
		
			Bid maxPriceBid = bidService.getBidByMaxPrice(auction.getMaxPrice(), auctionId); 
			mav.addObject("date_maxBid", maxPriceBid.getBidDate());
			User user_maxBid = userService.getUserByUserId(maxPriceBid.getUserId());
			mav.addObject("user_maxBid", user_maxBid.getUsername());
			
			model.addAttribute("isClosed", true);
			model.addAttribute("isWriter", true);
			model.addAttribute("writer", user.getUser().getUsername());
			model.addAttribute("bidForm", session.getAttribute("bidForm"));
			sessionStatus.setComplete();
			return mav;
	}

}
