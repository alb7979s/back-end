package com.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.FavoriteDto;
import com.happyhouse.model.MemberDto;
import com.happyhouse.model.service.FavoriteService;
import com.happyhouse.model.service.FavoriteServiceImpl;

@WebServlet("/favorite")
public class FavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FavoriteService favoriteService;
	@Override
	public void init() throws ServletException {
		favoriteService = FavoriteServiceImpl.getFavoriteService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		if("set".equals(act)) {
			set(request, response);
		}else {
			search(request, response);
		}
	}
	private void set(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		FavoriteDto favoriteDto = new FavoriteDto();
		favoriteDto.setId(memberDto.getId());
		favoriteDto.setDong(request.getParameter("dong"));
		try {
			favoriteService.favoriteSet(favoriteDto);
			path = "/index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "문제발생");
			path = "/view/favorite/list.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto paramDto = (MemberDto) session.getAttribute("userinfo");
		try {
			List<AptDto> list = favoriteService.favoriteAreaSearch(paramDto);
			if(list != null) request.setAttribute("favoritedong", list.get(0).getDong());
			request.setAttribute("favoriteinfo", list);
			path = "/view/favorite/list.jsp";
					
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "문제발생");
			path = "/view/favorite/list.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
