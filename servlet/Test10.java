package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test10")
public class Test10 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 사용자가 보내준 데이터 추출하기
		// get 방식 :  ~~/test10?msg=aaaa 하면 aaaa라는 값이 넘어옴
		// Ex. http://localhost:8080/99-coffee/servlet/test10?msg=hello		
		System.out.println("GET");
		String msg = req.getParameter("msg");
		System.out.println("msg : " + msg);
	}
	/*
	 * 사용자가 post 방식으로 데이터를 전송하려면
	 * 꼭 form의 method 속성을 "post"로 설정해서 호출해야함(ajax배제) 
	 */
	// tip] WebContent - WEB-INF 에 html 만들면 직접 접근 불가, 서버 통해서 접근해야함 (보안)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 사용자가 전송한 파라미터 한글처리! (사용자가 보내준 파라미터에 대한 처리)
		req.setCharacterEncoding("utf-8");
		System.out.println("POST");
		String msg = req.getParameter("msg");
		System.out.println("msg : " + msg);		
	}
}
