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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
@RequestMapping("/auction/bid/create")
public class BidFormController {

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

	@RequestMapping(method = RequestMethod.POST)
	public String create(HttpServletRequest request,
			@Valid @ModelAttribute("bidForm") BidForm bidForm, BindingResult result, 
			HttpServletResponse response, HttpSession session, Model model, SessionStatus sessionStatus) throws Exception {
		int auctionId = bidForm.getBid().getAuctionId();

		Auction auction = auctionService.getAuction(auctionId);
		model.addAttribute("writer", userService.getUserByUserId(auction.getUserId()).getUsername());
		model.addAttribute("isWriter", false);
	
		if (auction.getBids().isEmpty()) {
			if (bidForm.getBid().getBidPrice() < auction.getStartPrice()) {
				result.rejectValue("bid.bidPrice", "smallerThanStartPrice");
			}
		} else {
			if (bidForm.getBid().getBidPrice() <= auction.getMaxPrice()) {
				result.rejectValue("bid.bidPrice", "smallerThanMaxPrice");
			}
		}

		if (result.hasErrors()) {
			Bid maxPriceBid = bidService.getBidByMaxPrice(auction.getMaxPrice(), auctionId);
			if (maxPriceBid == null) {
				model.addAttribute("date_maxBid", "");
				model.addAttribute("user_maxBid", "아직 입찰자가 없습니다.");
			} else {
				model.addAttribute("date_maxBid", maxPriceBid.getBidDate());
				User user_maxBid = userService.getUserByUserId(maxPriceBid.getUserId());
				model.addAttribute("user_maxBid", user_maxBid.getUsername());
			}
			model.addAttribute("auction", auction);
			return AUCTION_DETAIL;
		}
		
		UserSession userSession = (UserSession)session.getAttribute("userSession");
		String userId = userSession.getUser().getUserId();
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date bidDate = new java.sql.Date(utilDate.getTime());

		Bid bid = bidService.getBidByUserIdAndAuctionId(userId, auctionId);
		if (bid == null) {
			bid = new Bid(userId, auctionId, bidForm.getBid().getBidPrice(), bidDate);
			bidService.createBid(bid);
		} else {
			bid.setBidPrice(bidForm.getBid().getBidPrice());
			bidService.updateBid(bid);
		}

		int updatedAutionId = auctionService.updateAuctionMaxPrice(bidForm.getBid().getBidPrice(), auctionId); // auction table maxPrice update
		model.addAttribute("auction", auctionService.getAuction(updatedAutionId));
		
		model.addAttribute("date_maxBid", bid.getBidDate());
		User user_maxBid = userService.getUserByUserId(bid.getUserId());
		model.addAttribute("user_maxBid", user_maxBid.getUsername());
		session.setAttribute("bidForm", new BidForm());
		model.addAttribute("bidForm", session.getAttribute("bidForm"));
		
		return AUCTION_DETAIL;
	}

}
