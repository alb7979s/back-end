package com.ssafy.happyhouse.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.dto.Member;

public interface FavoriteMapper {
	List<String> getDongList() throws Exception;
	Favorite getDong(Member member) throws Exception;
	List<Apt> getAreas(Favorite favorite) throws Exception;
	Favorite setArea(Member member) throws Exception;
	void updateArea(HashMap<String, Object> map)  throws Exception;
	void insertArea(HashMap<String, Object> map)  throws Exception;
	List<Apt> favoriteAreasSearch(Member member);
}
