package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.dao.AptDao;
import com.happyhouse.model.dao.AptDaoImpl;

public class AptServiceImpl implements AptService {
	private AptDao aptDao;
	
	public AptServiceImpl() {
		aptDao = new AptDaoImpl();
	}
	
	@Override
	public List<AptDto> aptSearch(String key, String word) throws Exception {
		return aptDao.aptSearch(key, word);
	}

}
