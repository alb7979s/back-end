/*
 * 클래스가 서블릿으로 동작하기 위해서는 Servlet 인터페이스 타입이어야 한다.
 * 어노테이션을 이용한 연결(@)
 */
package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
 * xml에서 선언해준 아래 내용들을 한줄로 대체 가능 
  <servlet>
  	<servlet-name>test01</servlet-name>
  	<servlet-class>com.coffee.servlet.Test01</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>test01</servlet-name>
	<url-pattern>/servlet/test01</url-pattern>
  </servlet-mapping>
 */
@WebServlet("/servlet/test02")		//이렇게. 3.x부터 가능
public class Test02 implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	// 보통 init, service 이 두개 씀 
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("어노테이션을 이용한 서블릿 호출");
	}
	
}
