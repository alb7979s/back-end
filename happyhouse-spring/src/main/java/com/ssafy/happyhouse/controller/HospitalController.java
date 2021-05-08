package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.service.ClinicService;
import com.ssafy.happyhouse.service.HospitalServiceImpl;
import com.ssafy.happyhouse.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping(value= {"", "/list"})
	public String list(Model model) throws Exception {
		System.out.println("test");
		List<Hospital> list = hospitalService.hospitalList();
		model.addAttribute("hosinfo", list);
		return "hospital/list";
	}
}
