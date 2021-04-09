package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.NoticeDto;
import com.happyhouse.model.PageDto;
import com.happyhouse.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao{

	@Override
	public List<NoticeDto> listNotice(String type, String word) throws SQLException {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select noticeno, userid, subject, content, regtime \n");
			sql.append("from notice \n");
			sql.append("order by noticeno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDto NoticeDto = new NoticeDto();
				NoticeDto.setNoticeno(rs.getInt("articleno"));
				NoticeDto.setUserid(rs.getString("userid"));
				NoticeDto.setSubject(rs.getString("subject"));
				NoticeDto.setContent(rs.getString("content"));
				NoticeDto.setRegtime(rs.getString("regtime"));
				
				list.add(NoticeDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}


	@Override
	public List<NoticeDto> listNotice() throws SQLException {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select noticeno, userid, subject, content, regtime \n");
			sql.append("from notice \n");
			sql.append("order by noticeno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDto NoticeDto = new NoticeDto();
				NoticeDto.setNoticeno(rs.getInt("noticeno"));
				NoticeDto.setUserid(rs.getString("userid"));
				NoticeDto.setSubject(rs.getString("subject"));
				NoticeDto.setContent(rs.getString("content"));
				NoticeDto.setRegtime(rs.getString("regtime"));
				
				list.add(NoticeDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public NoticeDto getNotice(int noticeno) throws SQLException {
		NoticeDto noticeDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select noticeno, userid, subject, content, regtime \n");
			sql.append("from notice \n");
			sql.append("where noticeno = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, noticeno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				noticeDto = new NoticeDto();
				noticeDto.setNoticeno(rs.getInt("noticeno"));
				noticeDto.setUserid(rs.getString("userid"));
				noticeDto.setSubject(rs.getString("subject"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setRegtime(rs.getString("regtime"));
				
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return noticeDto;
	}




	@Override
	public void modifyNotice(NoticeDto noticeDto) throws SQLException {
		int cnt = DBUtil.update("update notice set subject = ?, content = ? where noticeno = ?", 
				noticeDto.getSubject(),noticeDto.getContent(),noticeDto.getNoticeno());
		
	}

	@Override
	public void deleteNotice(int noticeno) throws SQLException {
		int cnt = DBUtil.update("delete from notice where noticeno = ?", noticeno);
		
	}


	@Override
	public void writeNotice(NoticeDto noticeDto) throws SQLException {
//		int cnt = DBUtil.update("insert into guestbook (userid, subject, content, regtime values (?, ?, ?, now())", 
//				noticeDto.getUserid(),noticeDto.getSubject(),noticeDto.getContent());
		int cnt = DBUtil.update("insert into notice (userid, subject, content) values (?, ?, ?)", 
				noticeDto.getUserid() , noticeDto.getSubject() , noticeDto.getContent());
		
	}
/*
 * INSERT INTO notice (userid, subject , content )
VALUES('ssafy', 'title', 'hello');
 * */


	@Override
	public List<NoticeDto> listNotice(PageDto pageDto) throws SQLException {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select noticeno, userid, subject, content, regtime \n");
			sql.append("from notice \n");
			sql.append("order by noticeno desc \n");
			sql.append("LIMIT ?,? \n");
			pstmt = conn.prepareStatement(sql.toString());
			int index =1 ;
			pstmt.setInt(index++, pageDto.getBegin());
			pstmt.setInt(index++, pageDto.getListSize());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDto NoticeDto = new NoticeDto();
				NoticeDto.setNoticeno(rs.getInt("noticeno"));
				NoticeDto.setUserid(rs.getString("userid"));
				NoticeDto.setSubject(rs.getString("subject"));
				NoticeDto.setContent(rs.getString("content"));
				NoticeDto.setRegtime(rs.getString("regtime"));
				
				list.add(NoticeDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}


	@Override
	public int selectNoticeCount() throws SQLException {
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						    "SELECT count(*) as cnt "
						  + "FROM notice "
				);
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnt");
		}
	}
}
