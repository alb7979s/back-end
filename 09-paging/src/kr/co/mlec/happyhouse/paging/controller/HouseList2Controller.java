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


@WebServlet("/house/list2")
public class HouseList2Controller extends HttpServlet {
	private final int BLOCK_SIZE = 10;
	private final int LIST_SIZE = 10;
	private HouseService service;
	public HouseList2Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch(NumberFormatException nfe) {}
		
		try {
			Map<String, Object> result = service.listPageHouse2(pageDto);
			request.setAttribute("list", result.get("list"));
			// 마지막 페이지 구하기
			int count = (Integer)result.get("count");
			int lastPage = (int)Math.ceil(count / (double)LIST_SIZE);
			
			int pageNo = pageDto.getPageNo();
			request.setAttribute("pageNo", pageDto.getPageNo());	//요청한 페이지 번호
			request.setAttribute("count", count); 					//게시물 전체 갯수
			request.setAttribute("lastPage", lastPage);				//하단에 출력될 마지막 페이지 번호
			
			// 화면 하단 페이지 블럭 구하기
			int currentBlock = (int) Math.ceil(pageNo / (double)BLOCK_SIZE);
			int beginPage = (currentBlock - 1) * BLOCK_SIZE + 1;
			int endPage = Math.min((currentBlock * BLOCK_SIZE), lastPage);	
			
			// 이전 페이지와 다음 페이지 설정하기
			boolean prev = beginPage != 1;
			boolean next = endPage != lastPage;
			
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("prev", prev);
			request.setAttribute("next", next);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/house/list2.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}










