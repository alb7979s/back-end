package com.happyhouse.model.service;

import com.happyhouse.model.MemberDto;

public interface MemberService {
	public void join(MemberDto memberDto) throws Exception;
	public void withdraw(MemberDto memberDto) throws Exception;
	public void modify(MemberDto memberDto) throws Exception;
}
