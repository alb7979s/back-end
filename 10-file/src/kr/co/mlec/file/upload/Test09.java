/*
 * 이미지 드래그 미리보기
 */
package kr.co.mlec.file.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/upload/test09")
public class Test09 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test09.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadRoot = "/Users/mrson/SSAFY/upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String filePath = "/commons" + sdf.format(new Date());
		File file = new File(uploadRoot, filePath);
		if (file.exists() == false) file.mkdirs();
		
		try {
			// 메모리를 활용하는 옵션 설정을 위한 객체
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(uploadRoot + "/temp"));
			factory.setSizeThreshold(1024);
			
			// 업로드 처리 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 3);  // 개별 파일 최대 사이즈 지정 
			upload.setSizeMax(1024 * 1024 * 3);  // 요청 전체의 최대 사이즈
			
			List<FileItem> lists = upload.parseRequest(request);
			for (FileItem item : lists) {
				if (item.isFormField()) {
					System.out.println("일반 필드명 : " + item.getFieldName());
					System.out.println("일반 필드값 : " + item.getString("utf-8"));
				} else {
					String name = item.getName();
					// 파일을 선택하지 않은 경우
					if (name.equals("")) continue;
					
					String contentType = item.getContentType();
					System.out.println("필드명 : " + item.getFieldName());
					System.out.println("파일명 : " + name);
					System.out.println("파일크기 : " + item.getSize());
					System.out.println("파일타입 : " + contentType);
					
					String ext = "";
					int index = name.lastIndexOf(".");
					if (index != -1) { 
						ext = name.substring(name.lastIndexOf("."));
					}
					// 파일 저장하기
					File f = new File(file, UUID.randomUUID() + ext);
					item.write(f);
					if (contentType.startsWith("image/")) {
						// 썸네일 이미지 생성하기
						Thumbnails.of(f)
						          .size(300, 200)
						          .outputFormat("jpg")
						          .toFile(new File(f.getParent(), "thumb_" + f.getName()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2 class='center success'>업로드 성공</h2>");
		out.close();
	}
}