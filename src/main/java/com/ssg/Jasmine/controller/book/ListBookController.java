package com.ssg.Jasmine.controller.book;

import java.util.List;
//hihi
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.Community;
import com.ssg.Jasmine.domain.User;

@Controller
@RequestMapping("/book/list")
public class ListBookController {

	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

		
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView bookList(SessionStatus sessionStatus, HttpSession session, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("book/list");
		
		List<Book> bookList = bookService.getBookList();
		mav.addObject("bookList", bookList);		
		mav.addObject("listSize", bookList.size());
		
		String page = request.getParameter("page");
		PagedListHolder<Book> pagedBookList;
		
		if (page == null) {
			pagedBookList = new PagedListHolder<Book>(bookList);
			pagedBookList.setPageSize(4);
			request.getSession().setAttribute("BookController_bookList", pagedBookList);
		}
		else {
			pagedBookList = (PagedListHolder<Book>)request.getSession().getAttribute("BookController_bookList");
			if (pagedBookList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				pagedBookList.nextPage();
			}
			else if ("previous".equals(page)) {
				pagedBookList.previousPage();
			}	
		}
		return new ModelAndView("book/list", "bookList", pagedBookList);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView searchList(HttpServletRequest request) throws Exception {

		System.out.println("list book post");
		
		String keyword = request.getParameter("keyword");
		
		System.out.println(keyword);
		
		List<Book> bookList = bookService.getSearchBookList(keyword);
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bookList", bookList);
		mav.addObject("listSize", bookList.size());
		mav.addObject("keyword", keyword);
		
		mav.setViewName("book/list"); 
		String page = request.getParameter("page");
		PagedListHolder<Book> pagedBookList;
		
		if (page == null) {
			pagedBookList = new PagedListHolder<Book>(bookList);
			pagedBookList.setPageSize(4);
			request.getSession().setAttribute("BookController_bookList", pagedBookList);
		}
		else {
			pagedBookList = (PagedListHolder<Book>)request.getSession().getAttribute("BookController_bookList");
			if (pagedBookList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				pagedBookList.nextPage();
			}
			else if ("previous".equals(page)) {
				pagedBookList.previousPage();
			}	
		}
		return new ModelAndView("book/list", "bookList", pagedBookList);

	}
	
}