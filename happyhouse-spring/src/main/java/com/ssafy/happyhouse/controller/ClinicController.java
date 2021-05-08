package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.service.ClinicService;
import com.ssafy.happyhouse.service.ClinicServiceImpl;
import com.ssafy.happyhouse.service.HospitalServiceImpl;
import com.ssafy.happyhouse.service.HospitalService;

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
