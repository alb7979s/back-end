package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.HospitalDto;
import com.happyhouse.model.dao.HospitalDao;
import com.happyhouse.model.dao.HospitalDaoImpl;

public class HospitalServiceImpl implements HostpitalService {
	private HospitalDao hospitalDao;
	
	public HospitalServiceImpl() {
		hospitalDao = new HospitalDaoImpl();
	}
	
	@Override
	public List<HospitalDto> hospitalList() throws Exception {
		return hospitalDao.hospitalList();
	}

}
