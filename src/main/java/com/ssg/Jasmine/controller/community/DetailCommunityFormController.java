package com.ssg.Jasmine.controller.community;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.service.CommunityService;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/community/detail")
public class DetailCommunityFormController { 

	@Autowired
	private CommunityService communityService;

	@Value("community/list")
	private String formViewName;
	@Value("community/detail")
	private String successViewName;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpSession session, 
			@ModelAttribute("communityForm") CommunityForm communityForm) throws Exception {
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		Community community = communityService.getCommunity(postId);
		
		String postUserId = community.getUserId();
		boolean isUser = false;
		boolean isManager = false;
		
		UserSession userSession  = (UserSession)session.getAttribute("userSession");
		if(userSession != null) {
			String userId = userSession.getUser().getUserId();
			if(userId.equals(postUserId)) {
				isUser = true;
			}
			if(userId.equals("admin")) {
				isManager = true;
			}
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("community", community);
		mav.addObject("isUser", isUser);
		mav.addObject("isManager", isManager);
		mav.setViewName(successViewName); 
		return mav;
	}

}
