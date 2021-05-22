package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Member;

public interface MemberMapper {
	void insertMember(Member member) throws SQLException;
	void deleteMember(Member member) throws SQLException;
	Member selectMember(Member member) throws SQLException;
	void updateMember(Member member) throws SQLException;
	Member loginMember(Member member) throws SQLException;
	List<String> getIdList() throws Exception;
	List<String> getEmailList() throws Exception;
	Member getMemberFromEmail(Member member) throws Exception;
}

