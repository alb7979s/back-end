package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.mapper.ClinicMapper;
import com.ssafy.happyhouse.mapper.ClinicMapper;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	private ClinicMapper clinicDao;
	
//	public ClinicServiceImpl() {
//		clinicDao = new ClinicDaoImpl();
//	}
	
	@Override
	public List<Clinic> clinicList() throws Exception {
		return clinicDao.clinicList();
	}

}
