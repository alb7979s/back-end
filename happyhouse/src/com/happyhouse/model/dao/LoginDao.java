package com.happyhouse.model.dao;

import java.sql.SQLException;

import com.happyhouse.model.MemberDto;

public interface LoginDao {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	
}
