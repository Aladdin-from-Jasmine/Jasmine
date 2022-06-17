package com.ssg.Jasmine;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//	@Autowired
//	@Qualifier(value = "signonInterceptor")
//	private HandlerInterceptor interceptor;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// index
		registry.addViewController("/index").setViewName("index");	
		
		// community view
		registry.addViewController("/community/create").setViewName("community/create");
		registry.addViewController("/community/update").setViewName("community/update");
		registry.addViewController("/community/detail").setViewName("community/detail");
		registry.addViewController("/community/list").setViewName("community/list");		
		
		// manager view
		registry.addViewController("/manager/user").setViewName("manager/user");
		registry.addViewController("/manager/book").setViewName("manager/book");
		registry.addViewController("/manager/auction").setViewName("manager/auction");
		registry.addViewController("/manager/community").setViewName("manager/community");

		//user
		registry.addViewController("/user/register").setViewName("user/register");
		registry.addViewController("/user/detail").setViewName("user/detail");
		registry.addViewController("/user/book").setViewName("user/book");
		registry.addViewController("/user/auction").setViewName("user/auction");
		registry.addViewController("/user/bid").setViewName("user/bid");
		registry.addViewController("/user/order").setViewName("user/order");
		registry.addViewController("/user/update").setViewName("user/update");
		registry.addViewController("/user/login").setViewName("user/login");
		registry.addViewController("/user/logout").setViewName("user/logout");
		registry.addViewController("/user/delete").setViewName("user/delete");
		
		//aution
		registry.addViewController("/auction/auction_list").setViewName("auction/auction_list");
		registry.addViewController("/auction/auction_form").setViewName("auction/auction_form");
		registry.addViewController("/auction/auction_detail").setViewName("auction/auction_detail"); 
		
	
		//book
		registry.addViewController("/book/list").setViewName("book/list");
		registry.addViewController("/book/detail").setViewName("book/detail");
		registry.addViewController("/book/detail_error").setViewName("book/detail_error");
		registry.addViewController("/book/register").setViewName("book/register");
	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(interceptor)
//				.addPathPatterns("/index");		
//	}
//	
	@Override		
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.order(2);		
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("messages.validation");
		source.setDefaultEncoding("UTF-8");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
	
}

