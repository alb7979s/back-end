package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Store;

public interface AptService {
	public List<Apt> aptSearch(String key, String word) throws Exception;

	public List<String> selectSidoCodeList();
	public List<String> selectSidoNameList();

	public List<String> getGugunNameList(String code);

	public List<String> getDongNameList(String code);

	public void saveFavoriteInfo(Map<String, String> map);

	public void clickUp(Map<String, String> param);

	public List<Apt> selectTop3(Map<String, String> param);

	public List<Apt> graphInfo(Map<String, String> param);

	public List<Apt> getDealInfo(Map<String, String> param);

	public List<Store> getStore();
}
