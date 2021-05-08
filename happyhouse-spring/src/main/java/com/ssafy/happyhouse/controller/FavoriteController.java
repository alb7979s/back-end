package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Favorite;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.FavoriteService;

@Controller
//@RequestMapping("/favorite")
public class FavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FavoriteService favoriteService;

	@PostMapping("/favoriteSet")
	public String set(HttpServletRequest request, Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("userinfo");

		if(member!=null){
			try {
				String dong = request.getParameter("dong");
				System.out.println("dong " + dong);
				Favorite favorite = new Favorite();
				favorite.setDong(dong);
				System.out.println(favorite.toString());
				favoriteService.favoriteSet(member, dong);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("msg", "회원만 사용 가능한 기능입니다");
		}
		return "redirect:/";
	}
	
	@GetMapping("/mvfavorite")
	public String move() {
		return "favorite/favorite";
	}
	
	@RequestMapping("/favorite")
	public String search(Model model, HttpSession session) {
		
		Member member = (Member) session.getAttribute("userinfo");

		if(member!=null){
			List<Apt> list;
			try {
				list = favoriteService.favoriteAreaSearch(member);
				System.out.println(list);
				if(list != null)
					model.addAttribute("favoritedong", list.get(0).getDong());
				model.addAttribute("favoriteinfo", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("msg", "회원만 사용 가능한 기능입니다");
		}
		
		return "favorite/list";
	}

	
}
