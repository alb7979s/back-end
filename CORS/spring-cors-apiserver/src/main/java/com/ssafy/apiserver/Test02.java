package com.ssafy.apiserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Rest붙으면 페이지 이동이 아닌 문자열로 날립니다! 라는 뜻
@RestController
public class Test02 {
	
	@GetMapping(value="/cors/test02", produces = "text/html; charset=utf-8")	
	public String msg() {
		System.out.println("요청이 들어왔음");
		return "<h2>응답합니다.</h2>";
	}
}
