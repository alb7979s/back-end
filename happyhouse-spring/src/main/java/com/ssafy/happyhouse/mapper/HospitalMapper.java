package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;


public interface HospitalMapper {
	public List<Hospital> hospitalList() throws SQLException;

	public List<Hospital> listHospitalPage(Page page);

	public int selectHospitalCount();

	public int searchHospitalCount(Map<String, Object> params);

	public List<Hospital> searchHospitalPage(Map<String, Object> params);
}
