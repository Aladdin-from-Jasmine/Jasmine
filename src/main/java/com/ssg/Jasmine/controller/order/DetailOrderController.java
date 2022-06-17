package com.ssg.Jasmine.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Order;
import com.ssg.Jasmine.service.OrderService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/order/detail")
public class DetailOrderController {
	
	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest( // 경매
			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId) throws Exception {
		
			ModelAndView mav = new ModelAndView("order/payment_detail");
			Order order = orderService.getOrder(orderId);

			order.setAuction(orderService.getAuction(orderId));
			
			mav.addObject("order", order);
			return mav;
	}
	
}
