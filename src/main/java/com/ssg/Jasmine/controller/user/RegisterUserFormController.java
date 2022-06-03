package com.ssg.Jasmine.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.validator.UserFormValidator;

@Controller
@RequestMapping("/user/register")
public class RegisterUserFormController {
	
	@Value("user/register")
	private String formViewName;
	@Value("user/login")
	private String successViewName;
	
	@Autowired
	private UserService userService;

	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		return new UserForm();
	}
	
//	@ModelAttribute("cardBanks")
//	public List<String> cardBanksData() {
//		ArrayList<String> cardBanks = new ArrayList<String>();
//		cardBanks.add("신한");
//		cardBanks.add("하나");
//		cardBanks.add("우리");
//		cardBanks.add("농협");
//		cardBanks.add("국민"); 
//		// add more
//		return cardBanks;			
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result, Model model) throws Exception {
				
		new UserFormValidator().validate(userForm, result);
		
		// 같은 이메일 아이디가 이미 존재할 경우 다시 form 띄움
		if (userService.getUserByUserId(userForm.getUser().getUserId()) != null) {
			result.reject("sameIdExist", new Object[] {}, null);
			return formViewName;
		}
		
		if (result.hasErrors()) {
			return formViewName;
		} else {
			userService.createUser(userForm.getUser());
			model.addAttribute("loginForm", new LoginForm());

			return successViewName;
		}
	}

}
