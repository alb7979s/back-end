package com.ssafy.happyhouse.controller;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.dto.Preference;
import com.ssafy.happyhouse.service.FileService;
import com.ssafy.happyhouse.service.MailSendService;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.service.PreferenceService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private PreferenceService preferenceService;
	@Autowired
	private MailSendService mailSendService;
	@Autowired
	private FileService fileService;
	
	@GetMapping("/loadImage")
	public String displayPhoto(HttpServletResponse response, HttpSession session)throws Exception{
		response.setContentType("image/jpg");
	    ServletOutputStream bout = response.getOutputStream();
	    Member member = (Member) session.getAttribute("userinfo");
	    if(member == null || member.getProfilepath() == null) return null;
	    FileInputStream f = new FileInputStream(member.getProfilepath()+"\\"+member.getProfilename());
	    int length;
	    byte[] buffer = new byte[10];
	    while((length=f.read(buffer)) != -1){
	    	bout.write(buffer,0,length);
	    }
	    f.close();
	    return null;
	}
	@PostMapping("/resetPwd")
	public String resetPwd(Member param, Model model) throws Exception {
		Member member = memberService.getMemberFromId(param);
		member.setPwd(param.getPwd());
		memberService.modify(member);
		model.addAttribute("msg", "비밀번호 변경이 완료 되었습니다.");
		return "member/login";
	}
	@GetMapping("/confirm")
	public String confirm(@RequestParam Map<String, String> map, Model model) throws Exception {
		String email = map.get("email");
		String authkey = map.get("authkey").substring(0, 6);
		Member member = memberService.getMemberFromEmail(new Member().setEmail(email));		
		if(member.getAuthkey().equals(authkey)) {
			model.addAttribute("searchedid", member.getId());
			return "member/pwdReset";
		}
		model.addAttribute("msg", "인증키가 다릅니다. 잘못된 방식으로 접근하셨습니다.");
		return "member/pwdSearch";
	}
	@PostMapping("/pwdSearch")
	public String pwdSearch(Member param, Model model) throws Exception {
		Member member = memberService.getMemberFromEmail(param);
		if( member == null || !member.getId().equals(param.getId())) {
			model.addAttribute("msg", "해당 아이디와 이메일이 일치하는 정보가 없습니다.");
			return "member/pwdSearch";
		}
		member.setAuthkey(mailSendService.sendAuthMail(member.getEmail()));
		memberService.modify(member);
		model.addAttribute("msg", "'"+ member.getEmail() +"'로 메일이 전송되었습니다. 메일을 통해 인증해주세요.");
		return "member/pwdSearch";
	}
	
	@PostMapping("/idSearch")
	public String idSearch(Member member, Model model) throws Exception {
		member = memberService.getMemberFromEmail(member);
		if( member == null) {	// 해당하는 이메일 없음
			model.addAttribute("msg", "존재하는 이메일이 없습니다.");
			return "member/idSearch";
		}
		model.addAttribute("msg", "귀하의 아이디는 '" + member.getId() + "' 입니다.");
		model.addAttribute("searchedid", member.getId());
		return "member/login";
	}
	@PostMapping("/join")
	public String join(@RequestParam("profile") MultipartFile mf, Member member, Preference preference, Model model, @RequestParam("emaildomain") String emaildomain) {
		member.setEmail(member.getEmail() + "@" + emaildomain);
		try {
			if(!mf.getOriginalFilename().equals(""))member = fileService.setThumbnail(member, mf);
			memberService.join(member);
			preferenceService.regist(preference);
			return "index";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 처리 중 문제가 발생했습니다.");
			return "error/error404";
		}
	}
	
	@PostMapping("/modify")
	public String modify(Member member, Model model, @RequestParam("emaildomain") String emaildomain) {
		member.setEmail(member.getEmail() + "@" + emaildomain);
		//System.out.println(preference);
		try {
			memberService.modify(member);
			return "index";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "수정 중 문제가 생겼습니다.");
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
	
	@GetMapping("/moveLogin")
	public String moveLogin() throws Exception {
		return "member/login";
	}
	
	@GetMapping("/moveJoin")
	public String moveJoin(Model model) throws Exception {
		model.addAttribute("idList", memberService.getIdList());
		model.addAttribute("emailList", memberService.getEmailList());
		return "member/join";
	}
	
	@GetMapping("/moveModify")
	public String moveModify(Model model) throws Exception {
		model.addAttribute("emailList", memberService.getEmailList());
		return "member/modify";
	}
	@GetMapping("/moveIdSearch")
	public String moveIdSearch() throws Exception {
		return "member/idSearch";
	}
	@GetMapping("/movePwdSearch")
	public String movePwdSearch() throws Exception {
		return "member/pwdSearch";
	}
	
}
