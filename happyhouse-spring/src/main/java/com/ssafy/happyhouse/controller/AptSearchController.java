package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.AptService;

@Controller
public class AptSearchController extends HttpServlet {
	
	@Autowired
	private AptService aptService;

	@RequestMapping(value="/apt", method=RequestMethod.GET)
	public String citySearch(String key, String word, Model model) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(key==null && word==null) {
			result.put("first", "first");
			model.addAttribute("result", result);
			return "apt/searchResult";
		}
		
		List<Apt> list = aptService.aptSearch(key, word);
		//System.out.println(list);
		
		result.put("key", key);
		result.put("word", word);
		result.put("aptinfo", list);
		model.addAttribute("result", result);
//		System.out.println(key+" "+word);//검색 key, word 출력 ok
//		System.out.println(list);
		return "apt/searchResult";
	}
	
	
	/**
	 * 관심지역 설정 페이지 - 모달, 시도 이름 리스트 반환해줌
	 * @return sidoCode + sidoName
	 * @throws Exception
	 */
	@RequestMapping(value="/sido", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> city() throws Exception {
		List<String> sidoCode = aptService.selectSidoCodeList();
		List<String> sidoName = aptService.selectSidoNameList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sidoCode", sidoCode);
		map.put("sidoName", sidoName);
		
		return map;
	}
	
	/**
	 * 관심지역 설정 페이지 - 모달, 시도코드 앞 2자리를 사용하여 구군 이름 리스트 구하고 반환
	 * @return sidoCode + sidoName
	 * @throws Exception
	 */
	@RequestMapping(value="/gugun", method=RequestMethod.POST)
	@ResponseBody
	public List<String> gugun (@RequestBody String code) throws Exception {
		code = code.substring(0, 2);
		List<String> list = aptService.getGugunNameList(code);
		return list;
	}
	
	/**
	 * 관심지역 설정 페이지 - 모달, code 값 받아서 동 이름 리스트 반환
	 * @return sidoCode + sidoName
	 * @throws Exception
	 */
	@RequestMapping(value="/dong", method=RequestMethod.POST)
	@ResponseBody
	public List<String> dong (@RequestBody String code) throws Exception {
		return aptService.getDongNameList(code);
	}
	
	/**
	 * 관심지역 설정 페이지 - 모달에서 저장 버튼 클릭시, 관심지역 테이블에 저장, 시도/구군/동 값을 파라미터로 받아옴
	 * @return sidoCode + sidoName
	 * @throws Exception
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public String save (@RequestBody Map<String, String> param, HttpSession session) throws Exception {
		String city = (String)param.get("city") ==null? "" : (String)param.get("city");
		String gugun = (String)param.get("gugun") ==null? "" : (String)param.get("gugun");
		String dong = (String)param.get("dong") ==null? "" : (String)param.get("dong");
	
		Map<String, String> map = new HashMap<String, String>();
		Member member = (Member)session.getAttribute("userinfo");
		map.put("userid", member.getId());
		map.put("city", city);
		map.put("gugun", gugun);
		map.put("dong", dong);
		aptService.saveFavoriteInfo(map);
		
		return "success";
	}
	
}
