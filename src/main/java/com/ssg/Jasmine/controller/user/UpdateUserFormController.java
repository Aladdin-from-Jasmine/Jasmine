package com.ssg.Jasmine.controller.user;

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
import org.springframework.web.util.WebUtils;

import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.validator.UserFormValidator;

@Controller
@RequestMapping("/user/update")
public class UpdateUserFormController {

	@Value("user/user_update")
	private String formViewName;
	@Value("user/user_detail")
	private String successViewName;
	
	private static final int FAIL = 0;

	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		return new UserForm(userService.getUserByUserId(userSession.getUser().getUserId()));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, Model model, BindingResult bindingResult) throws Exception {
		
		new UserFormValidator().validate(userForm, bindingResult);
		
		// 검증 오류 발생 시 다시 form view로 이동
		if (bindingResult.hasErrors()) { 
			return formViewName; 
			}
		
		int result = userService.updateUser(userForm.getUser());
		
		if (result == FAIL) {
			model.addAttribute("updateComplete", FAIL);
			return successViewName;
		}
		
		UserSession userSession = new UserSession(userService.getUserByUserId(userForm.getUser().getUserId()));
		session.setAttribute("userSession", userSession);
		return successViewName;
	}
}
