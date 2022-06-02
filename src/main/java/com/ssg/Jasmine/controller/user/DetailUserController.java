package com.ssg.Jasmine.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.ssg.Jasmine.service.UserService;

@Controller
public class DetailUserController {

	private static final String detailViewName = "user/user_detail";
	
	@Autowired
	UserService userService; 
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		return new UserForm(userService.getUserByUserId(userSession.getUser().getEmail()));
	}
	
	@RequestMapping("/user/detail")
	public String showForm() {
		return detailViewName;
	}
}
