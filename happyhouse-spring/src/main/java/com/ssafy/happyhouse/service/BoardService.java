package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.Board;
import com.ssafy.happyhouse.dto.Page;

public interface BoardService {
	void write(Board board) throws SQLException;
	List<Board> search(Map<String,String> param) throws SQLException;
	List<Board> listAll() throws SQLException;
	Board getBoard(int no) throws SQLException;
	void modify(Board board) throws SQLException;
	void delete(int no) throws SQLException;
	Map<String,Object> listPage(Page page) throws SQLException;
	List<Board> search(String word) throws SQLException;
}
