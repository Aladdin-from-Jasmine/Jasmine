package com.ssg.Jasmine.controller.book;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CategoryService;
import com.ssg.Jasmine.service.UserService;

@Controller
@RequestMapping(value="/book/register")
public class RegisterBookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;
	
//	@Autowired
//	UserService userService;
	
	@ModelAttribute("genres")
	public List<String> genreList(HttpServletRequest request) throws Exception {
		List<String> genres = categoryService.getAllGenres();
		return genres;
	}
	
	
	@ModelAttribute("bookForm")
	public BookForm formBackingObect(HttpServletRequest request) throws Exception {
		return new BookForm();
		
		
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String showForm(@ModelAttribute("bookForm") BookForm bookForm) {
//		System.out.println("dd");
//		return "book/register";
//		
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void test(ModelMap model) {
		BookForm bookForm=new BookForm();
		
		model.addAttribute("bookForm",bookForm);
		System.out.println("Tst");
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String submit(HttpServletRequest request, HttpSession session,
//			@ModelAttribute("bookForm") BookForm bookForm, BindingResult result, Model model) throws Exception {
//		
//		
//		
//		return "book/detail"; //리다이렉트 하는게 나을듯?
//	}
	
}
