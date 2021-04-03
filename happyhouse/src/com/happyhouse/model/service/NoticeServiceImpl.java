package com.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.NoticeDto;
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

}
