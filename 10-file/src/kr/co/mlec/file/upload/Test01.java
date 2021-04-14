/*
 *   파일 업로드 프로그램 작성
 *   1. 업로드 라이브러리 다운로드
 *      : mvnrepository.com 사이트 접속후 cos 검색
 *      : 2002 11 월 버전 다운로드
 *      : WEB-INF/lib 폴더에 붙여넣기
 *      
 *   2. 테스트 파일
 *      : /Users/mrson/SSAFY/data.txt
 */
package kr.co.mlec.file.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload/test01")
public class Test01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test01.jsp").forward(request, response);
	}
	
	// 파일 전송된 포멧 형태를 확인..
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 사용자가 보내온 내용을 사용자 브라우저로 전송
		PrintWriter out = response.getWriter();
		out.println("<div>");
		
		
		// 사용자가 요청한 데이터를 꺼내기
		/* 직접 작성하기 - 파일데이터 확인하기 */
		BufferedReader br = request.getReader();	//보통은 정제된 데이터 읽어서 이런거 할 일 없음
		while (true) {
			String line = br.readLine();
			if (line == null) break;
			out.println(line + "<br>");
		}
		
		out.println("</div>");
		out.println("<h1><a href='test01'>돌아가기</a></h1>");	//doGet()으로 다시 부름
		out.close();
	}
}






