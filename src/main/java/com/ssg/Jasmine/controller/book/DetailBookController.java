package com.ssg.Jasmine.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.Category;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CategoryService;
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
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView bookDetail(@PathVariable("bookId") int bookId, HttpServletRequest request, HttpSession session) {
		Book book =  bookService.getBookByBookId(bookId);
		String genre = categoryService.getGenreByCategoryId(book.getCategoryId());
		//UserSession user  = (UserSession)request.getSession().getAttribute("userSession");
		//String userId = user.getUser().getUserId();

		try {
			
			System.out.println("input id:"+bookId);
			System.out.println("book title"+book.getIsbn());
			
			System.out.println("bookid:"+book.getBookId());
//			
//			return "Book";;;;
//			
			ModelAndView mav = new ModelAndView("book/detail");
			//mav.addObject("userId", userId);
			
			
			mav.addObject("book", book);
			mav.addObject("genre", genre);
			
			System.out.println(book.getCategoryId());
			
			return mav;
		} catch (Exception e) {
			// TODO: handle exception
			return new ModelAndView("book/detail_error");
		}
		
		
	}
}