package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test11")
public class Test11 extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");

		String id = req.getParameter("id");
		System.out.println("id : " + id);		
		String msg = req.getParameter("msg");
		System.out.println("msg : " + msg);		
		String r = req.getParameter("r");
		System.out.println("r : " + r);
		
		// checkbox 여러개 선택해도 하나만 넘어옴
		String cb = req.getParameter("cb");
		System.out.println("cb : " + cb);	
		// 이 메소드로 처리
		String[] cbArr = req.getParameterValues("cb");
		System.out.println("-----------------------");
		if(cbArr != null) {		//null이 들어올 수 있으니 한번 더 체크!
			for(String val: cbArr) {
				System.out.println(val);
			}
		}
	}
}
