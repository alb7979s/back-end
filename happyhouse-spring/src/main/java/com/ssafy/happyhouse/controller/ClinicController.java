package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.service.ClinicService;

@Controller
@RequestMapping("/clinic")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping(value= {"", "/list"})
	public String list(Model model) throws Exception {
		List<Clinic> list = clinicService.clinicList();
		model.addAttribute("clinicinfo", list);
		return "clinic/list";
	}
}
