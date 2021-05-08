package com.ssafy.happyhouse.dto;

public class Member {

	private String id;
	private String pwd;
	private String dpt;		//department
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDpt() {
		return dpt;
	}
	public void setDpt(String dpt) {
		this.dpt = dpt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}