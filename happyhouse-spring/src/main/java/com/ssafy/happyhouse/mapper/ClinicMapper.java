package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;

public interface ClinicMapper {
	public List<Clinic> clinicList() throws SQLException;

	public List<Clinic> listClinicPage(Page page);

	public int selectClinicCount();

	public int searchClinicCount(Map<String, Object> params);

	public List<Hospital> searchClinicPage(Map<String, Object> params);
}
