package com.cooffee.pagemove;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagemove/forward")
public class ForwardServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 페이지 이동하기 - WebContent > pagemove > forward.jsp
		// forward 할 때 이거 이용해서 해줌 

		// 등록 - req가 관리하는 공유영역(한번의 요청에서 응답하기 전에 불려지는 모든 페이지)
		req.setAttribute("msg", "백준 반가워");
		req.setAttribute("dDay", new Date());
		
		RequestDispatcher rd = req.getRequestDispatcher("forward.jsp");	//매개변수에 이동할 페이지 주소 줌, 아래처럼 써도 됨
//		RequestDispatcher rd = req.getRequestDispatcher("/pagemove/forward.jsp");// forward는 프로젝트 안에서에서만 이동하므로 /했을때 프로젝트 경로까지 자동 포함
		rd.forward(req, resp);
	}
	
}


