package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.HospitalDto;
import com.happyhouse.util.DBUtil;

public class HospitalDaoImpl implements HospitalDao {

	@Override
	public List<HospitalDto> hospitalList() throws SQLException {
		List<HospitalDto> list = new ArrayList<HospitalDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, base_date, sido, sigungu, medi_name, address, type, phone_no \n");
			sql.append("from happyhouse.hospital");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HospitalDto hospitalDto = new HospitalDto();
				hospitalDto.setNo(rs.getInt("no"));
				hospitalDto.setBase_date(rs.getString("base_date"));
				hospitalDto.setSido(rs.getString("sido"));
				hospitalDto.setSigungu(rs.getString("sigungu"));
				hospitalDto.setMedi_name(rs.getString("medi_name"));
				hospitalDto.setAddress(rs.getString("address"));
				hospitalDto.setType(rs.getString("type"));
				hospitalDto.setPhone_no(rs.getString("phone_no"));
				list.add(hospitalDto);
			}
		}
		finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

}
