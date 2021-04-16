package kr.co.mlec.file.dto;

import java.util.ArrayList;
import java.util.List;

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