package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Hospital;
import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.dto.Page;

public interface NoticeMapper {
	public void writeNotice(Notice notice) throws SQLException;
	public List<Notice> search(Map<String,Object> param) throws SQLException;
	public List<Notice> listNoticeAll() throws SQLException;
	public List<Notice> listNoticePage(Page page) throws SQLException;
	public int selectNoticeCount() throws SQLException;
	public Notice getNotice(int noticeno) throws SQLException;
	public void modifyNotice(Notice notice) throws SQLException;
	public void deleteNotice(int noticeno) throws SQLException;
	public List<Notice> selectNotice();
	public void countUpNotice(int noticeno);
	public int searchNoticeCount(Map<String, Object> params);
	public List<Hospital> searchNoticePage(Map<String, Object> params);
}
