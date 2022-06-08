package com.ssg.Jasmine.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.Jasmine.service.UserService;

@Controller
public class MypageController {
	
	private static final String detailViewName = "user/user_detail";
	
	@Autowired
	UserService userService; 

}
