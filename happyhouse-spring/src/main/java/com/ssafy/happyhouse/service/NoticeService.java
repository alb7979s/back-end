package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.dto.Page;

public interface NoticeService {
	public void writeNotice(Notice notice) throws SQLException;
	public List<Notice> search(Map<String,String> param) throws SQLException;
	public List<Notice> listNoticeAll() throws SQLException;
	public Notice getNotice(int noticeno) throws SQLException;
	public void modifyNotice(Notice notice) throws SQLException;
	public void deleteNotice(int noticeno) throws SQLException;
	Map<String,Object> listNoticePage(Page page) throws SQLException;
}
