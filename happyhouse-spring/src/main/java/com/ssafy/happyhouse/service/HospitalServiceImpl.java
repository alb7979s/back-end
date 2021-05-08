package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.mapper.HospitalMapper;
import com.ssafy.happyhouse.mapper.HospitalMapper;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalMapper hospitalDao;
	
//	public HospitalServiceImpl() {
//		hospitalDao = new HospitalDaoImpl();
//	}
	
	@Override
	public List<Hospital> hospitalList() throws Exception {
		return hospitalDao.hospitalList();
	}

}
