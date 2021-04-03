package com.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.AptDto;

public interface AptDao {
	public List<AptDto> aptSearch(String key, String word) throws SQLException;
}
