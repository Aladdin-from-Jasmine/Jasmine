package com.ssg.Jasmine.controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.service.CommunityService;
import com.ssg.Jasmine.validator.CommunityFormValidator;

@Controller
@RequestMapping("/community/update")
public class UpdateCommunityController { 

	@Autowired
	private CommunityService communityService;

	@Value("community/update")
	private String formViewName;
	@Value("/community/list")
	private String successViewUri;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpSession session, 
			@ModelAttribute("communityForm") CommunityForm communityForm) throws Exception {
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		Community community = communityService.getCommunity(postId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("community", community);
		mav.setViewName(formViewName); 
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("communityForm") CommunityForm communityForm, BindingResult result, Model model) throws Exception {
				
		if (result.hasErrors()) {
			return formViewName;
		} else {
			communityService.updatePost(communityForm.getCommunity());
			
			int postId = communityForm.getCommunity().getPostId();
			Community community = communityService.getCommunity(postId);

			return "redirect:" + successViewUri;
		}
	}

}
