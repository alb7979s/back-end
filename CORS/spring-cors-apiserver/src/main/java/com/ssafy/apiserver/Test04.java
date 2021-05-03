package com.ssafy.apiserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// CORS 해결책 - 3
@RestController
public class Test04 {
	
	@GetMapping(value="/cors/test04", produces = "text/html; charset=utf-8")
	public String msg(String callback) {
		String callbackFn = "cb";
		if(callback != null) {
			callbackFn = callback;
		}
		return callbackFn + "('<h2>Ajax CallBack 호출성공~~ </h2>')";
	}
}
