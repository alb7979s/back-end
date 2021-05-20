package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.service.ClinicService;

@Controller
@RequestMapping("/clinic")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping(value= {"", "/list"})
	public String list(Integer pageNo, Model model) throws Exception {
		
		if(pageNo == null) { 
			pageNo = 1; 
		} 
		 
		Page page = new Page(pageNo);
		 
		Map<String, Object> list = clinicService.listclinicPage(page);
		System.out.println(list);
		model.addAttribute("result", list);
		
		return "clinic/list";
	}
}
