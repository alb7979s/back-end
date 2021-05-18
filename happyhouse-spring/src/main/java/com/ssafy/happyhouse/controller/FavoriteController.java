package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.FavoriteService;

@Controller
@RequestMapping("/favorite")
public class FavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FavoriteService favoriteService;
	
	@PostMapping("/favoriteSet")
	public String set(@RequestParam String dong, Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("userinfo");

		if(member!=null){
			try {
				favoriteService.favoriteSet(member, dong);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("msg", "회원만 사용 가능한 기능입니다");
		}
		return "redirect:/favorite";
	}
	
	@GetMapping("/mvfavorite")
	public String move(HttpSession session) throws Exception {
		if(session.getAttribute("dongList") == null) {
			session.setAttribute("dongList", favoriteService.getDongList());
		}
		return "favorite/favorite";
	}
	
	@RequestMapping(value= {"", "/favorite"})
	public String search(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("userinfo");

		if(member!=null){
			List<Apt> list;
			try {
				list = favoriteService.favoriteAreaSearch(member);
				if(list.size() != 0) {
					model.addAttribute("favoritedong", list.get(0).getDong());
					model.addAttribute("favoriteinfo", list);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("msg", "회원만 사용 가능한 기능입니다");
		}
		
		return "favorite/list";
	}

	
}
