/*
REST 방식
게시글 목록 /qna - GET
게시글 수정 /qna - PUT
게시글 삭제 /qna/{no} - DELETE
게시글 상세검색 /qna/{no} - GET
게시글 등록 /qna - POST

*/
package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Board;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.BoardService;

@RestController
@RequestMapping("/qna")
public class QnAController {

		@Autowired
		BoardService boardService;
		
		@GetMapping
		public List<Board> list() throws SQLException {
			return boardService.listAll();
		}
		
		@PutMapping
		public void doModify(@RequestBody Board board) throws SQLException {
			boardService.modify(board);
		}
		
		@DeleteMapping("{no}")
		public void delete(@PathVariable("no") Integer no) throws SQLException {
			boardService.delete(no);
//			return boardService.listPage(new Page(1));
		}
	
		@GetMapping("{no}") 
		public Board detail(@PathVariable("no") Integer no) throws SQLException {
			return boardService.getBoard(no);
		}
		
		@PostMapping
		public void doWrite(@RequestBody Board board, HttpSession session) throws SQLException {
			Member member = (Member)session.getAttribute("userinfo");
			board.setUserid(member.getId());
			boardService.write(board);
		}
}
