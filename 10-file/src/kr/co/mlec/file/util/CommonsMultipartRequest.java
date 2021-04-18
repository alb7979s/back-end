package kr.co.mlec.file.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.co.mlec.file.dto.FileDto;
import net.coobird.thumbnailator.Thumbnails;

public class CommonsMultipartRequest {
	// 컨트롤러에서 일반 폼데이터를 사용 할 수 있도록 변수 선언
	private Map<String, List<String>> parameterMap = new HashMap<>();
	// 컨트롤러에서 파일 데이터를 사용 할 수 있도록 변수 선언
	private Map<String, List<FileDto>> fileMap = new HashMap<>();
	
	//파일 저장할거라 path경로도 받아줄거, tuhumbnail도 true면 생성, false면 생성안함(false를 default로 놔주려고 아래처럼 만듦)
	public CommonsMultipartRequest(HttpServletRequest request, String path) throws Exception {	
		this(request, path, false);
	}
	public CommonsMultipartRequest(HttpServletRequest request, String path, boolean thumbnail) throws Exception {	
		// 보통 resources라고 설정 관련된거 만듦(스프링 가면 .properties 이용해서 할거, 일단 여기선 저런식으로 처리한다만 알고 넘어가기)
		String uploadRoot = "c:/SSAFY/upload";
		// 이 두 줄은 사용자가 객체를 생성할때 넘겨준 path를 사용할거
//		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
//		String filePath = "/commons" + sdf.format(new Date());
		File file = new File(uploadRoot, path);
		if (file.exists() == false) file.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(uploadRoot + "/temp"));
		factory.setSizeThreshold(1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 30);  // 개별 파일 최대 사이즈 지정 
		upload.setSizeMax(1024 * 1024 * 300);  // 요청 전체의 최대 사이즈
		
		List<FileItem> lists = upload.parseRequest(request);
		for (FileItem item : lists) {
			String fieldName = item.getFieldName();
			if (item.isFormField()) {	// type file이 아닐 때 true값, 즉 일반 폼 데이터 일 때
				String fieldValue = item.getString("utf-8");
				List<String> values = parameterMap.get(fieldName);
				if(values == null) {
					values = new ArrayList<>();
				} 
				values.add(fieldValue);
				parameterMap.put(fieldName, values);
			} else {					// type이 file인 경우 
				String name = item.getName();
				if (name.equals("")) continue;
				
				String contentType = item.getContentType();
				
				String ext = "";
				int index = name.lastIndexOf(".");
				if (index != -1) { 
					ext = name.substring(name.lastIndexOf("."));
				}
				
				File f = new File(file, UUID.randomUUID() + ext);
				item.write(f);
				
				if (contentType.startsWith("image/") && thumbnail) {	//thumbnail 참 일 때만 만들거
					Thumbnails.of(f)
					          .size(300, 200)
					          .outputFormat("jpg")
					          .toFile(new File(f.getParent(), "thumb_" + f.getName()));
				}
				FileDto fileDto = new FileDto();
				fileDto.setContentType(contentType);
				fileDto.setOrgName(name);
				fileDto.setPath(path);
				fileDto.setSize(f.length());
				fileDto.setSystemName(f.getName());
				
				List<FileDto> values = fileMap.get(fieldName);
				if(values == null) {
					values = new ArrayList<>();
				} 
				values.add(fileDto);
				fileMap.put(fieldName, values);
			}
		}
	}
	
	public String getParameter(String fieldName) {
		return parameterMap.get(fieldName) != null ? parameterMap.get(fieldName).get(0) : null;
	}
	@SuppressWarnings("unchecked")
	public List<String> getParameterValues(String fieldName) {
		// EMPTY_LIST는 null안넘김 (길이가 0인거 넘김, 사용자 입장에서 null 체크 안해줘도 됨)
		return parameterMap.get(fieldName) == null ? Collections.EMPTY_LIST : parameterMap.get(fieldName);
	}
	public FileDto getFile(String fieldName) {
		return fileMap.get(fieldName) != null ? fileMap.get(fieldName).get(0) : null;
	}
	public List<FileDto> getFileList(String fieldName) {
		return fileMap.get(fieldName);
	}
	
}