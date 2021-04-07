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

@WebServlet("/house/list1")
public class HouseList1Controller extends HttpServlet {
	
	private HouseService service;
	public HouseList1Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 생성자 가보면 pageDto의 pageNo 기본값이 1로 되어있음
		PageDto pageDto = new PageDto();
		// 페이지 안누른 상태로 pageNo 가져왔을때 null임 그거 처리해줌
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch(NumberFormatException nfe) {}
		
		try {
			Map<String, Object> result = service.listPageHouse2(pageDto);
			request.setAttribute("list", result.get("list"));
			// 마지막 페이지 구하기
			int count = (Integer)result.get("count");
			int lastPage = (int)Math.ceil(count / 10d);
			
			request.setAttribute("pageNo", pageDto.getPageNo());	//요청한 페이지 번호
			request.setAttribute("count", count); 					//게시물 전체 갯수
			request.setAttribute("lastPage", lastPage);				//하단에 출력될 마지막 페이지 번호
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/house/list1.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	public static void main(String[] args) {
		// page 번호 구하기~ cnt가 페이지 개수라 하면
		for(int cnt = 1; cnt <= 30; cnt++) {
//			1.
//			System.out.println(cnt + " " + (cnt % 10 == 0 ? cnt / 10 : cnt / 10 + 1));
//			2.
//			System.out.println(cnt + " " + (int)Math.ceil(cnt / 10d));
//			3.
			System.out.println(cnt + " " + (((cnt-1)/10)+1));
		}
	}
}










