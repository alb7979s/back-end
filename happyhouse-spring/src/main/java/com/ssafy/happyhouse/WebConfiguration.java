package com.ssafy.happyhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ssafy.happyhouse.interceptor.ConfirmInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private ConfirmInterceptor comfirmIntercepter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(comfirmIntercepter).addPathPatterns("/notice/*")
		.excludePathPatterns("/notice/list")
		.excludePathPatterns("/notice/detail")
		.excludePathPatterns("/notice/");
	}

}
//  concat('%', #{word}, '%')