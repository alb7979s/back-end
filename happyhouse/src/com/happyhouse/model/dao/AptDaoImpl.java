package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.AptDto;
import com.happyhouse.util.DBUtil;

public class AptDaoImpl implements AptDao {

	@Override
	public List<AptDto> aptSearch(String key, String word) throws SQLException {

		List<AptDto> list = new ArrayList<AptDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun \n");
			sql.append("from happyhouse.housedeal \n");
			sql.append("where " + key + " = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AptDto aptDto = new AptDto();
				aptDto.setNo(rs.getInt("no"));
				aptDto.setDong(rs.getString("dong"));
				aptDto.setAptName(rs.getString("AptName"));
				aptDto.setCode(rs.getString("code"));
				aptDto.setDealAmount(rs.getString("dealAmount"));
				aptDto.setBuildYear(rs.getString("buildYear"));
				aptDto.setDealYear(rs.getString("dealYear"));
				aptDto.setDealMonth(rs.getString("dealMonth"));
				aptDto.setDealDay(rs.getString("dealDay"));
				aptDto.setArea(rs.getString("area"));
				aptDto.setFloor(rs.getString("floor"));
				aptDto.setJibun(rs.getString("jibun"));
				list.add(aptDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

}
