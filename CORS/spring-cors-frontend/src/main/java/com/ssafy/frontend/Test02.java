package com.ssafy.frontend;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test02 {
	@GetMapping("/cors/test02.do")
	public String msg() throws IOException {
		// http://localhost:9999/apiserver/cors/test02 ajax가 아닌 자바에서 호출할거, 그 결과값 받고 다시 보낼거
		URL url = new URL("http://localhost:9999/apiserver/cors/test02");
		Scanner sc = new Scanner(url.openStream());	//그냥 간단하게 scanner 썼는데 데이터 많음 버퍼로 감싸야
		StringBuffer sb = new StringBuffer();
		while(sc.hasNextLine()) {
			sb.append(sc.nextLine());
		}
		return sb.toString();
	}
}
