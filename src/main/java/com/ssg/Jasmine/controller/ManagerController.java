package com.ssg.Jasmine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/")
public class ManagerController {

	@RequestMapping(value= {"user"})
	public String user() {
		return "user";
	}
	
	@RequestMapping(value= {"book"})
	public String book() {
		return "book";
	}
	
	@RequestMapping(value= {"auction"})
	public String auction() {
		return "auction";
	}
	
	@RequestMapping(value= {"community"})
	public String community() {
		return "community";
	}
}
