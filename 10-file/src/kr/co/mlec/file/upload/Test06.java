/*
 * Apache Commons를 이용한 파일 업로드 처리하기 
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/upload/test06")
public class Test06 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test06.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadRoot = "c:/SSAFY/upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String filePath = "/commons" + sdf.format(new Date());
		File file = new File(uploadRoot, filePath);
		if (file.exists() == false) file.mkdirs();	//!보다 false가 더 직관적이라고 이렇게 쓰는 사람들도 있대~
		
		try {
			/* 직접 작성하기 - Apache Commons 라이브러리 사용하기 */
			// 메모리를 활용하는 옵션 설정 클래스
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024);
			factory.setRepository(new File(uploadRoot + "/temp"));	//메모리 넘어가면 임시로 저장
			
			// 업로드 처리 객체, MultipartRequest랑 비슷, 근데 차이점은 얘는 실제 저장은 안함(따로 저장하라는 명령어 내려야함)
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 2); 	// 개별적인 파일 각각의 최대 파일 크기
			upload.setSizeMax(1024 * 1024 * 3); 		// 요청 전체의 최대 크기 지정
			
			// 파싱된 결과물
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item: items) {
				// item 클래스의 객체가 가리키는 정보가 파일인지 안니지 판단
				if (item.isFormField()) {	// 일반 데이터
					System.out.println("fieldName : " + item.getFieldName());
					System.out.println("fieldValue : " + item.getString("utf-8"));
				} else {					// 파일 데이터
					// 원본파일명
					// 실제 저장된 파일명(X, 저장을 안했으니 못얻는게 당연)
					// 파일 사이즈
					// 파일 타입
					String name = item.getName();		//사용자가 화면에서 선택한 파일명
					System.out.println("파일명 : " + name);
					// 사용자가 파일을 선택하지 않은 경우
					if(name.equals("")) {
						continue;
					}
					// 사용자가 파일을 선택한 경우
					System.out.println("파일 크기 : " + item.getSize());
					System.out.println("파일 타입 : " + item.getContentType());	
					
					// 저장 관련 작업은 별도로 처리한다.
					// MlecFileRenamePolicy.java 에서 복사해온건데 나중에 모듈화 하면 좋겠쥬?
					String parent = file.getPath();	//file 갖고 있는 전체 경로 다 줌, 위에 보면 경로 가지고 만들어놓음
					String ext = "";
			 		int index = name.lastIndexOf(".");
					if (index != -1) {
						ext = name.substring(index);
					}
					// 경로 + 고유한 이름 가진 file 객체
					File f = new File(parent, UUID.randomUUID() + ext);
					item.write(f);		// 이게 실제 저장
					
					// 썸네일 만들기
					if (item.getContentType().startsWith("image")) {
						Thumbnails.of(f)
						.size(300, 200)				
						.outputFormat("jpg")
						.toFile(new File(f.getParent(), "thumb_" + f.getName()));	//맨 뒤 파일명 getName()으로 가져옴
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("test06");
	}
}