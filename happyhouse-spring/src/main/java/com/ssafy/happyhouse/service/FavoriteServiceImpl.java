package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.mapper.FavoriteMapper;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	private FavoriteMapper favoriteMapper;

	@Transactional
	@Override
	public List<Apt> favoriteAreaSearch(Member member) throws Exception {
		return favoriteMapper.getAreas(favoriteMapper.getDong(member));
	}

	@Transactional
	@Override
	public void favoriteSet(Member member, String dong) throws Exception {
		Favorite result = favoriteMapper.setArea(member);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", member.getId());
		map.put("dong", dong);
		
		if(result!=null) {
			//존재하면 update
			favoriteMapper.updateArea(map);
		}
		else {
			//존재하지 않으면 insert
			favoriteMapper.insertArea(map);
		}
		
	}

	@Override
	public List<String> getDongList() throws Exception {
		return favoriteMapper.getDongList();
	}

	@Override
	public List<Apt> favoriteAreasSearch(Member member) {
		return favoriteMapper.favoriteAreasSearch(member);
	}
	
	
}
