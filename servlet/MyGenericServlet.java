package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 추상메서드 하나라도 있는 클래스는 추상클래스로 선언되어야함
public abstract class MyGenericServlet implements Servlet{
	@Override
	public void destroy() {
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	// 쓰는곳에서 @Override도 안하고 service이게 오타가 나면 에러 체크 안됨 그거 처리해주려고! 이 service를 추상메서드로 만들어주면 됨	
	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;
}
