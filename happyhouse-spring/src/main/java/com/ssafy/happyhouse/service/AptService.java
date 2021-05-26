package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Store;

public interface AptService {
	List<Apt> aptSearch(String key, String word) throws Exception;

	List<String> selectSidoCodeList();
	List<String> selectSidoNameList();

	List<String> getGugunNameList(String code);

	List<String> getDongNameList(String code);

	void saveFavoriteInfo(Map<String, String> map);

	void clickUp(Map<String, String> param);

	List<Apt> selectTop3(Map<String, String> param);

	List<Apt> graphInfo(Map<String, String> param);

	List<Apt> getDealInfo(Map<String, String> param);

	List<Store> getStore();

	int getDealCnt(Map<String, String> param);

	int getCmpDealCnt(Map<String, String> param);

	List<Apt> getDealAmount(Map<String, String> param);

	List<Apt> getCmpDealAmount(Map<String, String> param);

	String getMaxDealAmount(Map<String, String> param);

	String getMaxCmpDealAmount(Map<String, String> param);

	String getMinDealAmount(Map<String, String> param);

	String getMinCmpDealAmount(Map<String, String> param);

}
