/*
 *   저장되는 경로와 파일 이름을 변경
 *   - 저장 경로 : 파일이 업로드되는 시간을 활용(년/월/일/시)
 *   - 파일 이름 : 고유한 이름을 생성(UUID) - FileRenamePolicy를 구현한 클래스 생성
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/upload/test04")
public class Test04 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test04.jsp").forward(request, response);
	}
	
	// 파일 여러개 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 직접 작성하기 - 파일 업로드 경로와 저장 파일명 변경하기 */
		String uploadRoot = "c:/SSAFY/upload";	//얘는 고정된 값으로 DB에 저장할 필요 없어서 아래거랑 나눠줌
		
		// 회원관련으로 가정하고 진행
		String path = "/member" + new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		System.out.println(uploadRoot + path);
		
		// 이제 이 디렉토리를 실제 존재하도록 만들어줘야함
		File file = new File(uploadRoot + path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		MultipartRequest mRequest = new MultipartRequest(
				request,  
				uploadRoot + path,
				1024 * 1024 * 100, 
				"utf-8",  
				new MlecFileRenamePolicy()	//file 이름 어떻게 바꿀지 정책 정해줌, FileRenamePolicy 인터페이스만 올 수 있음! 구현 하는거 만들어서 재정의해줄거
		);
		
		@SuppressWarnings("unchecked")
		Enumeration<String> names = mRequest.getFileNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
			
			File f = mRequest.getFile(name);
			if (f != null) {
				String oriName = mRequest.getOriginalFileName(name);
				String systemName = mRequest.getFilesystemName(name);
				long fileSize = f.length();
				System.out.println("원본파일명 : " + oriName);
				System.out.println("저장파일명 : " + systemName);
				System.out.println("파일 크기(byte) : " + fileSize);
			}
		}
		response.sendRedirect("test04");
	}
}