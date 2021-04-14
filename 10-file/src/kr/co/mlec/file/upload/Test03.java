/*
 *   여러파일 업로드 하기
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload/test03")
public class Test03 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test03.jsp").forward(request, response);
	}
	
	// 파일 여러개 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest mRequest = new MultipartRequest(
				request,  
				"c:/SSAFY/upload",
				1024 * 1024 * 100, 
				"utf-8",  
				new DefaultFileRenamePolicy() 
		);
		
		/* 직접 작성하기 - 여러개의 파일 처리하기 */
		/*
		for(int i = 1; i < 6; i++) {
			String fName = "attach" + i;
			File f = mRequest.getFile(fName); 	
			System.out.println("파일 객체: " + f);
			if (f != null) {
				String orgName = mRequest.getOriginalFileName(fName);
				String systemName = mRequest.getFilesystemName(fName);
				long size = f.length();
				System.out.println("원본파일명 : " + orgName);
				System.out.println("저장파일명 : " + systemName);
				System.out.println("파일크기(byte) : " + size );
			}
		}
		*/
		/*
		// 만약 이름이 넘버링이 안되어 있다면 배열 써서, 근데 이런 정적인 코드는 문제가 될 수 있음 그래서 동적으로 가져올 수 있도록 이미 메서드 있음
		String[] arr = {"attach1", "attach2", "attach3", "attach4", "attach5", "attach6"}; 	//바꾸기 귀찮음, 그냥 넘버링 안되어있다 생각해ㅎㅎ;;
		for(String fName: arr) {
			File f = mRequest.getFile(fName); 	
			System.out.println("파일 객체: " + f);
			if (f != null) {
				String orgName = mRequest.getOriginalFileName(fName);
				String systemName = mRequest.getFilesystemName(fName);
				long size = f.length();
				System.out.println("원본파일명 : " + orgName);
				System.out.println("저장파일명 : " + systemName);
				System.out.println("파일크기(byte) : " + size );
			}
		}
		*/
		
		// 동적으로 이름 가져오기 (권장)
		@SuppressWarnings("unchecked")
		Enumeration<String> names = mRequest.getFileNames();	//예전에 쓰던건데 요즘은 iterator씀, 근데 이 cos가 예전에 만들어놓은거라 
		while(names.hasMoreElements()) {
			String fName = names.nextElement();
			File f = mRequest.getFile(fName); 	
			System.out.println("파일 객체: " + f);
			if (f != null) {
				String orgName = mRequest.getOriginalFileName(fName);
				String systemName = mRequest.getFilesystemName(fName);
				long size = f.length();
				System.out.println("원본파일명 : " + orgName);
				System.out.println("저장파일명 : " + systemName);
				System.out.println("파일크기(byte) : " + size );
			}
		}
		
		
		response.sendRedirect("test03");
	}
}






