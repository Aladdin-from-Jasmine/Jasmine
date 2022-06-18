package com.ssg.Jasmine.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.UserService;

@Component
public class AuthenticatorImpl implements Authenticator {

	@Autowired
	private UserService userService;
	
	@Override
	public void authenticate(LoginForm loginForm) {
		User realUser = userService.getUserByUserId(loginForm.getUserId());

		if (realUser == null) {
			throw new AuthenticationException("noSuchUser");
		}
		
		if (!realUser.matchPassword(loginForm.getPassword())) {
			throw new AuthenticationException("notMatchPassword");
		}
	}
	
}
