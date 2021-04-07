package kr.co.mlec.happyhouse.paging.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.happyhouse.paging.service.HouseServiceImpl;
import kr.co.mlec.happyhouse.paging.service.HouseService;
import kr.co.mlec.happyhouse.repository.dto.HouseDto;

@WebServlet("/house/list0")
public class HouseList0Controller extends HttpServlet {
	
	private HouseService service;
	public HouseList0Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<HouseDto> list = service.listPageHouse1();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/house/list0.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}










