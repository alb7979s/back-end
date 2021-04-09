package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.ClinicDto;
import com.happyhouse.model.dao.ClinicDao;
import com.happyhouse.model.dao.ClinicDaoImpl;

public class ClinicServiceImpl implements ClinicService {
	private ClinicDao clinicDao;
	
	public ClinicServiceImpl() {
		clinicDao = new ClinicDaoImpl();
	}
	
	@Override
	public List<ClinicDto> clinicList() throws Exception {
		return clinicDao.clinicList();
	}

}
