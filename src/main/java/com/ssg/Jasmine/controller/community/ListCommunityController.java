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
	public ModelAndView handleRequest() throws Exception {
		
		//String username = userSession.getUser().getUsername();
		
		List<Community> communityList = communityService.getCommunityList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("communityList", communityList);
		mav.setViewName(successViewName); 
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("communityForm") CommunityForm communityForm, BindingResult result, Model model) throws Exception {
				
		new CommunityFormValidator().validate(communityForm, result);
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			mav.setViewName(formViewName); 
			return mav;
		} else {
			UserSession userSession  = (UserSession)session.getAttribute("userSession");
			String userId = userSession.getUser().getUserId();
			communityForm.getCommunity().setUserId(userId);
			
			communityService.createPost(communityForm.getCommunity());
			//model.addAttribute("communityForm", new CommunityForm());
			//model.addAttribute("userId", userId);

			List<Community> communityList = communityService.getCommunityList();

			mav.addObject("communityList", communityList);
			mav.setViewName(successViewName); 
			return mav;
		}
	}
}
