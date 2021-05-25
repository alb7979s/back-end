package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Page;

public interface CommunityMapper {
	void writeCommunity(Community community) throws SQLException;
	List<Community> search(Map<String,Object> param) throws SQLException;
	List<Community> listCommunityAll() throws SQLException;
	List<Community> listCommunityPage(Page page) throws SQLException;
	int selectCommunityCount() throws SQLException;
	Community getCommunity(int no) throws SQLException;
	void modifyCommunity(Community community) throws SQLException;
	void deleteCommunity(int no) throws SQLException;
	List<Community> selectCommunity();
	void countUpCommunity(int no);
	int searchCommunityCount(Map<String, Object> params);
	List<Hospital> searchCommunityPage(Map<String, Object> params);
	int getMaxNo();
}
