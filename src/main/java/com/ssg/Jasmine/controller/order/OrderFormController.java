package com.ssg.Jasmine.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.BidService;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.OrderService;
import com.ssg.Jasmine.service.SuccessBidderService;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.validator.OrderFormValidator;

@Controller
@SessionAttributes({"lineGroupBuyForm", "orderForm"})
public class OrderFormController {
	
	private static final String orderFormView = "order/order_create";
	private static final String detailView = "order/payment_detail";
	private static final String AUCTION_DETAIL = "auction/auction_detail";

	private static final int FAIL = 0; // 결제가 실패했을 경우
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AuctionService auctionService;
	@Autowired
	SuccessBidderService successBidderService;
	@Autowired
	BidService bidService;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
	@ModelAttribute("orderForm")
	public OrderForm formBacking(HttpServletRequest request) {
		return new OrderForm();
	}
	
	@ModelAttribute("cardBanks")
	public List<String> cardBanksData() {
		ArrayList<String> cardBanks = new ArrayList<String>();
		cardBanks.add("신한");
		cardBanks.add("하나");
		cardBanks.add("우리");
		cardBanks.add("농협");
		cardBanks.add("국민"); 
		// add more
		return cardBanks;			
	}
	
	@RequestMapping(value = "/order/auction/create", method = RequestMethod.GET) // form 출력
	public ModelAndView auctionOrderForm(HttpServletRequest request,
			@RequestParam("auctionId") int auctionId,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		ModelAndView mav = new ModelAndView(orderFormView);
		mav.addObject("isAuction", true);
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		User user = (User) userSession.getUser();

		orderForm.getOrder().initAuctionOrder(user, auctionService.getAuction(auctionId));
		return mav;
	}
	
	@RequestMapping(value = "/order/book/create", method = RequestMethod.GET) // form 출력
	public ModelAndView bookOrderForm(HttpServletRequest request,
			@RequestParam("bookId") int bookId,
			@ModelAttribute("orderForm") OrderForm orderForm
			) throws ModelAndViewDefiningException {
		ModelAndView mav = new ModelAndView(orderFormView);
		mav.addObject("isAuction", false);
		
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		User user = (User) userSession.getUser();

		System.out.println("book id: " + bookId);
		System.out.println("book 객체: " + bookService.getBookByBookId(bookId));
		
		orderForm.getOrder().initBookOrder(user, bookService.getBookByBookId(bookId));
		return mav;
	}
	
	@RequestMapping(value = "/order/create", method = RequestMethod.POST) // 결과 출력
	protected ModelAndView auctionOrderSubmit(
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status, BindingResult bindingResult) {
		
		System.out.println("command 객체: " + orderForm);
		System.out.println("order 객체: " + orderForm.getOrder());
		new OrderFormValidator().validate(orderForm, bindingResult);
		
		// 검증 오류 발생 시 다시 form view로 이동
		if (bindingResult.hasErrors()) {
			return new ModelAndView(orderFormView);
		}
		
		Order order = orderForm.getOrder();
		order.setStatus("success");
		int result;
		
		ModelAndView mav = new ModelAndView(detailView);
		mav.addObject("order", order);
		
		if(order.getAuction() != null) {
			result = orderService.createAuctionOrder(order);
			SuccessBidder successBidder = successBidderService.getSuccessBidderByAuctionId(orderForm.getOrder().getAuctionId());
			
			if (result == FAIL) {
				mav.addObject("message", "결제에 실패했습니다.");
				successBidder.setOrderState("fail");
			} else {
				mav.addObject("message", "결제가 성공적으로 완료되었습니다.");
				successBidder.setOrderState("success");
			}
		}
		else {
			result = orderService.createBookOrder(order);
			Book book = bookService.getBookByBookId(order.getBookId());
			
			if (result == FAIL) {
				mav.addObject("message", "결제에 실패했습니다.");
				book.setOrderState("fail");
			} else {
				mav.addObject("message", "결제가 성공적으로 완료되었습니다.");
				book.setOrderState("success");
			}
		}
		
		status.setComplete();  
		return mav;
	}
	
	@RequestMapping(value="/order/auction/detail", method=RequestMethod.POST)
	public ModelAndView auctionDetail(HttpServletRequest request, 
			@RequestParam("orderId") int orderId, HttpSession session) {

		ModelAndView mav = new ModelAndView(AUCTION_DETAIL);
		int auctionId = orderService.getOrder(orderId).getAuctionId();
		String bidderId = orderService.getOrder(orderId).getUserId();

		// auction 정보 가져오기
		Auction auction = auctionService.getAuction(auctionId); 
		
		// 낙찰자 정보 가져오기 (낙찰자의 userId) -> 낙찰자에게만 '결제하기'버튼이 보이게 하기 위해
		SuccessBidder successBidder = successBidderService.getSuccessBidderByAuctionId(auctionId);
		if(successBidder != null) {
			Bid bid = bidService.getBid(successBidder.getBidId());  
			String successBidderUserId = bid.getUserId();
			mav.addObject("successBidderUserId", successBidderUserId);
		
			// 낙찰자가 결제까지 완료한 경우
			if (successBidder.getOrderId() != 0) {
				mav.addObject("completeOrder", 1);
			} else {
				mav.addObject("completeOrder", 0);
			}
		}
		
		//	auction의 최고 금액에 해당하는 bid 정보 가져오기
		Bid maxPriceBid = bidService.getBidByMaxPrice(auction.getMaxPrice(), auctionId); 
		mav.addObject("date_maxBid", maxPriceBid.getBidDate());
		User user_maxBid = userService.getUserByUserId(maxPriceBid.getUserId());
		mav.addObject("user_maxBid", user_maxBid.getUsername());
		
		//	낙찰된 사람의 정보
		mav.addObject("auction", auction);
		mav.addObject("writer", userService.getUserByUserId(auction.getUserId()).getUsername());
		return mav;
	}

}
