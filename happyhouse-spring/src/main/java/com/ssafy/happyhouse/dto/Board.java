package com.ssafy.happyhouse.dto;

public class Board {
	private int no;
	private int views;
	private String userid;
	private String subject;
	private String content;
	private String regtime;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	public String toString() {
		return "BoardDto [no=" + no + ", views=" + views + ", userid=" + userid + ", subject=" + subject + ", content="
				+ content + ", regtime=" + regtime + "]";
	}
	public String toString(String dto, String like) {
		return dto + " [no=" + no + ", views=" + views + ", userid=" + userid + ", subject=" + subject + ", content="
				+ content + ", regtime=" + regtime + ", like=" + like + "]";
	}
}
