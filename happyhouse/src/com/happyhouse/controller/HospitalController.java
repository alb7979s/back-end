package com.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happyhouse.model.HospitalDto;
import com.happyhouse.model.service.HostpitalService;
import com.happyhouse.model.service.HospitalServiceImpl;

@WebServlet("/hospital")
public class HospitalController extends HttpServlet {
	private HostpitalService hospitalService;

	public HospitalController() {
		hospitalService = new HospitalServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		hospitalList(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	private void hospitalList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/view/hospital/list.jsp";
		
		try {
			List<HospitalDto> list = hospitalService.hospitalList();
			req.setAttribute("hosinfo", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "문제발생");
			path = "/view/error500.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
}
