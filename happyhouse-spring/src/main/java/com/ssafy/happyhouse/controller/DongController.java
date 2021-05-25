package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.dto.Dong;
import com.ssafy.happyhouse.service.DongServiceImpl;


@Controller
public class DongController extends HttpServlet {
	
	@Autowired
	private DongServiceImpl dongService;

	@RequestMapping(value="/dongInfo", method=RequestMethod.POST)
	@ResponseBody
	public List<Dong> list(@RequestBody String dong){
		return dongService.getDongInfo(dong);
	}
}
