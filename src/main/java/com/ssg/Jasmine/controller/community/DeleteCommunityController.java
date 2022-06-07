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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.service.CommunityService;
import com.ssg.Jasmine.validator.CommunityFormValidator;

@Controller

public class DeleteCommunityController { 

	@Autowired
	private CommunityService communityService;

	@Value("/community/list")
	private String successViewUri;
	
	@RequestMapping("/community/delete")
	public String handleRequest(@ModelAttribute("communityForm") CommunityForm communityForm) throws Exception {
	
		communityService.deletePost(communityForm.getCommunity().getPostId());
		return "redirect:" + successViewUri;
	}
}

