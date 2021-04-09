package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.FavoriteDto;
import com.happyhouse.model.MemberDto;
import com.happyhouse.model.dao.FavoriteDao;
import com.happyhouse.model.dao.FavoriteDaoImpl;

public class FavoriteServiceImpl implements FavoriteService {
	
	public static FavoriteService favoriteService;
	private FavoriteServiceImpl() {};
	public static FavoriteService getFavoriteService() {
		if(favoriteService == null) favoriteService = new FavoriteServiceImpl();
		return favoriteService;
	}
	
	private FavoriteDao favoriteDao = FavoriteDaoImpl.getFavoriteDao();
	@Override
	public List<AptDto> favoriteAreaSearch(MemberDto memberDto) throws Exception {
		return favoriteDao.getAreas(memberDto);
	}
	@Override
	public void favoriteSet(FavoriteDto favoriteDto) throws Exception{
		favoriteDao.setArea(favoriteDto);
	}
	
}
