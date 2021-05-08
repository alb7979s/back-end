package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Clinic;

public interface ClinicMapper {
	public List<Clinic> clinicList() throws SQLException;
}
