package com.ssg.Jasmine.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.Jasmine.domain.Community;
import org.springframework.stereotype.Component;

@Component
public class CommunityFormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Community.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content_", "required");
	}
}
