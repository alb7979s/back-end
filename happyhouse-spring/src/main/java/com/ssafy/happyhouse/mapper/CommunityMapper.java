package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Page;

public interface CommunityMapper {
	public void writeCommunity(Community community) throws SQLException;
	public List<Community> search(Map<String,Object> param) throws SQLException;
	public List<Community> listCommunityAll() throws SQLException;
	public List<Community> listCommunityPage(Page page) throws SQLException;
	public int selectCommunityCount() throws SQLException;
	public Community getCommunity(int no) throws SQLException;
	public void modifyCommunity(Community community) throws SQLException;
	public void deleteCommunity(int no) throws SQLException;
	public List<Community> selectCommunity();
	public void countUpCommunity(int no);
	public int searchCommunityCount(Map<String, Object> params);
	public List<Hospital> searchCommunityPage(Map<String, Object> params);
}
