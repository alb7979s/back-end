package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityMapper CommunityMapper;
	
	@Override
	public List<Community> search(Map<String,String> param) throws SQLException {
		if(param.get("pageNo")== null) {
			param.put("pageNo", "1");
		}
		param.put("listSize" , "10");
		HashMap<String,Object> newParam = new HashMap<String,Object>();
		newParam.put("type", param.get("type"));
		newParam.put("word", param.get("word"));
		String pageNo = param.get("pageNo");
		if(pageNo == null) newParam.put("page",new Page(1));
		else newParam.put("page",new Page(Integer.parseInt(pageNo)));
		System.out.println(newParam.get("page"));
		return CommunityMapper.search(newParam);
	}

	@Override
	public List<Community> listCommunityAll() throws SQLException {
		return CommunityMapper.listCommunityAll();
	}

	@Override
	public Community getCommunity(int no) throws SQLException {
		CommunityMapper.countUpCommunity(no);
		return CommunityMapper.getCommunity(no);
	}

	@Override
	public void modifyCommunity(Community community) throws SQLException {
		CommunityMapper.modifyCommunity(community);
		
	}

	@Override
	public void deleteCommunity(int no) throws SQLException {
		CommunityMapper.deleteCommunity(no);
		
	}

	@Override
	public void writeCommunity(Community community) throws SQLException {
		CommunityMapper.writeCommunity(community);
		
	}

	@Override
	public Map<String, Object> listCommunityPage(Page page) throws SQLException {
		//게시물 목록
		List<Community> list = CommunityMapper.listCommunityPage(page);
		//페이징을 위해서 게시물 전체 갯수
		
		int count = CommunityMapper.selectCommunityCount();
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("communities",list);
		result.put("pageResult", prd);
		
		return result;
	}

	@Override
	public List<Community> selectList() {
		
		return CommunityMapper.selectCommunity();
	}

	@Override
	public Map<String, Object> searchCommunityPage(Page page, String key, String word) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("word", word);

		int count = CommunityMapper.searchCommunityCount(params);
		
		params.put("begin", page.getBegin());
		params.put("listSize", page.getListSize());
	
		List<Hospital> list = CommunityMapper.searchCommunityPage(params);
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("communities", list);
		result.put("pageResult", prd);
		
		return result;
	}

}
