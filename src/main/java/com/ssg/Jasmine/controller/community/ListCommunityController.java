package com.ssg.Jasmine.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		ModelAndView mav = new ModelAndView();
		List<Community> communityList = communityService.getCommunityList();
		String keyword = request.getParameter("keyword");
		String isSortWithPost = request.getParameter("sortByPostId");
		
		// postId로 정렬
		if(isSortWithPost != null && isSortWithPost.equals("true")) {
			if(keyword != null) {	// 검색 후 postId로 정렬
				communityList = communityService.getSearchSortedCommunityList(keyword);
				mav.addObject("keyword", keyword);
			}
			else {
				communityList = communityService.getCommunitySortedList(isSortWithPost);
			}
		}
		
		// 최신순으로 정렬
		if(isSortWithPost != null && isSortWithPost.equals("false")) {
			if(keyword != null) {	// 검색 후 최신순으로 정렬
				communityList = communityService.getSearchCommunityList(keyword);
			}
			else {
				communityList = communityService.getCommunitySortedList(isSortWithPost);
			}
		}
		
		mav.addObject("communityList", communityList);
		mav.addObject("listSize", communityList.size());
		mav.setViewName(successViewName); 
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView searchList(HttpServletRequest request) throws Exception {

		String keyword = request.getParameter("keyword");
		List<Community> communityList = communityService.getSearchCommunityList(keyword);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("communityList", communityList);
		mav.addObject("keyword", keyword);
		mav.setViewName(successViewName); 
		return mav;
	}
}
