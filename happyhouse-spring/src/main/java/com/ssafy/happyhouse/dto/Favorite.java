// id, no, dong
// PK: (id)
// FK: id -> member(id), no -> houseDeal(no) 
package com.ssafy.happyhouse.dto;

public class Favorite {
	private String id;
	private int no;
	private String dong;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
}
