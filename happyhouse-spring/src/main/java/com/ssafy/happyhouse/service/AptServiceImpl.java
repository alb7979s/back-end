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
		//System.out.println("service "+key+ " "+word);
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		return aptMapper.aptSearch(map);
//		return null;
	}

	@Override
	public List<String> selectSidoCodeList() {
		return aptMapper.selectSidoCodeList();
	}
	@Override
	public List<String> selectSidoNameList() {
		return aptMapper.selectSidoNameList();
	}

	@Override
	public List<String> getGugunNameList(String code) {
		return aptMapper.selectGugunNameList(code);
	}

	@Override
	public List<String> getDongNameList(String code) {
		return aptMapper.selectDongNameList(code);
	}

	@Override
	public void saveFavoriteInfo(Map<String, String> map) {
		aptMapper.saveFavoriteInfo(map);
		
	}

}
