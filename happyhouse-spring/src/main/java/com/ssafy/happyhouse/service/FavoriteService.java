package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.dto.Member;


public interface FavoriteService {
	List<Apt> favoriteAreaSearch(Member member) throws Exception;

	void favoriteSet(Member member, String dong) throws Exception;
}
