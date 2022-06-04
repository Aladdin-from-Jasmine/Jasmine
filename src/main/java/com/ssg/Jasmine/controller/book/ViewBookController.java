package com.ssg.Jasmine.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.service.JasmineFacade;

@Controller
public class ViewBookController {

	private JasmineFacade jasmine;
	
	@Autowired(required=false)
	public void setJasmine(JasmineFacade jasmine) {
		this.jasmine = jasmine;
	}
	
	@RequestMapping("/viewBook")
	public String handleRequest(
			@RequestParam("bookID") String bookId,
			ModelMap model) throws Exception {
		Book book = this.jasmine.getBook(bookId);
		model.put("book", book);
		
		return "Book";
		
		
	}
}