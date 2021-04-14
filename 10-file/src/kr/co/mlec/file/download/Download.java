package kr.co.mlec.file.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 파일 다운은 이런 형식으로 쓴다 알아두기, 어떤 뜻인지도 알아두면 더 좋고
@WebServlet("/download.do")
public class Download extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 정보 추출하기
		// path(저장된 파일의 경로), name(실제 저장된 파일이름)
		String uploadRoot = "c:/SSAFY/upload";
		
		String path = request.getParameter("path");
		String name = request.getParameter("name");
		
		// 파일을 읽기 위한 파일 객체 생성
		File f = new File(uploadRoot + path, name);
		
		// 다운로드 할 파일 이름
		// dName : 사용자 컴퓨터에 저장할 파일명
		String dName = request.getParameter("dname");
		// 다운로드할 이름을 주지 않은 경우 사용자 브라우져에 이미지 출력	
		if (dName == null) {
			response.setHeader("Content-Type", "image/jpg");
		}
		// 다운로드 
		else {
			// octet-stream이라는 것은 말 그대로 8비트로 된 일련의 데이타를 뜻한다. 
			// 형식을 모르니깐 이런 식으로 표시하는 것이다. 
			// 브라우져에게 타입을 잘 모릅니다. 라고 하니 ... 브라우져는 잘 모르는 타입이니 다운로드 하게 된다
			response.setHeader("Content-Type", "application/octet-stream");
			
			// 한글이름으로 다운로드 처리
			dName = new String(dName.getBytes("utf-8"), "8859_1");		//8859_1 => 브라우저가 기본적으로 사용하는 인코딩이래
			
			// 다운로드할 이름 설정
			response.setHeader(
					"Content-Disposition", "attachment;filename=" + dName
			);
		}
		
		// 특정 위치의 파일을 읽어서 사용자 브라우져로 출력
		// 파일을 읽고 사용자에게 전송
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
	
		while (true) {
			int ch = bis.read();
			if (ch == -1) break;
			
			bos.write(ch);
		}
		
		bis.close();  fis.close();
		bos.close();  out.close();
	}
}






















