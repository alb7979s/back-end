package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Page;

public interface CommunityService {
	int writeCommunity(Community community) throws SQLException;
	List<Community> search(Map<String,String> param) throws SQLException;
	List<Community> listCommunityAll() throws SQLException;
	Community getCommunity(int no) throws SQLException;
	void modifyCommunity(Community community) throws SQLException;
	void deleteCommunity(int no) throws SQLException;
	Map<String,Object> listCommunityPage(Page page) throws SQLException;
	List<Community> selectList();
	Map<String, Object> searchCommunityPage(Page page, String key, String word);
}
