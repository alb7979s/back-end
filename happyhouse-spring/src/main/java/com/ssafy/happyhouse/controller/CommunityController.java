package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.dto.Community;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.dto.Page;
import com.ssafy.happyhouse.service.CommunityService;

@Controller
@RequestMapping("/community")
public class CommunityController {

		@Autowired
		private CommunityService communityService;
		
		@GetMapping(value= {"","/list"}) // OK
		public String list(Integer pageNo , Model model) throws SQLException {
			if(pageNo == null) {
				pageNo = 1;
			}
			Page page = new Page(pageNo);
			model.addAttribute("result",communityService.listCommunityPage(page));
			return "community/list";
		}
		
		@ResponseBody
		@PostMapping
		public List<Community> selectlist() throws SQLException {
			List<Community> list = communityService.selectList();
			return list;
		}
		
		@RequestMapping("/")
		public String search(HttpServletRequest request, Integer pageNo, Model model) throws Exception {
			
			String key = request.getParameter("key");
			String word = request.getParameter("word");

			if(pageNo == null) { 
				pageNo = 1; 
			} 
			 
			Page page = new Page(pageNo);
			 
			Map<String, Object> list = communityService.searchCommunityPage(page, key, word);

			list.put("word", word);
			list.put("key", key);
			
			model.addAttribute("result", list);
			
			return "community/list";
		}
		
		@GetMapping("/modify") // OK
		public String mvModify(int number,Model model) throws SQLException {
			Community community = communityService.getCommunity(number);
			model.addAttribute("community", community);
			return "community/modify";
		}
		
		@PostMapping("/modify") //OK
		public String doModify(Community community, Model model) throws SQLException {
			System.out.println("modify");
			System.out.println(community);
			communityService.modifyCommunity(community);
			model.addAttribute("result",communityService.listCommunityPage(new Page(1)));
			return "community/list";
		}
		
		@GetMapping("/delete") // OK
		public String delete(int number, Model model) throws SQLException {
			communityService.deleteCommunity(number);
			model.addAttribute("result",communityService.listCommunityPage(new Page(1)));
			return "community/list";
		}
		
		@GetMapping("/detail") // OK
		public String detail(@RequestParam(value="number") Integer number, Model model) throws SQLException {
			System.out.println("detail");
			Community community = communityService.getCommunity(number);
			model.addAttribute("community", community);
			return "/community/detail";
		}
		
		@GetMapping("/write") //OK
		public String mvWrite() {
			return "/community/write";
		}
		
		@PostMapping("/write") // OK
		public String doWrite(Community community,HttpSession session , Model model) throws SQLException {
			Member member = (Member)session.getAttribute("userinfo");
			community.setUserid(member.getId());
			communityService.writeCommunity(community);
			model.addAttribute("result",communityService.listCommunityPage(new Page(1)));
			return "community/list";
		}
}
