package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Population;
import com.ssafy.happyhouse.mapper.PopulationMapper;

@Service
public class PopulationServiceImpl implements PopulationService{

	@Autowired
	private PopulationMapper populationMapper;
	
	public Population getPopulationInfo(String dong) {
		return populationMapper.getPopulationInfo(dong);
	}

}
