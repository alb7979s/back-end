/*
 * 클래스가 서블릿으로 동작하기 위해서는 Servlet 인터페이스 타입이어야 한다.
 * GenericServlet을 이용한 연결(@), 사실 이미 있었음 
 */
package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/test04")
public class Test04 extends GenericServlet {
	// 서블릿의 life-cycle method (서블릿 불리면 자동 실행하는 메서드)
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("GenericServlet을 이용한 서블릿 호출");
	}
}
