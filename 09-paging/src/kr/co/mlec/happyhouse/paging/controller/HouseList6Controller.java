package kr.co.mlec.happyhouse.paging.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mlec.happyhouse.paging.service.HouseService;
import kr.co.mlec.happyhouse.paging.service.HouseServiceImpl;
import kr.co.mlec.happyhouse.repository.dto.PageDto;


@WebServlet("/house/list6")
public class HouseList6Controller extends HttpServlet {
	private HouseService service;
	public HouseList6Controller() {
		service = new HouseServiceImpl();
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageDto pageDto = new PageDto();
		try {
			pageDto.setPageNo(Integer.parseInt(request.getParameter("pageNo")));	
		} catch(NumberFormatException nfe) {}
		
		try {
			// ajax는 새로고침해서 쓰는 방식이 아님(데이터 공유 방식이 아님), js가 알 수 있는 형태의 데이터로 바꿔줘야함 그게 json!
			// json 일일이 바꾸면 힘드니까 gson.jar 이용할거에유
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(service.listPageHouse3(pageDto)));
			out.close();
//			Gson gson = new Gson();
//			String result = gson.toJson(service.listPageHouse3(pageDto));
//			
//			response.setContentType("application/json; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println(result);
//			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}










