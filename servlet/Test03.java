/*
 * 클래스가 서블릿으로 동작하기 위해서는 Servlet 인터페이스 타입이어야 한다.
 * MyGenericServlet을 이용한 연결(@)
 */
package com.coffee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/test03")		//클래스 같은데, url 같으면 안됨!
public class Test03 extends MyGenericServlet {
	//service 말고 안쓸건데 굳이 다 쓸필요 없음! MyGenericServlet를 따로 만들어서 얘를 상속해줄 수 있음, 그래서 필요한거만 정의해서 쓰면 됨
//	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("MyGenericServlet을 이용한 서블릿 호출");
	}
	
}
