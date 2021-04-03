package com.happyhouse.model.service;

import com.happyhouse.model.MemberDto;
import com.happyhouse.model.dao.MemberDao;
import com.happyhouse.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	private static MemberService memberService;
	private MemberServiceImpl() {};
	public static MemberService getMemberService() {
		if(memberService == null) memberService = new MemberServiceImpl();
		return memberService;
	}
	
	private MemberDao memberDao = MemberDaoImpl.getMemberDao();
	@Override
	public void join(MemberDto memberDto) throws Exception {
		memberDao.insertMember(memberDto);
	}
	@Override
	public void withdraw(MemberDto memberDto) throws Exception {
		memberDao.deleteMember(memberDto);
	}
	@Override
	public void modify(MemberDto memberDto) throws Exception {
		memberDao.modifyMember(memberDto);
	}
	
}
