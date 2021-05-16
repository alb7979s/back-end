package com.ssafy.happyhouse.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.happyhouse.dto.Member;


@Component
public class ConfirmInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 공지사항 아이디 'admin'인 사람만 글 쓰는거 일단 막아놓음 관리자 페이지 만들면 다시 손보기
		/*
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userinfo");
		if(member == null || !"admin".equals(member.getId())) {
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath());
			return false;
		}
		*/
		return true;
	}

	
	
}
