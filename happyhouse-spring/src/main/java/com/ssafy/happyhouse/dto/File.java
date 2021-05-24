package com.ssafy.happyhouse.dto;

public class File {
	private int no;
	private long size;
	private String id;
	private String path;
	private String orgname;
	private String systemname;
	private String contenttype;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getSystemname() {
		return systemname;
	}
	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String toString() {
		return "no: " + no + "id: " + id + "path: " + path + "orgname: " + orgname + "systemname: " +
				systemname + "contenttype: " + contenttype + "size: " + size;
	}
}
