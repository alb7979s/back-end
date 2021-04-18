package kr.co.mlec.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.mlec.file.dto.MemberDto;
import kr.co.mlec.file.dto.MemberFileDto;
import kr.co.mlec.file.dto.MemberLangDto;
import kr.co.mlec.file.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	@Override
	public void insertMember(MemberDto member) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member (id, name, password, profileName, profilePath) ");
		sql.append("values (?, ?, ?, ?, ?)");
		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			int index = 1;
			pstmt.setString(index++, member.getId());
			pstmt.setString(index++, member.getName());
			pstmt.setString(index++, member.getPassword());
			pstmt.setString(index++, member.getProfileName());
			pstmt.setString(index++, member.getProfilePath());
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public void insertMemberLang(MemberLangDto memberLang) throws SQLException {
		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into member_lang (id, lang) values(?, ?)");
				) {
			int index = 1;
			pstmt.setString(index++, memberLang.getId());
			pstmt.setString(index++, memberLang.getLang());
			pstmt.executeUpdate();
		}
	}
	
	@Override
	public void insertMemberFile(MemberFileDto memberFile) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member_file ( ");
		sql.append("	id, path, orgName, systemName, contentType, size ");
		sql.append(") values ( ");
		sql.append("	?, ?, ?, ?, ?, ? ");
		sql.append(") ");
		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			int index = 1;
			pstmt.setString(index++, memberFile.getId());
			pstmt.setString(index++, memberFile.getPath());
			pstmt.setString(index++, memberFile.getOrgName());
			pstmt.setString(index++, memberFile.getSystemName());
			pstmt.setString(index++, memberFile.getContentType());
			pstmt.setLong(index++, memberFile.getSize());
			pstmt.executeUpdate();
		}
	}
}
