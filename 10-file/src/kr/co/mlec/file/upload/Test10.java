/*
 * 데이터베이스 처리하기
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

import kr.co.mlec.file.dto.MemberDto;
import kr.co.mlec.file.dto.MemberFileDto;
import kr.co.mlec.file.dto.MemberLangDto;
import kr.co.mlec.file.service.MemberService;
import kr.co.mlec.file.service.MemberServiceImpl;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/upload/test10")
public class Test10 extends HttpServlet {

	private MemberService service;
	public Test10() {
		service = new MemberServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test10.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDto member = new MemberDto();
		
		String uploadRoot = "c:/SSAFY/upload";
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
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
			upload.setFileSizeMax(1024 * 1024 * 30);  // 개별 파일 최대 사이즈 지정 
			upload.setSizeMax(1024 * 1024 * 300);  // 요청 전체의 최대 사이즈
			
			List<FileItem> lists = upload.parseRequest(request);
			for (FileItem item : lists) {
				String fieldName = item.getFieldName();
				if (item.isFormField()) {	// type file이 아닐 때 true값, 즉 일반 폼 데이터 일 때
					/* 직접 작성하기 - 데이터베이스 저장을 위한 코드 추가 */
					
					// <input type="text" id="id" name="id" />
					// member.setId();
					// <input type="text" id="name" name="name" />
					// member.setName();
					// 이런식으로 해주는걸 아래처럼!
//					String fieldName = item.getFieldName();	얘는 아~~래서도 쓸거라 if 위로 뽑아줌
					String fieldValue = item.getString("utf-8");
					switch(fieldName) {
						case "id":
							member.setId(fieldValue);
							break;
						case "name":
							member.setName(fieldValue);
							break;
						case "password":
							member.setPassword(fieldValue);
							break;
						case "lang":	// lang은 여러개라 추가 작업 필요!
							MemberLangDto mlDto = new MemberLangDto();
							mlDto.setLang(fieldValue);
							// 여기서 setId 안해준 이유는 id값이 위에나올지, 아래나올지 모르니까 service()에서 처리해준거
							member.getLangList().add(mlDto);
							break;
					}
				} else {	// type이 file인 경우 
					String name = item.getName();
					// 파일을 선택하지 않은 경우
					if (name.equals("")) continue;
					
					String contentType = item.getContentType();
					
					String ext = "";
					int index = name.lastIndexOf(".");
					if (index != -1) { 
						ext = name.substring(index);
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
					
					/* 직접 작성하기 - 데이터베이스 저장을 위한 코드 추가 */
					// 두 종류로 나눈 이유? DB 저장하는 테이블이 다르니까!
					if(fieldName.equals("profile")) {
						member.setProfilePath(filePath);
						member.setProfileName(f.getName());
					} else {
						MemberFileDto mfDto = new MemberFileDto();
						// 이 순간에 id 없을수도 있어서 id는 service에서 처리함
						mfDto.setContentType(contentType);
						mfDto.setOrgName(name);
						mfDto.setPath(filePath);
						mfDto.setSize(f.length());
						mfDto.setSystemName(f.getName());
						member.getFileList().add(mfDto);
					}
				}
			}
			/* 직접 작성하기 - 서비스 호출하기 */
			service.join(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("test10");
	}
}