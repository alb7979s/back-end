package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping(value= {"", "/list"})
	public String list(Integer pageNo, Model model) throws Exception {
		if(pageNo == null) { 
			pageNo = 1; 
		} 
		 
		Page page = new Page(pageNo);
		 
		Map<String, Object> list = hospitalService.listhospitalPage(page);
		model.addAttribute("result", list);
		
		return "hospital/list";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Integer pageNo, Model model) throws Exception {
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		
		String city = request.getParameter("city"); 
		String gugun = request.getParameter("gugun");
		
		if(pageNo == null) { 
			pageNo = 1; 
		} 
		 
		Page page = new Page(pageNo);
		Map<String, Object> result;
		
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> list;
		
		if(city!=null && city.length()!=0) { //관심지역 리스트
			city = city.substring(0, 2);

			params.put("city", city);
			params.put("gugun", gugun);
			list = hospitalService.searchHospitalPage(page, params);
			list.put("city", city);
			list.put("gugun", gugun);
		}
		else if(key==null || key.length()==0) { //초기화면 리스트
			return "hospital/list";
		}
		else { //검색 리스트
			params.put("key", key);
			params.put("word", word);
			list = hospitalService.searchHospitalPage(page, params);
			list.put("word", word);
			list.put("key", key);
		}
		
		model.addAttribute("result", list);
		
		return "hospital/list";
	}
}
