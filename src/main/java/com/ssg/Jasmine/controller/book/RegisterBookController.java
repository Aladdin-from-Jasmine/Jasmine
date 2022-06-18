package com.ssg.Jasmine.controller.book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Book;
import com.ssg.Jasmine.domain.Category;

import com.ssg.Jasmine.service.BookService;
import com.ssg.Jasmine.service.CategoryService;
import com.ssg.Jasmine.service.UserService;
import com.ssg.Jasmine.validator.BookFormValidator;

@Controller
@RequestMapping(value="/book/register")
public class RegisterBookController implements ApplicationContextAware{
	@Value("/images/")
	private String uploadDirLocal;
	private WebApplicationContext context;	
	private String uploadDir;
	
	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;	
	
	@Override					
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath(this.uploadDirLocal);
		System.out.println(this.uploadDir);
	}
	
	@ModelAttribute("genres")
	public List<Category> genreList(HttpServletRequest request) throws Exception {
		List<Category> genres = categoryService.getAllGenres();
		return genres;
	}
	
	
	@ModelAttribute("bookForm")
	public BookForm formBackingObect(HttpServletRequest request) throws Exception {
		return new BookForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void showRegisterForm(ModelMap model) {
		BookForm bookForm=new BookForm();
		
		model.addAttribute("bookForm",bookForm);
		System.out.println("get 호출됨");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("bookForm") BookForm bookForm, BindingResult result,
			Model model, SessionStatus sessionStatus) throws Exception {
		
		new BookFormValidator().validate(bookForm, result);

		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			mav.setViewName("book/register"); 
			return "book/register";
		}
		else {
			MultipartFile report = bookForm.getReport();
			String filename = uploadFile(report);
			model.addAttribute("fileUrl", this.uploadDirLocal + filename);

			
			
			UserSession user = (UserSession)request.getSession().getAttribute("userSession");
			String userId = user.getUser().getUserId();
			session.setAttribute("bookForm", bookForm);
			
			//String bookId =bookForm.getTitle();
			model.addAttribute("userId",userId);
			model.addAttribute("bookForm", bookForm);
			
			//String genre = categoryService.getGenreByCategoryId(bookForm.getCategoryId());
			
			Book book = new Book();
			book.setIsbn(bookForm.getIsbn());
			book.setPrice(bookForm.getPrice());
			book.setCategoryId(bookForm.getCategoryId());
			book.setTitle(bookForm.getTitle());
			book.setAuthor(bookForm.getAuthor());
			book.setPublisher(bookForm.getPublisher());
			book.setUserId(userId);
			book.setImg(this.uploadDirLocal + filename);
			book.setDescription(bookForm.getDescription());
			System.out.println("img: "+book.getImg());
			
			
			
			System.out.println(userId);
			
			bookService.createBook(book);
			
			
			sessionStatus.setComplete();
			
			
			return "redirect:/book/detail/"+book.getBookId();
		}
		

	}
	
	private String uploadFile(MultipartFile report) {
		String filename = UUID.randomUUID().toString() 
						+ "_" + report.getOriginalFilename();
		File file = new File(this.uploadDir + filename);
		try {
			report.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	
}
