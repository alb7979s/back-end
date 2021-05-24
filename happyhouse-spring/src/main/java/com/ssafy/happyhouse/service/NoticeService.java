package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.dto.Page;

public interface NoticeService {
	void writeNotice(Notice notice) throws SQLException;
	List<Notice> search(Map<String,String> param) throws SQLException;
	List<Notice> listNoticeAll() throws SQLException;
	Notice getNotice(int noticeno) throws SQLException;
	void modifyNotice(Notice notice) throws SQLException;
	void deleteNotice(int noticeno) throws SQLException;
	Map<String,Object> listNoticePage(Page page) throws SQLException;
	List<Notice> selectList();
	Map<String, Object> searchNoticePage(Page page, String key, String word);
}
