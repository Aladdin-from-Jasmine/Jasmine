package com.ssg.Jasmine.controller.book;

import java.util.List;
import java.util.Map;

//hihi
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import com.ssg.Jasmine.controller.user.UserSession;
//import com.ssg.Jasmine.domain.Auction;
//import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.service.BookService;
//import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.Book;
//import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.domain.User;
//import com.ssg.Jasmine.service.BidService;

@Controller
@RequestMapping("/book/list")
public class ListBookController {

	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

		
//	@RequestMapping(method=RequestMethod.GET)
//	public ModelAndView bookList(SessionStatus sessionStatus, HttpSession session)
//	{
//		ModelAndView mav = new ModelAndView("book/list");
//		
//		List<Book> bookList = bookService.getBookList();
//		mav.addObject("bookList", bookList);		
//		mav.addObject("listSize", bookList.size());
//		
//		return mav;
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String boardList(ListBookCriteria cri, Model model, Book book) throws Exception {
		
		// 전체 글 개수
		int boardListCnt = bookService.bookListCnt();

		// 페이징 객체
		ListBookPaging paging = new ListBookPaging();
		paging.setCri(cri);
		paging.setTotalCount(boardListCnt);			
		
		List<Book> list = bookService.bookList(cri);		
		model.addAttribute("bookList", list);	
		model.addAttribute("paging", paging);	
//		model.addAttribute("stateCode", stateCode);

		return "book/list";
	}
	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView search(SessionStatus sessionStatus, HttpSession session)
//	{
//		ModelAndView mav = new ModelAndView("book/list");
//		
//		List<Book> bookList = bookService.getBookList();
//		mav.addObject("bookList", bookList);		
//		mav.addObject("listSize", bookList.size());
//		
//		return mav;
//	}
}