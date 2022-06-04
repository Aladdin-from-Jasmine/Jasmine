package com.ssg.Jasmine;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
		registry.addViewController("/user/list").setViewName("user/list");
		registry.addViewController("/user/order").setViewName("user/order");
		registry.addViewController("/user/update").setViewName("user/update");
		registry.addViewController("/user/login").setViewName("user/login");
		registry.addViewController("/user/logout").setViewName("user/logout");
		registry.addViewController("/user/delete").setViewName("user/delete");
		
		//aution
		registry.addViewController("/auction/auction_list").setViewName("auction/auction_list");
		registry.addViewController("/auction/auction_form").setViewName("auction/auction_form");
		registry.addViewController("/auction/auction_detail").setViewName("auction/auction_detail");
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
	
}

