package com.happyhouse.model.service;

import com.happyhouse.model.MemberDto;

public interface LoginService {
	public MemberDto login(MemberDto memberDto) throws Exception;
}
