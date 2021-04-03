package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.happyhouse.model.MemberDto;
import com.happyhouse.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao;
	private MemberDaoImpl() {};
	public static MemberDao getMemberDao() {
		if(memberDao == null) memberDao = new MemberDaoImpl();
		return memberDao;
	}
	@Override
	public void insertMember(MemberDto memberDto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member (id, pwd, dpt, email) \n");
		sql.append("values (?, ?, ?, ?)");
		DBUtil.update(sql.toString(), memberDto.getId(), memberDto.getPwd(), memberDto.getDpt(), memberDto.getEmail());
	}
	@Override
	public void deleteMember(MemberDto memberDto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from member where id = ?");
		DBUtil.update(sql.toString(), memberDto.getId());		
	}
	
	@Override
	public void modifyMember(MemberDto memberDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 가져온 값으로 수정 
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, pwd, dpt, email \n");
			sql.append("from member \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				// null인것만 전에 저장된 내용 사용, null 아니면 새로운거 사용
				if(memberDto.getPwd() == "") memberDto.setPwd(rs.getString("pwd"));
				if(memberDto.getDpt() == "") memberDto.setDpt(rs.getString("dpt"));
				if(memberDto.getEmail() == "") memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberDto = null;
		} finally {
			// 수정하면서 연 커넥션 닫고
			DBUtil.close(rs, pstmt, conn);
			// 갱신되 값으로 update
			StringBuilder sql = new StringBuilder();
			sql = new StringBuilder();
			sql.append("update member ");
			sql.append("	set pwd = ?, dpt = ?, email = ?");
			sql.append(" where id = ? ");
			DBUtil.update(sql.toString(), memberDto.getPwd(), memberDto.getDpt(), memberDto.getEmail(), memberDto.getId());
		}
	}
}