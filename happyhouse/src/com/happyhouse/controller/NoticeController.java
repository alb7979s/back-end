package com.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happyhouse.model.MemberDto;
import com.happyhouse.model.NoticeDto;
import com.happyhouse.model.service.NoticeService;
import com.happyhouse.model.service.NoticeServiceImpl;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;


@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService noticeService;
	
	public void init() throws ServletException{
		super.init();
		noticeService = new NoticeServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		System.out.println(root);
		//test
		// HttpSession session = request.getSession();
		// MemberDto userinfo = new MemberDto();
		// userinfo.setId("ssafy");
		// userinfo.setEmail("ssafy@ssafy.com");
		// userinfo.setDpt("ho");
		// userinfo.setPwd("ssafy");
		// session.setAttribute("userinfo", userinfo);
		String act = request.getParameter("act");
		System.out.println("act:"+act);
		if("list".equals(act)) {
			System.out.println("list");
			list(request,response);
		}else if("mvwrite".equals(act)) {
			System.out.println("mvwrite");
			response.sendRedirect("view/notice/write.jsp");
		}else if("write".equals(act)) { // write
			System.out.println("write");
			write(request,response);
		}else if("mvmodify".equals(act)) {
			System.out.println("mvmodify");
			moveModifyNotice(request,response);
		}else if("modify".equals(act)) {
			System.out.println("modidy");
			modify(request,response);
		}else if("delete".equals(act)) {
			System.out.println("delete");
			delete(request,response);
		}else if("detail".equals(act)) {
			System.out.println("detail");
			detail(request,response);
		}else if("mvmodify".equals(act)) {
			System.out.println("mvmodify");
			mvmodify(request,response);
		}else if("modify".equals(act)) {
			System.out.println("modify");
			modify(request,response);
		}else {
			System.out.println("너는 무엇이니?");
			list(request,response);			
		}
	}



	private void mvmodify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String path = root + "/notice?act=list";
		int noticeno = Integer.parseInt(request.getParameter("number"));
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeno = Integer.parseInt(request.getParameter("number"));
		String path = "/view/notice/detail.jsp";
		try {
			NoticeDto noticeDto = noticeService.getNotice(noticeno);
			request.setAttribute("notice", noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글수정 처리 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);	
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String path = "notice?act=list";
		System.out.println(root);
		int noticeno = Integer.parseInt(request.getParameter("number"));
		try {
			noticeService.deleteNotice(noticeno);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String path = "/notice?act=list";
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setNoticeno(Integer.parseInt(request.getParameter("noticeno")));
		noticeDto.setSubject(request.getParameter("subject"));
		noticeDto.setContent(request.getParameter("content"));
		System.out.println(noticeDto);
		try {
			noticeService.modifyNotice(noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글작성중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void moveModifyNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/list.jsp";
		int noticeno = Integer.parseInt(request.getParameter("number"));
		
		try {
			NoticeDto noticeDto = noticeService.getNotice(noticeno);
			request.setAttribute("notice", noticeDto);
			path = "/view/notice/modify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글수정 처리 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);	
		
	}
	private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		System.out.println(root);
		String path = "/index.jsp";

		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		System.out.println(memberDto.getId());


		if(memberDto != null) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setUserid(memberDto.getId());
			noticeDto.setSubject(request.getParameter("subject"));
			noticeDto.setContent(request.getParameter("content"));
			try {
				noticeService.writeNotice(noticeDto);
				path = root + "/notice?act=list";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성중 문제가 발생했습니다.");
				path = "/error/error.jsp";
			}
		} else {
			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
			path = "/error/error.jsp";
		}
		response.sendRedirect(path);
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/view/notice/list.jsp";
		try {
			List<NoticeDto> list = noticeService.listNotice();
			request.setAttribute("notices", list);
			path = "/view/notice/list.jsp";
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("POST");
		doGet(request, response);
	}

}
