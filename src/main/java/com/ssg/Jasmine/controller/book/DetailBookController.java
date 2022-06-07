package com.ssg.Jasmine.controller.book;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.JasmineFacade;
import com.ssg.Jasmine.service.UserService;

@Controller
@RequestMapping("/book/detail/{bookId}")
public class DetailBookController {

	//private static final String BOOK_LIST = "book/detail";

	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView bookDetail(@PathVariable("bookId") int bookId, SessionStatus sessionStatus, HttpSession session) {
//			@RequestParam("bookID") String bookId,
//			ModelMap model) throws Exception {
//		Book book = this.jasmine.getBook(bookId);
//		model.put("book", book);
		
		
		
		Book book =  bookService.getBookByBookId(bookId);

		try {
			System.out.println("input id:"+bookId);
			System.out.println("book title"+book.getIsbn());
			
			System.out.println("bookid:"+book.getBookId());
//			
//			return "Book";;;;
//			
			ModelAndView mav = new ModelAndView("book/detail");
			mav.addObject("book", book);
			return mav;
		} catch (Exception e) {
			// TODO: handle exception
			return new ModelAndView("book/detail_error");
		}
		
		
	}
}