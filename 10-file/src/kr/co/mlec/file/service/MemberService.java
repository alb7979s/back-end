package kr.co.mlec.file.service;

import kr.co.mlec.file.dto.MemberDto;

public interface MemberService {
	void join(MemberDto member) throws Exception;
}
