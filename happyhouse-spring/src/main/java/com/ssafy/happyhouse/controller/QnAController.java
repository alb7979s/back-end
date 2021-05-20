/*
REST 방식
게시글 목록 /qna{(pageNo)} - GET
게시글 수정 /qna - PUT
게시글 삭제 /qna/{no} - DELETE
게시글 상세검색 /qna/{no} - GET
게시글 등록 /qna - POST

*/
package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.service.BoardService;

@RestController
@RequestMapping("/qna")
@CrossOrigin("*")
public class QnAController {

		@Autowired
		BoardService boardService;
		
//		@GetMapping("{pageNo}")
//		public Map<String,Object> list(@PathVariable("pageNo") Integer pageNo) throws SQLException {
//			if(pageNo == null) {
//				pageNo = 1;
//			}
//			Page page = new Page(pageNo);
//			return boardService.listPage(page);
//		}
		@GetMapping
		public List<Board> list() throws SQLException {
			return boardService.listAll();
		}
		
		@GetMapping("/search/{word}")
		public List<Board> searchList(@PathVariable("word") String word) throws SQLException {
			return boardService.search(word);
		}
		
		// SPA인데 이동이 필요한가?
//		@GetMapping("/modify") 
//		public String mvModify(int no,Model model) throws SQLException {
//			Board board = boardService.getBoard(no);
//			model.addAttribute("qna", board);
//			return "modify";
//		}
		
		
//		@PutMapping 
//		public Map<String, Object> doModify(@RequestBody Board board) throws SQLException {
//			boardService.modify(board);
//			return boardService.listPage(new Page(1));
//		}
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
		// 이 친구도 이동
//		@GetMapping("/write") 
//		public String mvWrite() {
//			return "write";
//		}
		
//		게시글 등록 /qna - POST
		@PostMapping
		public void doWrite(@RequestBody Board board, HttpSession session) throws SQLException {
			System.err.println(board);
			Member member = (Member)session.getAttribute("userinfo");
			board.setUserid("ssafy");
			boardService.write(board);
		}
}
