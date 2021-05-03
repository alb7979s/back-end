package com.ssafy.apiserver;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// CORS 해결책 - 2
@RestController
//@CrossOrigin(origins="http://localhost:9980")
@CrossOrigin(origins = "*")		// 이렇게하면 내가 만든 어떤 도메인이든 가능하게
public class Test03 {
	
	@GetMapping(value="/cors/test03", produces = "text/html; charset=utf-8")
	public String msg(HttpServletResponse response) {
		System.out.println("요청이 들어왔음");
		//이렇게 헤더로 넣어주면 됨!
//		response.setHeader("Access-Control-Allow-Origin", "http://localhost:9980");	//@CrossOrigin 어노테이션으로도 가능	
		return "<h2>Ajax CORS 응답합니다.</h2>";
	}
}
