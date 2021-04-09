package com.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.AptDto;
import com.happyhouse.model.FavoriteDto;
import com.happyhouse.model.MemberDto;
import com.happyhouse.util.DBUtil;

public class FavoriteDaoImpl implements FavoriteDao{
	private static FavoriteDao favoriteDao;
	private FavoriteDaoImpl() {};
	public static FavoriteDao getFavoriteDao() {
		if(favoriteDao == null) favoriteDao = new FavoriteDaoImpl();
		return favoriteDao;
	}
	@Override
	public FavoriteDto getDong(MemberDto memberDto) throws Exception {
		FavoriteDto paramDto = new FavoriteDto();
		paramDto.setId(memberDto.getId());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT f.dong\n");
			sql.append("FROM `member` m JOIN favorite f \n");
			sql.append("ON f.id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				paramDto.setDong(rs.getString("dong"));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return paramDto;
	}
	@Override
	public List<AptDto> getAreas(MemberDto memberDto) throws Exception {
		FavoriteDto favoriteDto = getDong(memberDto);
		System.out.println(favoriteDto.getDong());
		List<AptDto> list = new ArrayList<AptDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT DISTINCT h.no, h.dong, AptName, code, dealAmount, buildYear, dealYear, dealMonth, dealDay, area, floor, jibun \n");
			sql.append("FROM favorite f JOIN housedeal h \n");
			sql.append("WHERE h.dong = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, favoriteDto.getDong());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AptDto aptDto = new AptDto();
				aptDto.setNo(rs.getInt("no"));
				aptDto.setDong(rs.getString("dong"));
				aptDto.setAptName(rs.getString("AptName"));
				aptDto.setCode(rs.getString("code"));
				aptDto.setDealAmount(rs.getString("dealAmount"));
				aptDto.setBuildYear(rs.getString("buildYear"));
				aptDto.setDealYear(rs.getString("dealYear"));
				aptDto.setDealMonth(rs.getString("dealMonth"));
				aptDto.setDealDay(rs.getString("dealDay"));
				aptDto.setArea(rs.getString("area"));
				aptDto.setFloor(rs.getString("floor"));
				aptDto.setJibun(rs.getString("jibun"));
				list.add(aptDto);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	@Override
	public void setArea(FavoriteDto favoriteDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, no, dong\n");
			sql.append("FROM favorite \n");
			sql.append("WHERE id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, favoriteDto.getId());
			rs = pstmt.executeQuery();
			boolean isExist = false;
			while (rs.next()) {
				isExist = true;
			}
			// 존재하면 update, 존재하지 않으면 insert
			if(isExist) {
				System.out.println("exist");
				sql = new StringBuilder();
				sql.append("update favorite ");
				sql.append("	set dong = ?");
				sql.append(" where id = ? ");
				DBUtil.update(sql.toString(), favoriteDto.getDong(), favoriteDto.getId());
			} else {	
				System.out.println("not exist");
				sql = new StringBuilder();
				sql.append("insert into favorite (id, no, dong) \n");
				sql.append("values (?, ?, ?)");
				DBUtil.update(sql.toString(), favoriteDto.getId(), 1, favoriteDto.getDong());  
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}
	
}
