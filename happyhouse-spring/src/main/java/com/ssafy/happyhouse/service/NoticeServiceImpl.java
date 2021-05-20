package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
//	private noticeMapper noticeMapper;
	
	@Autowired
	private NoticeMapper noticeMapper;
	
//	public NoticeServiceImpl() {
//		noticeMapper = new noticeMapperImpl();
//	}

	@Override
	public List<Notice> search(Map<String,String> param) throws SQLException {
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
		return noticeMapper.search(newParam);
	}

	@Override
	public List<Notice> listNoticeAll() throws SQLException {
		
		return noticeMapper.listNoticeAll();
	}

	@Override
	public Notice getNotice(int noticeno) throws SQLException {
		return noticeMapper.getNotice(noticeno);
	}

	@Override
	public void modifyNotice(Notice notice) throws SQLException {
		noticeMapper.modifyNotice(notice);
		
	}

	@Override
	public void deleteNotice(int noticeno) throws SQLException {
		noticeMapper.deleteNotice(noticeno);
		
	}

	@Override
	public void writeNotice(Notice notice) throws SQLException {
		noticeMapper.writeNotice(notice);
		
	}

	@Override
	public Map<String, Object> listNoticePage(Page page) throws SQLException {
		//게시물 목록
		List<Notice> list = noticeMapper.listNoticePage(page);
		//페이징을 위해서 게시물 전체 갯수
		System.out.println(list);
		int count = noticeMapper.selectNoticeCount();
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list",list);
		result.put("pageResult", prd);
		
		return result;
	}

	@Override
	public List<Notice> selectList() {
		
		return noticeMapper.selectNotice();
	}

}
