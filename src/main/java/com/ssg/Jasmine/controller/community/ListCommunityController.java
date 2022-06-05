package com.ssg.Jasmine.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.service.CommunityService;

import java.util.List;

@Controller
public class ListCommunityController {

	@Autowired
	private CommunityService communityService;

	@RequestMapping("/community/list")
	public ModelAndView handleRequest() throws Exception {
		
		//String username = userSession.getUser().getUsername();
		
		List<Community> communityList = communityService.getCommunityList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("communityList", communityList);
		mav.setViewName("community/list"); 
		return mav;
	}
}
