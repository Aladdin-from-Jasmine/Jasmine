package com.ssg.Jasmine.controller.auction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
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
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.BidService;
import com.ssg.Jasmine.service.OrderService;
import com.ssg.Jasmine.service.SuccessBidderService;

@Controller
@SessionAttributes("auctionForm")
public class AuctionController {	
	private static final String AUCTION_LIST = "auction/auction_list";
	private static final String AUCTION_DETAIL = "auction/auction_detail";
	
	@Autowired
	AuctionService auctionService;
	@Autowired
	SuccessBidderService successBidderService;
	@Autowired
	UserService userService;
	@Autowired
	BidService bidService;
	@Autowired
	OrderService orderService;

	@Value("auction/list")
	private String successViewName;
		
	@RequestMapping(value="/auction/list", method=RequestMethod.GET)
	public ModelAndView auctionList(SessionStatus sessionStatus, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView(AUCTION_LIST);
		List<Auction> auctionList = auctionService.getAuctionList();
		
		String keyword = request.getParameter("keyword");
		String isSortWithProceeding = request.getParameter("sortByProceed");
		String isSortWithClosed = request.getParameter("sortByClosed");
		
		// proceeding만 정렬
		if(isSortWithProceeding != null && isSortWithProceeding.equals("true")) {
			if(keyword.equals("")) {		//그냥 proceed로 정렬
				auctionList = auctionService.getAuctionProceedList(isSortWithProceeding);
			}
			else {	// 검색 후 proceed로 정렬
				auctionList = auctionService.getSearchProceedAuctionList(keyword);
				mav.addObject("keyword", keyword);
			}
		}
		
		// closed만 정렬
		if(isSortWithClosed != null && isSortWithClosed.equals("true")) {
			if(keyword.equals("")) {	//그냥 closed로 정렬
				auctionList = auctionService.getAuctionClosedList(isSortWithClosed);
			}
			else {		// 검색 후 closed으로 정렬
				auctionList = auctionService.getSearchClosedAuctionList(keyword);
				mav.addObject("keyword", keyword);
			}
		}
		
		
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
		SuccessBidder successBidder = successBidderService.getSuccessBidderByAuctionId(auctionId);
		if(successBidder != null) { 
			String successBidderUserId = successBidder.getUserId();
			mav.addObject("successBidderUserId", successBidderUserId);
			System.out.println("successBidderUserId: "+ successBidderUserId);
			
			Order order = orderService.getOrderByAuctionId2(auctionId);
			// 낙찰자가 결제까지 완료한 경우
			if (order != null) {
				mav.addObject("completeOrder", 1);
			} else {
				mav.addObject("completeOrder", 0);
			}
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
	
		List<Auction> auctionList = auctionService.deleteAuction(auctionId);
		
		PagedListHolder<Auction> pagedAuctionList = new PagedListHolder<Auction>(auctionList);
		pagedAuctionList.setPageSize(3);
		request.getSession().setAttribute("AuctionController_auctionList", pagedAuctionList);

		return new ModelAndView(AUCTION_LIST, "auctionList", pagedAuctionList);

	}
}
