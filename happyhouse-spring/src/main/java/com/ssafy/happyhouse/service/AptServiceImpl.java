package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.mapper.AptMapper;



@Service
public class AptServiceImpl implements AptService {
	
	@Autowired
	private AptMapper aptMapper;
	
//	public AptServiceImpl() {
//		aptDao = new AptDaoImpl();
//	}
	
	@Override
	public List<Apt> aptSearch(String key, String word) throws Exception {
		System.out.println("service "+key+ " "+word);
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		return aptMapper.aptSearch(map);
//		return null;
	}

}
