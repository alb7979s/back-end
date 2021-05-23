package com.ssafy.happyhouse.dto;

// setter chaining 방식 적용
public class Member {

	private String id;
	private String pwd;
	private String dpt;		//department
	private String email;
	private String authkey;
	private String profilepath;
	private String profilename;
	
	public String getProfilepath() {
		return profilepath;
	}
	public Member setProfilepath(String profilepath) {
		this.profilepath = profilepath;
		return this;
	}
	public String getProfilename() {
		return profilename;
	}
	public Member setProfilename(String profilename) {
		this.profilename = profilename;
		return this;
	}
	public String getAuthkey() {
		return authkey;
	}
	public Member setAuthkey(String authkey) {
		this.authkey = authkey;
		return this;
	}
	public String getId() {
		return id;
	}
	public Member setId(String id) {
		this.id = id;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public Member setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getDpt() {
		return dpt;
	}
	public Member setDpt(String dpt) {
		this.dpt = dpt;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}

	public String toString() {
		return "id= " + id + " pwd=" + pwd + " dpt=" + dpt + " email=" + email + " authkey=" + authkey;
	}
}