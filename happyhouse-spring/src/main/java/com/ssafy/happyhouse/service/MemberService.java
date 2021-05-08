package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.Member;

public interface MemberService {
	void join(Member member) throws Exception;
	void withdraw(Member member) throws Exception;
	void modify(Member member) throws Exception;
	Member login(Member memberDto) throws Exception;
}
