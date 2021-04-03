package com.happyhouse.model.dao;

import java.sql.SQLException;

import com.happyhouse.model.MemberDto;

public interface MemberDao {
	public void insertMember(MemberDto memberDto) throws SQLException;

	public void deleteMember(MemberDto memberDto) throws SQLException;

	public void modifyMember(MemberDto memberDto)throws SQLException;
}

