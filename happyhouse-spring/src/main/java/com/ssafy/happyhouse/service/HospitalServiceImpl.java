package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.HospitalMapper;
import com.ssafy.happyhouse.mapper.HospitalMapper;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalMapper hospitalMapper;
	
//	public HospitalServiceImpl() {
//		hospitalDao = new HospitalDaoImpl();
//	}
	
	@Override
	public List<Hospital> hospitalList() throws Exception {
		return hospitalMapper.hospitalList();
	}

	@Override
	public Map<String, Object> listhospitalPage(Page page) {
		List<Hospital> list = hospitalMapper.listHospitalPage(page);
		int count = hospitalMapper.selectHospitalCount();
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("hospital", list);
		result.put("pageResult", prd);
		
		return result;
	}

}
