package com.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happyhouse.model.ClinicDto;
import com.happyhouse.model.HospitalDto;
import com.happyhouse.model.service.HostpitalService;
import com.happyhouse.model.service.ClinicService;
import com.happyhouse.model.service.ClinicServiceImpl;
import com.happyhouse.model.service.HospitalServiceImpl;

@WebServlet("/clinic")
public class ClinicController extends HttpServlet {
	private ClinicService clinicService;

	public ClinicController() {
		clinicService = new ClinicServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		clinicList(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	private void clinicList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/view/clinic/list.jsp";
		
		try {
			List<ClinicDto> list = clinicService.clinicList();
			req.setAttribute("clinicinfo", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "문제발생");
			path = "/view/error500.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
}
