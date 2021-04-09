package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.ClinicDto;
import com.happyhouse.util.DBUtil;

public class ClinicDaoImpl implements ClinicDao {

	@Override
	public List<ClinicDto> clinicList() throws SQLException {
		List<ClinicDto> list = new ArrayList<ClinicDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from happyhouse.selection_clinic");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ClinicDto clinicDto = new ClinicDto();
				clinicDto.setNo(rs.getInt("no"));
				clinicDto.setBase_date(rs.getString("base_date"));
				clinicDto.setSample_collection_yn(rs.getString("sample_collection_yn"));
				clinicDto.setSido(rs.getString("sido"));
				clinicDto.setSigungu(rs.getString("sigungu"));
				clinicDto.setMedi_name(rs.getString("medi_name"));
				clinicDto.setAddress(rs.getString("address"));
				clinicDto.setWeekday_oper_time(rs.getString("weekday_oper_time"));
				clinicDto.setSaturday_oper_time(rs.getString("saturday_oper_time"));
				clinicDto.setHoliday_oper_time(rs.getString("holiday_oper_time"));
				clinicDto.setPhone_no(rs.getString("phone_no"));
				list.add(clinicDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		System.out.println(list.size());
		return list;
	}

}
