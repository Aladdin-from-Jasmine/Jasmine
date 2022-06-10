package com.ssg.Jasmine.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.Jasmine.controller.community.CommunityForm;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CommunityService;

@Controller
public class DeleteBookController {
	@Autowired
	private BookService BookService;

	@RequestMapping("/book/delete/{bookId}")
	public String handleRequest(@PathVariable("bookId") int bookId) throws Exception {
	
		BookService.deleteBook(BookService.getBookByBookId(bookId));
		return "redirect:/book/list";
	}
}
