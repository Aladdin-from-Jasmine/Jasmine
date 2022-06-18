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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.service.CommunityService;
import com.ssg.Jasmine.validator.CommunityFormValidator;

@Controller
@SessionAttributes("userId")
@RequestMapping("/community/create")
public class CreateCommunityFormController {
	
	@Value("community/create")
	private String formViewName;
	@Value("/community/list")
	private String successViewUri;
	
	@Autowired
	private CommunityService communityService;

	@ModelAttribute("communityForm")
	public CommunityForm formBackingObject(HttpServletRequest request) throws Exception {
		return new CommunityForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(HttpSession session) {
		UserSession userSession  = (UserSession)session.getAttribute("userSession");
		String userId = userSession.getUser().getUserId();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userId", userId);
		mv.setViewName(formViewName);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("communityForm") CommunityForm communityForm, BindingResult result, Model model) throws Exception {
				
		new CommunityFormValidator().validate(communityForm, result);
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			mav.setViewName(formViewName); 
			return formViewName;
		} else {
			UserSession userSession  = (UserSession)session.getAttribute("userSession");
			String userId = userSession.getUser().getUserId();
			communityForm.getCommunity().setUserId(userId);
			
			communityService.createPost(communityForm.getCommunity());

			return "redirect:" + successViewUri;
		}
	}
}
