package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Hospital;


public interface HospitalMapper {
	public List<Hospital> hospitalList() throws SQLException;
}
