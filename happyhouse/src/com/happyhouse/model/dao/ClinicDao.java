package com.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.ClinicDto;
import com.happyhouse.model.HospitalDto;

public interface ClinicDao {
	public List<ClinicDto> clinicList() throws SQLException;
}
