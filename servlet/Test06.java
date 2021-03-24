/*
 *	Servlet 상속관계
 *	
 *	Servlet
 *
 * 	GenericServlet (implements Servlet)
 * 
 * 	HttpServlet	(extends GenericServlet)
 * 
 */
package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test06")
public class Test06 extends HttpServlet {
	// 처음 찍어보면 위 두개 찍힘
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init 호출");
//	}
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service 호출");
//	}
	// 위 두개 주석처리 하면 얘 찍힘, 부모에 있는애가 불러줌
//	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("service(http) 호출");
//	}
	// 이 위까지 주석 막으면 get호출 찍힘, 부모의 httpServlet이 불러줌
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("doGet(http) 호출");
//	}
	// 여기까지 막아버리면, 에러남, post만 구현했는데 get방식을 부르려해서
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("doPost(http) 호출");
//	}
	// 다 막으면 에러 안뜸 ?? 나 왜 에러 뜸?
}
