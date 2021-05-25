package com.ssafy.happyhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ssafy.happyhouse.interceptor.ConfirmInterceptor;
import com.ssafy.happyhouse.interceptor.NoticeConfirmInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private NoticeConfirmInterceptor noticeComfirmInterceptor;
	@Autowired
	private ConfirmInterceptor comfirmInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(noticeComfirmInterceptor).addPathPatterns("/notice/*")
		.excludePathPatterns("/notice/list")
		.excludePathPatterns("/notice/detail")
		.excludePathPatterns("/notice/");
		
		registry.addInterceptor(comfirmInterceptor).addPathPatterns("/member/moveModify");
//		registry.addInterceptor(comfirmInterceptor).addPathPatterns("/community/write");
		
	}

}
//  concat('%', #{word}, '%')