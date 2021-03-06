package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Store;
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

	@Override
	public void clickUp(Map<String, String> map) {
		aptMapper.clickUp(map);
	}

	@Override
	public List<Apt> selectTop3(Map<String, String> param) {
		return aptMapper.selectTop3(param);
	}

	@Override
	public List<Apt> graphInfo(Map<String, String> param) {
		return aptMapper.getGraphInfo(param);
	}

	@Override
	public List<Apt> getDealInfo(Map<String, String> param) {
		return aptMapper.getDealInfo(param);
	}

	@Override
	public List<Store> getStore() {
		return aptMapper.getStore();
	}

	@Override
	public int getDealCnt(Map<String, String> param) {
		return aptMapper.getDealCnt(param);
	}

	@Override
	public int getCmpDealCnt(Map<String, String> param) {
		// TODO Auto-generated method stub
		return aptMapper.getCmpDealCnt(param);
	}

	@Override
	public List<Apt> getDealAmount(Map<String, String> param) {
		// TODO Auto-generated method stub
		return aptMapper.getDealAmount(param);
	}

	@Override
	public List<Apt> getCmpDealAmount(Map<String, String> param) {
		// TODO Auto-generated method stub
		return aptMapper.getCmpDealAmount(param);
	}

	@Override
	public String getMaxDealAmount(Map<String, String> param) {
		return makeFormat(aptMapper.getMaxDealAmount(param));
	}

	@Override
	public String getMaxCmpDealAmount(Map<String, String> param) {
		// TODO Auto-generated method stub
		return makeFormat(aptMapper.getMaxCmpDealAmount(param));
	}

	@Override
	public String getMinDealAmount(Map<String, String> param) {
		// TODO Auto-generated method stub
		return makeFormat(aptMapper.getMinDealAmount(param));
	}

	@Override
	public String getMinCmpDealAmount(Map<String, String> param) {
		// TODO Auto-generated method stub
		return makeFormat(aptMapper.getMinCmpDealAmount(param));
	}

	public String makeFormat(String s) {
		String price = s.trim();
		price = price.replace(",", "");
		return price;
	}
}
