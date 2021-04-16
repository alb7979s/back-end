/*
 * commons-fileupload 사용 업로드 모듈화
 */
package kr.co.mlec.file.upload;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.file.dto.FileDto;
import kr.co.mlec.file.dto.MemberDto;
import kr.co.mlec.file.dto.MemberLangDto;
import kr.co.mlec.file.service.MemberService;
import kr.co.mlec.file.service.MemberServiceImpl;
import kr.co.mlec.file.util.CommonsMultipartRequest;

@WebServlet("/upload/test11")
public class Test11 extends HttpServlet {

	private MemberService service;
	public Test11() {
		service = new MemberServiceImpl();
	}
	
	private static final long serialVersionUID = 1L;

	// 파일 등록 폼 페이지 이동하기
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/file/upload/test11.jsp").forward(request, response);
	}
	
	// 썸네일 저장하기
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* 직접 작성하기 - 모듈화 */
			CommonsMultipartRequest mRequest = new CommonsMultipartRequest(
					request, "/member" + new SimpleDateFormat("/yyyy/MM/dd").format(new Date())
			);
			
			/* 직접 작성하기 - 회원 정보 파라미터 처리하기 및 디비 저장 */
			MemberDto member = new MemberDto();
			member.setId(mRequest.getParameter("id"));
			member.setName(mRequest.getParameter("name"));
			member.setPassword(mRequest.getParameter("password"));
			// lang (여러개의 값이 넘어온 것의 처리)
			List<String> langs = mRequest.getParameterValues("lang");
			for(String lang : langs) {	// langs 넘겨올때 null 안주게 처리해줘서 null체크 안함
				MemberLangDto langDto = new MemberLangDto();
				langDto.setLang(lang);
				langDto.setId(member.getId());
				member.getLangList().add(langDto);
			}
			// file 타입이지만 memberDto에 설정(profile)
			FileDto fileDto = mRequest.getFile("profile");
			member.setProfileName(fileDto.getSystemName());
			member.setProfilePath(fileDto.getPath());
			// attachs 로 들어온 파일 정보
			member.setFileList(mRequest.getFileList("attaches"));
			
			service.join(member);
			response.sendRedirect("test11");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}