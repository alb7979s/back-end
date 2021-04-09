package com.happyhouse.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.happyhouse.model.NoticeDto;
import com.happyhouse.model.PageDto;
import com.happyhouse.model.PageResultDto;
import com.happyhouse.model.dao.NoticeDao;
import com.happyhouse.model.dao.NoticeDaoImpl;

public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao;
	
	
	public NoticeServiceImpl() {
		noticeDao = new NoticeDaoImpl();
	}

	@Override
	public List<NoticeDto> listNotice(String type, String word) throws SQLException {
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 아직 구현 안함
		 * 
		 * 
		 * 
		 * */
		return null;
	}

	@Override
	public List<NoticeDto> listNotice() throws SQLException {
		
		return noticeDao.listNotice();
	}

	@Override
	public NoticeDto getNotice(int noticeno) throws SQLException {
		return noticeDao.getNotice(noticeno);
	}

	@Override
	public void modifyNotice(NoticeDto noticeDto) throws SQLException {
		noticeDao.modifyNotice(noticeDto);
		
	}

	@Override
	public void deleteNotice(int noticeno) throws SQLException {
		noticeDao.deleteNotice(noticeno);
		
	}

	@Override
	public void writeNotice(NoticeDto noticeDto) throws SQLException {
		noticeDao.writeNotice(noticeDto);
		
	}

	@Override
	public Map<String, Object> listNotice(PageDto pageDto) throws SQLException {
		//게시물 목록
		List<NoticeDto> list = noticeDao.listNotice(pageDto);
		//페이징을 위해서 게시물 전체 갯수
		System.out.println(list);
		int count = noticeDao.selectNoticeCount();
		
		PageResultDto prd = new PageResultDto(pageDto.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list",list);
		result.put("pageResult", prd);
		
		return result;
	}

}
