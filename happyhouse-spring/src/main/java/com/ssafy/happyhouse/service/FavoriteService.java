package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Member;


public interface FavoriteService {
	List<Apt> favoriteAreaSearch(Member member) throws Exception;

	void favoriteSet(Member member, String dong) throws Exception;
	
	// return type <Apt>로 하면 깔끔하긴한데 뭔가 동 정보만 필요한데 굳이 Apt로 받아야하나? 사이즈 커지면 부하 올거같은데
	List<String> getDongList() throws Exception;

	List<Apt> favoriteAreasSearch(Member member);
}
