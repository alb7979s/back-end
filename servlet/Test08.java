package com.coffee.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// tip] 톰캣 에러나면 맨 위부터 튀어나온거 하나씩 확인하면 됨
@WebServlet("/servlet/test08")
public class Test08 extends HttpServlet {
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
//		res.setContentType("taxt/html; charset=utf-8");	
		res.setContentType("image/jpg");
		OutputStream out = res.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		FileInputStream fis = new FileInputStream("c:/SSAFY/test.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		while (true) {
			int ch = bis.read();
			if (ch==-1) break;
			bos.write(ch);
		}
		bis.close();
		fis.close();
		bos.close();
		out.close();
	}
}
