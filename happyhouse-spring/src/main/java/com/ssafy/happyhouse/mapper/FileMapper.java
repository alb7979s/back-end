package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;

import com.ssafy.happyhouse.dto.MyFile;

public interface FileMapper {
	void insertFile(MyFile myFile) throws SQLException;
}
