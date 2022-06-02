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

		registry.addViewController("/user/register").setViewName("user/register");
		registry.addViewController("/user/mypage").setViewName("user/mypage");
		
		//aution
		registry.addViewController("/aution/aution_list").setViewName("aution/aution_list");
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

