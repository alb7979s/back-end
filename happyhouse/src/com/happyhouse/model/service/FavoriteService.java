package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.FavoriteDto;
import com.happyhouse.model.MemberDto;

public interface FavoriteService {
	List<AptDto> favoriteAreaSearch(MemberDto memberDto) throws Exception;

	void favoriteSet(FavoriteDto favoriteDto) throws Exception;
}
