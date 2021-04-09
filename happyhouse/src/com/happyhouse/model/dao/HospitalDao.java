package com.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.HospitalDto;

public interface HospitalDao {
	public List<HospitalDto> hospitalList() throws SQLException;
}
