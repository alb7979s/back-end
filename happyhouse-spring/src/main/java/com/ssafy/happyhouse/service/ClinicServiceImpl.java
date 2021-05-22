package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.ClinicMapper;
import com.ssafy.happyhouse.mapper.ClinicMapper;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	private ClinicMapper clinicMapper;
	
//	public ClinicServiceImpl() {
//		clinicDao = new ClinicDaoImpl();
//	}
	
	@Override
	public List<Clinic> clinicList() throws Exception {
		return clinicMapper.clinicList();
	}

	@Override
	public Map<String, Object> listclinicPage(Page page) {
		List<Clinic> list = clinicMapper.listClinicPage(page);
		//페이지 개수
		int count = clinicMapper.selectClinicCount();
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("clinic", list);
		result.put("pageResult", prd);
		
		return result;
	}

	@Override
	public Map<String, Object> searchClinicPage(Page page, Map<String, Object> params) {
		

		int count = clinicMapper.searchClinicCount(params);

		params.put("begin", page.getBegin());
		params.put("listSize", page.getListSize());
	
		List<Hospital> list = clinicMapper.searchClinicPage(params);
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("clinic", list);
		result.put("pageResult", prd);
		
		return result;
	}

}
