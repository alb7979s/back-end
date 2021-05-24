package com.ssafy.happyhouse.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.happyhouse.dto.Member;

@Component
public class NoticeConfirmInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String admins[] = new String[] {"admin", "root"};		//이런거 따로 빼면 좋을듯?
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userinfo");
		for(String admin: admins) {
			if (member == null || !admin.equals(member.getId())) {
				response.sendRedirect("/notice");
				return false;
			}
		}
		return true;
	}

}
