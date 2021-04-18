/*
 *   썸네일 생성하기(이미지 원본으로 보여줄라면 너무 오래걸리니까!)
 *   
 *   - Thumbnailator 라이브러리 이용하기
 *   https://github.com/coobird/thumbnailator
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

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/upload/test05")
public class Test05 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test05.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadRoot = "c:/SSAFY/upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String path = "/member" + sdf.format(new Date());
		
		// uploadPath + datePath 경로가 존재하는지 확인하고 존재하지 않으면 디렉토리 생성
		File file = new File(uploadRoot + path);
		if (!file.exists()) file.mkdirs();
		
		
		MultipartRequest mRequest = new MultipartRequest(
				request,  
				uploadRoot + path,
				1024 * 1024 * 100, 
				"utf-8",  
				new MlecFileRenamePolicy()  
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
				
				/* 직접 작성하기 - 원본이미지에 대한 썸네일 만들기 */
				Thumbnails.of(f)
				.size(300, 200)				// 만약 이미지 비율 1:1인데 300, 200 하면 그냥 1:1 사이즈로 바꿔줌(이미지 안깨지게), 그냥 바꿀라면.forceSize()
				.outputFormat("jpg")
				.toFile(new File(f.getParent(), "thumb_" + systemName));		// 저장할 곳, 원본이미지 있는 경로에 만들어줄거임!, 뒤에는 이름	 
			}
		}
		response.sendRedirect("test05");
	}
}






