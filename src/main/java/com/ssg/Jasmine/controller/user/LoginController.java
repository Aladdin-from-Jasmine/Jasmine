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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.validator.LoginFormValidator;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/user/login")
public class LoginController {

	@Value("user/login")
	private String formViewName;
	@Autowired
	private UserService userService;	
	@Autowired
	private Authenticator authenticator;

	@ModelAttribute("loginForm")
	public LoginForm formBacking(HttpServletRequest request) throws Exception {
		return new LoginForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpSession session,
			@ModelAttribute("loginForm") LoginForm loginForm, Model model, BindingResult bindingResult) throws Exception {

		new LoginFormValidator().validate(loginForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView(formViewName);
		}
		User user = userService.getUser(loginForm.getUserId(), loginForm.getPassword());

		try {
			authenticator.authenticate(loginForm);
			UserSession userSession = new UserSession(user);
			session.setAttribute("userSession", userSession);
			
			String userId = userSession.getUser().getUserId();
			boolean isManager = false;
			if(userId.equals("admin")) {
				isManager = true;
			}
			session.setAttribute("isManager", isManager);
			
			return new ModelAndView("redirect:/index");
		} catch (AuthenticationException e) {
			ModelAndView mav = new ModelAndView();
			bindingResult.reject(e.getMessage(), new Object[] { loginForm.getUserId() }, null); 
			mav.addObject("loginForm", loginForm);
			mav.setViewName(formViewName);
			return mav;
		}
		
	}
}