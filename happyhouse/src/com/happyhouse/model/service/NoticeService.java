package com.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.happyhouse.model.NoticeDto;
import com.happyhouse.model.PageDto;

public interface NoticeService {
	public void writeNotice(NoticeDto noticeDto) throws SQLException;
	public List<NoticeDto> listNotice(String type, String word) throws SQLException;
	public List<NoticeDto> listNotice() throws SQLException;
	public NoticeDto getNotice(int noticeno) throws SQLException;
	public void modifyNotice(NoticeDto noticeDto) throws SQLException;
	public void deleteNotice(int noticeno) throws SQLException;
	Map<String,Object> listNotice(PageDto pageDto) throws SQLException;
}
