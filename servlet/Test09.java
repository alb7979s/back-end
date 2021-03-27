package com.coffee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test09")
public class Test09 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청에 관한 것들 기억하기, 많이씀!
		System.out.println("ContextPath : " + request.getContextPath());		
		System.out.println("Method : " + request.getMethod());
		System.out.println("RequestURI : : " + request.getRequestURI());
	}

}
