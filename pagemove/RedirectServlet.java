package com.cooffee.pagemove;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagemove/redirect")
public class RedirectServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 등록 - req가 관리하는 공유영역(한번의 요청에서 응답하기 전에 불려지는 모든 페이지)
		req.setAttribute("msg", "백준 반가워");
		req.setAttribute("dDay", new Date());
		
		resp.sendRedirect(req.getContextPath() + "/pagemove/redirect.jsp");	// redirect는 어디든 갈 수 있으니 경로 생략 안됨 
	}
	
}


