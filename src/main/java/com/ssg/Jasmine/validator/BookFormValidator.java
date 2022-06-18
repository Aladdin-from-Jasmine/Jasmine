package com.ssg.Jasmine.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.Jasmine.controller.book.BookForm;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.CategoryService;

@Component
public class BookFormValidator implements Validator{
	

	
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		
		
		
		BookForm regReq = (BookForm)target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "report", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryId", "required");
		
		
		
		if(regReq.getIsbn().length() != 13) {
			errors.rejectValue("isbn", "isbnLength");
		}
		
		if(regReq.getPrice()<=0) {
			errors.rejectValue("price", "invalidPrice");
		}
		
		
		
		if(regReq.getCategoryId()<1 || regReq.getCategoryId()>16) {
			errors.rejectValue("categoryId", "invalidCategoryId");
		}
		
	}

}
