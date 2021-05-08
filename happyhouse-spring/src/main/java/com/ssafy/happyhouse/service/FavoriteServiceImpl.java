package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.mapper.FavoriteMapper;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	private FavoriteMapper favoriteDao;
//	
//	public static FavoriteService favoriteService;
	
//	private FavoriteServiceImpl() {};
//	public static FavoriteService getFavoriteService() {
//		if(favoriteService == null) favoriteService = new FavoriteServiceImpl();
//		return favoriteService;
//	}
	
//	private FavoriteDao favoriteDao = FavoriteDaoImpl.getFavoriteDao();
	
	
//	@Override
//	public List<Apt> favoriteAreaSearch(Member memberDto) throws Exception {
//		return favoriteDao.getAreas(memberDto);
//	}
//	@Override
//	public void favoriteSet(Member member, String dong) throws Exception{
//		
//		Favorite result = favoriteDao.setArea(favoriteDao.getDong(member));
//		if(result!=null) {
//			//존재하면 update
//			favoriteDao.updateArea(favorite);
//		}
//		else {
//			//존재하지 않으면 insert
//			favoriteDao.insertArea(favorite);
//		}
//	}

	@Override
	public List<Apt> favoriteAreaSearch(Member member) throws Exception {
		System.out.println(favoriteDao.getDong(member));
		return favoriteDao.getAreas(favoriteDao.getDong(member));
//		return null;
	}

	@Override
	public void favoriteSet(Member member, String dong) throws Exception {
		Favorite result = favoriteDao.setArea(member);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", member.getId());
		map.put("dong", dong);
		
		if(result!=null) {
			//존재하면 update
			favoriteDao.updateArea(map);
		}
		else {
			//존재하지 않으면 insert
			favoriteDao.insertArea(map);
		}
		
	}
	
	
}
