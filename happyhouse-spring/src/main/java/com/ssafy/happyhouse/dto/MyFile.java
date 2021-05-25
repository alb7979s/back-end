package com.ssafy.happyhouse.dto;

public class MyFile {
	private int no;
	private int boardno;
	private long size;
	private String path;
	private String orgname;
	private String systemname;
	private String contenttype;
	
	public MyFile() {}
	public MyFile(int boardno, long size, String path, String orgname, String systemname, String contettype) {
		this.boardno = boardno;
		this.size = size;
		this.path = path;
		this.orgname = orgname;
		this.systemname = systemname;
		this.contenttype = contettype;
	}
	public int getBoardno() {
		return boardno;
	}
	public MyFile setBoardno(int boardno) {
		this.boardno = boardno;
		return this;
	}
	public int getNo() {
		return no;
	}
	public MyFile setNo(int no) {
		this.no = no;
		return this;
	}
	public String getPath() {
		return path;
	}
	public MyFile setPath(String path) {
		this.path = path;
		return this;
	}
	public String getOrgname() {
		return orgname;
	}
	public MyFile setOrgname(String orgname) {
		this.orgname = orgname;
		return this;
	}
	public String getSystemname() {
		return systemname;
	}
	public MyFile setSystemname(String systemname) {
		this.systemname = systemname;
		return this;
	}
	public String getContenttype() {
		return contenttype;
	}
	public MyFile setContenttype(String contenttype) {
		this.contenttype = contenttype;
		return this;
	}
	public long getSize() {
		return size;
	}
	public MyFile setSize(long size) {
		this.size = size;
		return this;
	}
	public String toString() {
		return "no: " + no + "boardno: "+ boardno + "path: " + path + "orgname: " + orgname + "systemname: " +
				systemname + "contenttype: " + contenttype + "size: " + size;
	}
}
