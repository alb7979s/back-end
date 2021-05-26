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
import com.ssafy.happyhouse.dto.Population;
import com.ssafy.happyhouse.service.PopulationServiceImpl;

@Controller
public class PopulationController extends HttpServlet{
	
	@Autowired
	private PopulationServiceImpl populationService;
	
	@RequestMapping(value="/populationInfo", method=RequestMethod.POST)
	@ResponseBody
	public Population list(@RequestBody String dong){
		System.out.println("hihhi");
		dong = dong.substring(0, 2);
		dong+="동";
		System.out.println(dong);
		Population population = populationService.getPopulationInfo(dong);

		String pk= population.getKorean().replace(",","");
		String pf = population.getForeigner().replace(",", "");
		String total = population.getPopulation().replace(",", "");
		
		int pk1 = Integer.parseInt(pk);
		int pf1 = Integer.parseInt(pf);
		int total1 = Integer.parseInt(total);
		
		population.setPercentage_k(Math.round( ((double) pk1 / (double) total1  * 1000.0)*0.1));
		population.setPercentage_f(Math.round( ((double) pf1 / (double) total1 * 1000.0)*0.1));
		
		population.setFamily(population.getFamily().replace(",", ""));
		population.setPopulation(population.getPopulation().replace(",", ""));
		
		System.out.println(population.toString());
		
		return population;
	}
}
