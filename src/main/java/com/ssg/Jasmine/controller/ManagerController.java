package com.ssg.Jasmine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/")
public class ManagerController {

	@RequestMapping(value= {"user"})
	public String user() {
		return "manager/user";
	}
	
	@RequestMapping(value= {"book"})
	public String book() {
		return "manager/book";
	}
	
	@RequestMapping(value= {"auction"})
	public String auction() {
		return "manager/auction";
	}
	
	@RequestMapping(value= {"community"})
	public String community() {
		return "manager/community";
	}
}
