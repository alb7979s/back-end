package com.ssafy.happyhouse.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

		@Autowired
		private NoticeService noticeService;
		
		@GetMapping(value= {"","/list"}) // OK
		public String list(Integer pageNo , Model model) throws SQLException {
			System.out.println("list");
			if(pageNo == null) {
				pageNo = 1;
			}
			Page page = new Page(pageNo);
			model.addAttribute("result",noticeService.listNoticePage(page));
			return "notice/list";
		}
		
/*		@GetMapping("/search") 
		public String list(SearchNotice searchNotice , Model model) throws SQLException {
			System.out.println("search");
			System.out.println(searchNotice);
			model.addAttribute("result",noticeService.search(searchNotice));
			return "notice/list";
		}*/
		
		@GetMapping("/modify") // OK
		public String mvModify(int number,Model model) throws SQLException {
			Notice notice = noticeService.getNotice(number);
			model.addAttribute("notice", notice);
			return "notice/modify";
		}
		
		@PostMapping("/modify") //OK
		public String doModify(Notice notice, Model model) throws SQLException {
			System.out.println("modify");
			System.out.println(notice);
			noticeService.modifyNotice(notice);
			model.addAttribute("result",noticeService.listNoticePage(new Page(1)));
			return "notice/list";
		}
		
		@GetMapping("/delete") // OK
		public String delete(int number, Model model) throws SQLException {
			noticeService.deleteNotice(number);
			model.addAttribute("result",noticeService.listNoticePage(new Page(1)));
			return "notice/list";
		}
		
		@GetMapping("/detail") // OK
		public String detail(@RequestParam(value="number") Integer number, Model model) throws SQLException {
			System.out.println("detail");
			Notice notice = noticeService.getNotice(number);
			model.addAttribute("notice", notice);
			return "/notice/detail";
		}
		
		@GetMapping("/write") //OK
		public String mvWrite() {
			System.out.println("GetWrite");
			return "/notice/write";
		}
		
		@PostMapping("/write") // OK
		public String doWrite(Notice notice,HttpSession session , Model model) throws SQLException {
			System.out.println("postWrite");
			/*
			 * 
			 * 
			 * session으로 사용자 받아서 등록하기
			 * 
			 * 
			 * */
			Member member = (Member)session.getAttribute("userinfo");
			System.out.println(member);
			notice.setUserid(member.getId());
			noticeService.writeNotice(notice);
			model.addAttribute("result",noticeService.listNoticePage(new Page(1)));
			return "notice/list";
		}
}
