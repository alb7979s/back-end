package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Board;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.dto.PageResult;
import com.ssafy.happyhouse.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper BoardMapper;

	@Override
	public List<Board> search(Map<String,String> param) throws SQLException {
		if(param.get("pageNo")== null) {
			param.put("pageNo", "1");
		}
		param.put("listSize" , "10");
		HashMap<String,Object> newParam = new HashMap<String,Object>();
		newParam.put("type", param.get("type"));
		newParam.put("word", param.get("word"));
		String pageNo = param.get("pageNo");
		if(pageNo == null) newParam.put("page",new Page(1));
		else newParam.put("page",new Page(Integer.parseInt(pageNo)));
		System.out.println(newParam.get("page"));
		return BoardMapper.search(newParam);
	}

	@Override
	public List<Board> listAll() throws SQLException {
		return BoardMapper.listAll();
	}
	
	@Override
	public List<Board> search(String word) throws SQLException {
		return BoardMapper.search(word);
	}

	@Override
	public Board getBoard(int no) throws SQLException {
		return BoardMapper.getBoard(no);
	}

	@Override
	public void modify(Board board) throws SQLException {
		BoardMapper.modify(board);
		
	}

	@Override
	public void delete(int no) throws SQLException {
		BoardMapper.delete(no);
		
	}

	@Override
	public void write(Board board) throws SQLException {
		BoardMapper.write(board);
		
	}

	@Override
	public Map<String, Object> listPage(Page page) throws SQLException {
		//게시물 목록
		List<Board> list = BoardMapper.listPage(page);
		//페이징을 위해서 게시물 전체 갯수
		System.out.println(list);
		int count = BoardMapper.selectCount();
		
		PageResult prd = new PageResult(page.getPageNo(),count);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list",list);
		result.put("pageResult", prd);
		
		return result;
	}

}
