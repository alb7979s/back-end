package com.happyhouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happyhouse.model.MemberDto;
import com.happyhouse.model.service.LoginService;
import com.happyhouse.model.service.LoginServiceImpl;
import com.happyhouse.model.service.MemberService;
import com.happyhouse.model.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	private MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		loginService = LoginServiceImpl.getloginService();
		memberService = MemberServiceImpl.getMemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
		String act = request.getParameter("act");
		if ("join".equals(act)){
			join(request, response);
		}else if("login".equals(act)) {
			login(request, response);
		} else if("logout".equals(act)){
			logout(request, response);
		} else if("withdraw".equals(act)){
			withdraw(request, response);
		} else if("modify".equals(act)){
			modify(request, response);
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String dpt = request.getParameter("dpt");
		String email = request.getParameter("email");
		MemberDto paramDto = new MemberDto();
		paramDto.setId(id);
		paramDto.setPwd(pwd);
		paramDto.setDpt(dpt);
		paramDto.setEmail(email);
		try {
			memberService.modify(paramDto);
			response.sendRedirect(request.getContextPath() + path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "?????? ?????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

	private void withdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto paramDto = new MemberDto();
		paramDto.setId(request.getParameter("id"));
		String path = "/index.jsp";
		try {
			memberService.withdraw(paramDto);
			logout(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "?????? ?????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ???????????? ????????? ???????????? ???????????? ?????? ?????? ??? ??? ????????? ????????????
		MemberDto paramDto = new MemberDto();
		// front????????? ??? ???????????? ??????????????? ???????????????
		paramDto.setId(request.getParameter("id"));
		paramDto.setPwd(request.getParameter("pwd"));
		paramDto.setDpt(request.getParameter("dpt"));
		paramDto.setEmail(request.getParameter("email") + "@" + request.getParameter("emaildomain"));
		
		String path = "/index.jsp";
		try {
			memberService.join(paramDto);
			response.sendRedirect(request.getContextPath() + path);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "???????????? ?????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		try {
			MemberDto paramDto = new MemberDto();
			paramDto.setId(id);
			paramDto.setPwd(pwd);
			MemberDto memberDto = loginService.login(paramDto);
			if(memberDto != null) {
//				session ??????
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
			} else {
				path = "view/member/login.jsp";
				request.setAttribute("msg", "????????? ?????? ???????????? ?????? ??? ???????????? ?????????.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "????????? ??? ????????? ??????????????????.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}
	
	
	
}
