/*
 * 서블릿의 life-cycle 관련 메서드
 * 	*****서블릿 객체의 메모리는 하나만 생성되어 같은 서블릿이 사용된다.
 * 
 * init(ServletConfig) - 서블릿이 메모리에 올라갈 때 최초 한번만 실행
 * 
 * service(ServletRequest, ServletResponse) - 서블릿이 호출될 때 마다 실행
 * 
 * destroy() - 서블릿이 메모리에서 내려갈때 호출(서블릿 내용이 바뀌거나 할 때)
 */
package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/test05")
public class Test05 extends GenericServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service 호출");
	}
}
