package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Board;
import com.ssafy.happyhouse.dto.Page;

public interface BoardMapper {
	public void write(Board board) throws SQLException;
	public List<Board> search(Map<String,Object> param) throws SQLException;
	public List<Board> listAll() throws SQLException;
	public List<Board> listPage(Page page) throws SQLException;
	public int selectCount() throws SQLException;
	public Board getBoard(int no) throws SQLException;
	public void modify(Board board) throws SQLException;
	public void delete(int no) throws SQLException;
}
