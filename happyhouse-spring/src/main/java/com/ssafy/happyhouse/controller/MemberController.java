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
		model.addAttribute("msg", "???????????? ????????? ?????? ???????????????.");
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
		model.addAttribute("msg", "???????????? ????????????. ????????? ???????????? ?????????????????????.");
		return "member/pwdSearch";
	}
	@PostMapping("/pwdSearch")
	public String pwdSearch(Member param, Model model) throws Exception {
		Member member = memberService.getMemberFromEmail(param);
		if( member == null || !member.getId().equals(param.getId())) {
			model.addAttribute("msg", "?????? ???????????? ???????????? ???????????? ????????? ????????????.");
			return "member/pwdSearch";
		}
		member.setAuthkey(mailSendService.sendAuthMail(member.getEmail()));
		memberService.modify(member);
		model.addAttribute("msg", "'"+ member.getEmail() +"'??? ????????? ?????????????????????. ????????? ?????? ??????????????????.");
		return "member/pwdSearch";
	}
	
	@PostMapping("/idSearch")
	public String idSearch(Member member, Model model) throws Exception {
		member = memberService.getMemberFromEmail(member);
		if( member == null) {	// ???????????? ????????? ??????
			model.addAttribute("msg", "???????????? ???????????? ????????????.");
			return "member/idSearch";
		}
		model.addAttribute("msg", "????????? ???????????? '" + member.getId() + "' ?????????.");
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
			model.addAttribute("msg", "???????????? ?????? ??? ????????? ??????????????????.");
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
			model.addAttribute("msg", "?????? ??? ????????? ???????????????.");
			return "error/error404";
		}
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model, HttpSession session) {
		String path="index";
		try {
			// userinfo ????????? member??? ???????????? ???????????? ?????????
			Member UserInfo = memberService.login(member);  
			if(UserInfo != null) {
				session.setAttribute("userinfo", UserInfo);
			} else {
				path = "member/login";
				model.addAttribute("msg", "????????? ?????? ???????????? ?????? ??? ???????????? ?????????.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "???????????? ?????? ??? ????????? ??????????????????.");
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
//			logout();		// ?????? ????????? ?????? Session ????????? ????????
			session.invalidate();
			return "index";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "?????? ?????? ??? ????????? ??????????????????.");
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
