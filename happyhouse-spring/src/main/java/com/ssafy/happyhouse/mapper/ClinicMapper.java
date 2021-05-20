package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Clinic;
import com.ssafy.happyhouse.dto.Page;

public interface ClinicMapper {
	public List<Clinic> clinicList() throws SQLException;

	public List<Clinic> listClinicPage(Page page);

	public int selectClinicCount();
}
