package com.happyhouse.model.service;

import com.happyhouse.model.MemberDto;
import com.happyhouse.model.dao.LoginDao;
import com.happyhouse.model.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	private static LoginService loginService;
	private LoginServiceImpl() {};
	public static LoginService getloginService() {
		if(loginService == null) loginService = new LoginServiceImpl();
		return loginService;
	}
	
	LoginDao loginDao = LoginDaoImpl.getLoginDao();
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getId() == null || memberDto.getPwd() == null) return null;
		return loginDao.login(memberDto);
	}
}