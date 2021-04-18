package kr.co.mlec.file.service;

import java.util.List;

import kr.co.mlec.file.dao.MemberDao;
import kr.co.mlec.file.dao.MemberDaoImpl;
import kr.co.mlec.file.dto.FileDto;
import kr.co.mlec.file.dto.MemberDto;
import kr.co.mlec.file.dto.MemberFileDto;
import kr.co.mlec.file.dto.MemberLangDto;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public void join(MemberDto member) throws Exception {
		/* 직접 작성하기 - 회원정보 처리하기  */
		// *****보통 서비스를 트랜잭션의 기본 단위로 잡고감
		
		// 회원등록 - 회원테이블
		memberDao.insertMember(member);

		// 회원언어등록 - 회원언어테이블, MemberDto에 list형태로 입력해줬으니 member에서 받아와서 넣어줌
		List<MemberLangDto> langs = member.getLangList();
		for (MemberLangDto lang: langs) {
			lang.setId(member.getId());					// 이거 컨트롤러가 할 수도 있는데 그러면 작업이 복잡해져서 그냥 여기서 하게함
			memberDao.insertMemberLang(lang);
		}
		
		// 회원파일 - 파일테이블, 얘도 member에 입력해놓은거 받아옴
		List<FileDto> files = member.getFileList(); 	// FileDto 공통되는거로 받아와서 아래서 좀 더 세부적으로 좀
		if(files != null) {
			for( FileDto file: files) {
				//insertMemberFile()는 매개변수로 MemberFileDto 줘야함 
				MemberFileDto mfDto = new MemberFileDto();
				mfDto.setId(member.getId());
				file.copy(mfDto); 			//file 객체의 정보를 mfDto에 복사함(공통된 부분 값 받아줌)
				memberDao.insertMemberFile(mfDto);
			}
		}
	}
}
