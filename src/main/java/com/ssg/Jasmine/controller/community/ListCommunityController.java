package com.ssg.Jasmine.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.service.CommunityService;
import com.ssg.Jasmine.validator.CommunityFormValidator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/community/list")
public class ListCommunityController {

	@Autowired
	private CommunityService communityService;

	@Value("community/create")
	private String formViewName;
	@Value("community/list")
	private String successViewName;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request) throws Exception {
		
		List<Community> communityList = communityService.getCommunityList();
		
		String isSortWithPost = request.getParameter("sortByPostId");
		if(isSortWithPost != null && isSortWithPost.equals("true")) {
			communityList = communityService.getCommunitySortedList(isSortWithPost);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("communityList", communityList);
		mav.addObject("listSize", communityList.size());
		mav.setViewName(successViewName); 
		return mav;
	}
}
