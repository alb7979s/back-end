package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Page;

public interface CommunityService {
	public void writeCommunity(Community community) throws SQLException;
	public List<Community> search(Map<String,String> param) throws SQLException;
	public List<Community> listCommunityAll() throws SQLException;
	public Community getCommunity(int no) throws SQLException;
	public void modifyCommunity(Community community) throws SQLException;
	public void deleteCommunity(int no) throws SQLException;
	Map<String,Object> listCommunityPage(Page page) throws SQLException;
	public List<Community> selectList();
	public Map<String, Object> searchCommunityPage(Page page, String key, String word);
}
