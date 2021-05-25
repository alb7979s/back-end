package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Store;

public interface AptMapper {
	public List<Apt> aptSearch(Map<String, String> map) throws SQLException;


	public List<String> selectSidoCodeList();
	public List<String> selectSidoNameList();


	public List<String> selectGugunNameList(String code);


	public List<String> selectDongNameList(String code);


	public void saveFavoriteInfo(Map<String, String> map);


	public void clickUp(Map<String, String> map);


	public List<Apt> selectTop3(Map<String, String> param);


	public List<Apt> getGraphInfo(Map<String, String> param);


	public List<Apt> getDealInfo(Map<String, String> param);


	public List<Store> getStore();
}
