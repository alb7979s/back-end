package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Apt;

public interface AptMapper {
	public List<Apt> aptSearch(Map<String, String> map) throws SQLException;
}
