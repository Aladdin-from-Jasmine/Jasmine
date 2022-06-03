package com.ssg.Jasmine.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.Jasmine.controller.user.UserForm;
import com.ssg.Jasmine.domain.User;

@Component
public class UserFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm regReq = (UserForm) target;

		// 필수 입력 항목
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "required");
	
		User user = regReq.getUser();
		
		/* userID 체크하는 부분 만들어야 됨~~*/
		if (regReq.isNewUser()) {
			//user.setStatus("OK");
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.userId", "USER_ID_REQUIRED", "User ID is required.");
			if (user.getPassword() == null || user.getPassword().length() < 1 ||
					!user.getPassword().equals(regReq.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH",
					 "Passwords did not match or were not provided. Matching passwords are required.");
			}
		}
		else if (user.getPassword() != null && user.getPassword().length() > 0) {
			if (!user.getPassword().equals(regReq.getRepeatedPassword())) {
				errors.reject("PASSWORD_MISMATCH", "Passwords did not match. Matching passwords are required.");
			}
		}
		
		String emailRegax = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$";
		if (!user.getEmail().equals("") && !user.getEmail().matches(emailRegax)) {
			errors.rejectValue("user.email", "typeMismatch"); // email type 검증
		}
		
		if (user.getPassword() != null && user.getPassword().length() > 0) {
			if (!user.getPassword().equals(regReq.getRepeatedPassword())) {
				errors.rejectValue("repeatedPassword", "invalidPassword");
			}
		}

		String phone = regReq.getUser().getPhone();
		if (!phone.equals("") && !phone.matches("^[0][1]\\d{1}-\\d{3,4}-\\d{4}$")) {
			errors.rejectValue("user.phone", "typeMismatch"); // 01x-xxx-xxxx or 01x-xxxx-xxxx인지 검증
		}

	}
}
