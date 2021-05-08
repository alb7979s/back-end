package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/join")
	public String join(Member member, Model model, @RequestParam("emaildomain") String emaildomain) {
		member.setEmail(member.getEmail() + "@" + emaildomain);
		try {
			memberService.join(member);
			return "index";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 처리 중 문제가 발생했습니다.");
			return "error/error404";
		}
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model, HttpSession session) {
		String path="index";
		try {
			// userinfo 나중에 member로 통일해서 바꿔주면 좋을듯
			Member UserInfo = memberService.login(member);  
			if(UserInfo != null) {
				session.setAttribute("userinfo", UserInfo);
			} else {
				path = "member/login";
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 처리 중 문제가 발생했습니다.");
			path = "error/error404";
		}
		return path;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@PostMapping("/withdraw")
	public String withdtaw(Member member, Model model, HttpSession session) {
		try {
			memberService.withdraw(member);
//			logout();		// 만약 이렇게 하면 Session 어떻게 하지??
			session.invalidate();
			return "index";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "탈퇴 처리 중 문제가 발생했습니다.");
			return "error/error404";
		}
	}
	@PostMapping("/modify")
	public String modify(Member member, Model model) {
		try {
			memberService.modify(member);
			return "index";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "수정 하는 중 문제가 발생했습니다.");
			return "error/error404";
		}
	}
	
	@GetMapping("/moveLogin")
	public String moveLogin() {
		return "member/login";
	}
	
	@GetMapping("/moveJoin")
	public String moveJoin() {
		return "member/join";
	}
	
	@GetMapping("/moveModify")
	public String moveModify() {
		return "member/modify";
	}
	
	
}
