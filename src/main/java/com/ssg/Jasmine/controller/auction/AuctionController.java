package com.ssg.Jasmine.controller.auction;

import java.util.List;
//hihi
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.BidService;

@Controller
@SessionAttributes("auctionForm")
public class AuctionController {	
	private static final String AUCTION_LIST = "auction/auction_list";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	AuctionService auctionService;
	@Autowired
	UserService userService;
	@Autowired
	BidService bidService;
		
	@RequestMapping(value="/auction/list", method=RequestMethod.GET)
	public ModelAndView auctionList(SessionStatus sessionStatus, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = null;
		auctionList = auctionService.getAuctionList();
		
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
		return new ModelAndView(AUCTION_LIST, "auctionList", pagedAuctionList);
	}
	
	@RequestMapping(value="/auction/list", method=RequestMethod.POST)
	public ModelAndView searchAuctionList(SessionStatus sessionStatus, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = null;
		
		String keyword = request.getParameter("keyword");	
		auctionList = auctionService.getSearchAuctionList(keyword);
		
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
		return new ModelAndView(AUCTION_LIST, "auctionList", pagedAuctionList);
	}
	
	@RequestMapping(value="/auction/detail", method=RequestMethod.GET)
	public ModelAndView auctionDetail(HttpServletRequest request, 
			@RequestParam("auctionId") int auctionId, HttpSession session) {

		ModelAndView mav = new ModelAndView(AUCTION_DETAIL);

//		auction 정보 가져오기
		Auction auction = auctionService.getAuction(auctionId); 
		
// 		낙찰자 정보 가져오기 (낙찰자의 userId) -> 낙찰자에게만 '결제하기'버튼이 보이게 하기 위해
		mav.addObject("successBidderUserId", auctionService.getSuccessBidderUserId(auctionId));

// 		낙찰자가 결제까지 완료한 경우
		SuccessBidder successBidder = auctionService.getSuccessBidderByAuctionId(auctionId);
		if (successBidder != null) {
			mav.addObject("completeOrder", 1);
		} else {
			mav.addObject("completeOrder", 0);
		}
		
		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		if(user != null) {
			String userId = user.getUser().getUserId();
			if(userId.equals("admin")) {
				mav.addObject("isManager", true);
				
				System.out.println("user.userid== "+ user.getUser().getUserId());
				System.out.println("auction.getUserId== "+auction.getUserId());
			}
			if (userId.equals(auction.getUserId())) {
				mav.addObject("isWriter", true);
				
				System.out.println("user.userid== "+ user.getUser().getUserId());
				System.out.println("auction.getUserId== "+auction.getUserId());
			} else {
				auction.setCount(auction.getCount()+1);
				auctionService.increaseCount(auction);
				mav.addObject("isWriter", false);
				
				System.out.println("user.userid== "+ user.getUser().getUserId());
				System.out.println("auction.getUserId== "+auction.getUserId());
			}
		}
		else {
			auction.setCount(auction.getCount()+1);
			auctionService.increaseCount(auction);
			mav.addObject("isWriter", false);
		}


		if (auction.getBids().isEmpty()) {// 아무도 입찰 안 했을 때
			mav.addObject("date_maxBid", "");
			mav.addObject("user_maxBid", "아직 입찰자가 없습니다.");
		} else {
//			auction의 최고 금액에 해당하는 bid 정보 가져오기
			Bid maxPriceBid = bidService.getBidByMaxPrice(auction.getMaxPrice(), auctionId); 
			mav.addObject("date_maxBid", maxPriceBid.getBidDate());
			User user_maxBid = userService.getUserByUserId(maxPriceBid.getUserId());
			mav.addObject("user_maxBid", user_maxBid.getUsername());
		}
			
//		현재 최고 금액을 입찰한 사람의 정보
		session.setAttribute("bidForm", new BidForm());
		session.setAttribute("auctionId", auctionId);
		mav.addObject("auction", auction);
		mav.addObject("bidForm", session.getAttribute("bidForm"));
		mav.addObject("writer", userService.getUserByUserId(auction.getUserId()).getUsername());
		return mav;
	}
	
	@RequestMapping(value="/auction/delete")
	public ModelAndView auctionDelete(HttpServletRequest request,
			@RequestParam("auctionId") int auctionId){
		
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = auctionService.deleteAuction(auctionId);
		mav.addObject("auctionList", auctionList);
		
		return mav;
	}
}
