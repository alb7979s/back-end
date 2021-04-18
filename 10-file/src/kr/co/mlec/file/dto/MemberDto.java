package kr.co.mlec.file.dto;

import java.util.ArrayList;
import java.util.List;
/*
 * controller에서 파라미터 정제 후 데이터 담아서! service()로 넘겨줄거임.
 * 근데 여기선 (회원, 언어, 파일) 3개의 데이터를 줘야는데, 따로따로 줄 수도 있지만
 * 이렇게 MemberDto에 한번에 선언해서 묶어서 줄 수 있음(연관성이 있는거니 굳이 따로 보낼 필요 없음!)
 * List인 이유는 1:N의 관계이기 때문에
 */
public class MemberDto {
	private String id;
	private String password;
	private String name;
	private String profileName;
	private String profilePath;
	private List<MemberLangDto> langList = new ArrayList<>();
	private List<FileDto> fileList = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public List<MemberLangDto> getLangList() {
		return langList;
	}
	public void setLangList(List<MemberLangDto> langList) {
		this.langList = langList;
	}
	public List<FileDto> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileDto> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", profileName=" + profileName
				+ ", profilePath=" + profilePath + ", langList=" + langList + ", fileList=" + fileList + "]";
	}
}