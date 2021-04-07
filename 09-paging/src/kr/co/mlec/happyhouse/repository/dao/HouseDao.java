package kr.co.mlec.happyhouse.repository.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.mlec.happyhouse.repository.dto.HouseDto;
import kr.co.mlec.happyhouse.repository.dto.PageDto;

public interface HouseDao {
	// interface는 public 자동으로 붙으니 빼주는게 소스상으로 이쁘대
	List<HouseDto> selectHouse() throws SQLException;
	int selectHouseCount() throws SQLException;
	List<HouseDto> selectHouse(PageDto pageDto) throws SQLException;

}
