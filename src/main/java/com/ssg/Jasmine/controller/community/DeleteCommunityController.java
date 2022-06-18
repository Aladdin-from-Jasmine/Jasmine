package com.ssg.Jasmine.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.Jasmine.service.CommunityService;

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

