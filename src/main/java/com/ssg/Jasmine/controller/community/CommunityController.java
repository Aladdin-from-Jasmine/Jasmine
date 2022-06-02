package com.ssg.Jasmine.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community/")
public class CommunityController {

	@RequestMapping(value= {"create"})
	public String create() {
		return "community/create";
	}
	
	@RequestMapping(value= {"update"})
	public String update() {
		return "community/update";
	}
	
	@RequestMapping(value= {"detail"})
	public String detail() {
		return "community/detail";
	}
	
	@RequestMapping(value= {"list"})
	public String list() {
		return "community/list";
	}
}
