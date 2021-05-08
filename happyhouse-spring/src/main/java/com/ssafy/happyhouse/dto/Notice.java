package com.ssafy.happyhouse.dto;

public class Notice {
	private int noticeno;
	private String userid;
	private String subject;
	private String content;
	private String regtime;

	public int getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
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

	@Override
	public String toString() {
		return "NoticeDto [noticeno=" + noticeno + ", userid=" + userid + ", subject=" + subject + ", content="
				+ content + ", regtime=" + regtime + "]";
	}

}
