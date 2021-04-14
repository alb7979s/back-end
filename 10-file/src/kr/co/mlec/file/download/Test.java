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
package kr.co.mlec.file.download;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/download/test.jsp").forward(request, response);
	}
}






