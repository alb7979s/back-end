package com.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.FavoriteDto;
import com.happyhouse.model.MemberDto;

public interface FavoriteDao {
	FavoriteDto getDong(MemberDto memberDto) throws Exception;
	List<AptDto> getAreas(MemberDto memberDto) throws Exception;
	void setArea(FavoriteDto favoriteDto) throws Exception;
}
