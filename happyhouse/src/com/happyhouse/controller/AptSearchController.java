package com.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.service.AptService;
import com.happyhouse.model.service.AptServiceImpl;

@WebServlet("/aptsearch")
public class AptSearchController extends HttpServlet {
	
	private AptService aptService;

	@Override
	public void init() throws ServletException {
		aptService = new AptServiceImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String root = req.getContextPath();
		String act = req.getParameter("act");
		
		citySearch(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
	private void citySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/index.jsp";
		String key = req.getParameter("key");
		String word = req.getParameter("word");
		
		try {
			List<AptDto> list = aptService.aptSearch(key, word);
			req.setAttribute("aptinfo", list);
			path = "/view/apt/searchResult.jsp";
					
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "문제발생");
			path = "/view/error500.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
