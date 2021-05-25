package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityMapper communityMapper;
	
	@Override
	@Transactional
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
		return communityMapper.search(newParam);
	}

	@Override
	@Transactional
	public List<Community> listCommunityAll() throws SQLException {
		return communityMapper.listCommunityAll();
	}

	@Override
	@Transactional
	public Community getCommunity(int no) throws SQLException {
		communityMapper.countUpCommunity(no);
		return communityMapper.getCommunity(no);
	}

	@Override
	@Transactional
	public void modifyCommunity(Community community) throws SQLException {
		communityMapper.modifyCommunity(community);
		
	}

	@Override
	@Transactional
	public void deleteCommunity(int no) throws SQLException {
		communityMapper.deleteCommunity(no);
		
	}

	@Override
	@Transactional
	public int writeCommunity(Community community) throws SQLException {
		communityMapper.writeCommunity(community);
		return communityMapper.getMaxNo();	// 자동증가 no값의 추가된 현재 번호 = max(no)
	}

	@Override
	@Transactional
	public Map<String, Object> listCommunityPage(Page page) throws SQLException {
		//게시물 목록
		List<Community> list = communityMapper.listCommunityPage(page);
		//페이징을 위해서 게시물 전체 갯수
		
		int count = communityMapper.selectCommunityCount();
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("communities",list);
		result.put("pageResult", prd);
		
		return result;
	}

	@Override
	@Transactional
	public List<Community> selectList() {
		
		return communityMapper.selectCommunity();
	}

	@Override
	@Transactional
	public Map<String, Object> searchCommunityPage(Page page, String key, String word) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", key);
		params.put("word", word);

		int count = communityMapper.searchCommunityCount(params);
		
		params.put("begin", page.getBegin());
		params.put("listSize", page.getListSize());
	
		List<Hospital> list = communityMapper.searchCommunityPage(params);
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("communities", list);
		result.put("pageResult", prd);
		
		return result;
	}

}
