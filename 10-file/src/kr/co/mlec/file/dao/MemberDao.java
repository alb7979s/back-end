package kr.co.mlec.file.dao;

import java.sql.SQLException;

import kr.co.mlec.file.dto.MemberDto;
import kr.co.mlec.file.dto.MemberFileDto;
import kr.co.mlec.file.dto.MemberLangDto;

public interface MemberDao {
	void insertMember(MemberDto memberDto) throws SQLException;
	void insertMemberLang(MemberLangDto memberLangDto) throws SQLException;
	void insertMemberFile(MemberFileDto memberFileDto) throws SQLException;
}
