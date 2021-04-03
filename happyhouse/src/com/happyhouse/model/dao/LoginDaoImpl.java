package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.happyhouse.model.MemberDto;
import com.happyhouse.util.DBUtil;

public class LoginDaoImpl implements LoginDao {
	
	private static LoginDao loginDao;
	private LoginDaoImpl() {};
	public static LoginDao getLoginDao() {
		if(loginDao == null) loginDao = new LoginDaoImpl();
		return loginDao;
	}
	@Override
	public MemberDto login(MemberDto memberDto) throws SQLException {
		MemberDto paramDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, email \n");
			sql.append("from member \n");
			sql.append("where id = ? and pwd = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// login 성공시 id, email 저장해서 반환
				paramDto = new MemberDto();
				paramDto.setId(rs.getString("id"));
				paramDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			paramDto = null;
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return paramDto;
	}
}
