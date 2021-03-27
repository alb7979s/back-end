package com.coffee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url _랑 대문자 잘 안씀
@WebServlet("/servlet/test07")
public class Test07 extends HttpServlet {
	// post로 받고싶으면 service대신 doPost로만 바꿔주면 됨 매개변수 같음(service는 둘 다 받음)
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		/*
		 * 응답하기
		 * 
		 * 응답하려는 데이터의 형태를 브라우저에게 알려준다.
		 * setContentType("MainType/SubType; 인코딩");
		 * Ex1. setContentType("text/plain; charset=utf-8");
		 * Ex2. setContentType("text/html; charset=utf-8");
		 * Ex3. setContentType("text/xml; charset=utf-8");
		 * Ex4. setContentType("image/jpeg");
		 * Ex5. setContentType("application/json; charset=utf-8");
		 * ...
		 * tip) 위에서 오타나면 브라우저가 해석 못해서 다운로드를 해버림
		 * 
		 * 응답하려는 데이터가 문자 형태일때
		 * PrintWriter ServletResponse.getWriter()
		 * 
		 * 응답하려는 데이터가 바이트 형태일때
		 * OutputStream ServletResponse.getOutputStream()
		 */
		
//		res.setContentType("text/plain; charset=utf-8");
//		res.setContentType("text/html; charset=utf-8");
		res.setContentType("text/xml; charset=utf-8");	//charset 사용자가 내게 요청한거랑은 별도고, 내가 보내줄때 참조하라고
//		res.setContentType("taxt/html; charset=utf-8");	 	이렇게 오타나면 다운로드 됨
		PrintWriter out = res.getWriter();
//		out.println("<h2>hello 안녕</h2>");		//기냥하면 한글 깨짐! 그래서 전송하려는 데이터 형태를 브라우저한테 알려줘야함 
		out.println("<family><father>홍길동</father><mother>짱구엄마</mother></family>");	 
		out.close();
	}
}
