package kr.co.mlec.happyhouse.paging.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.happyhouse.paging.service.HouseService;
import kr.co.mlec.happyhouse.paging.service.HouseServiceImpl;
import kr.co.mlec.happyhouse.repository.dto.PageDto;


@WebServlet("/house/list3")
public class HouseList3Controller extends HttpServlet {
	private HouseService service;
	public HouseList3Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch(NumberFormatException nfe) {}
		
		try {
			Map<String, Object> result = service.listPageHouse3(pageDto);
			request.setAttribute("result", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/house/list3.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}










