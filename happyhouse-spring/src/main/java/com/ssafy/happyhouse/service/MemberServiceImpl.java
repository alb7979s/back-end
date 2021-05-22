package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	@Transactional
	public void join(Member member) throws Exception {
		memberMapper.insertMember(member);
	}
	
	@Override
	@Transactional
	public void withdraw(Member member) throws Exception {
		memberMapper.deleteMember(member);
	}
	
	@Override
	@Transactional
	public void modify(Member member) throws Exception {
		Member memberInfo = memberMapper.selectMember(member);
		if (memberInfo != null) {
			memberMapper.updateMember(member);
		}
	}
	
	@Override
	@Transactional
	public Member login(Member memberDto) throws Exception {
		if(memberDto.getId() == null || memberDto.getPwd() == null) return null;
		return memberMapper.loginMember(memberDto);
	}

//	public List<Apt> favoriteAreaSearch(Member member) throws Exception {
//		return favoriteMapper.getAreas(favoriteMapper.getDong(member));
//	}

	@Override
	public List<String> getIdList() throws Exception {
		return memberMapper.getIdList();
	}

	@Override
	public List<String> getEmailList() throws Exception {
		return memberMapper.getEmailList();
	}

	@Override
	public Member getMemberFromEmail(Member member) throws Exception {
		return memberMapper.getMemberFromEmail(member);
	}
	
	@Override
	public Member getMemberFromId(Member member) throws Exception {
		return memberMapper.selectMember(member);
	}
}
