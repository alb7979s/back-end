package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.service.AptService;

@Controller
public class AptSearchController extends HttpServlet {
	
	@Autowired
	private AptService aptService;

	@RequestMapping(value="/apt", method=RequestMethod.POST)
	public String citySearch(String key, String word, Model model) throws Exception {
		List<Apt> list = aptService.aptSearch(key, word);
		model.addAttribute("aptinfo", list);
//		System.out.println(key+" "+word);//검색 key, word 출력 ok
//		System.out.println(list);
		return "apt/searchResult";
	}
	
}
