package com.ssafy.happyhouse.dto;

public class Page {
	private int pageNo;
	private int listSize; // 한페이지에 보여줄 목록의 개수

	public Page() {
		this(1, 10);
//		this.pageNo = 1;
//		this.listSize = 10;
	}

	public Page(int pageNo) {
		this(pageNo, 10);
//		this.pageNo = pageNo;
//		this.listSize = 10;
	}

	public Page(int pageNo, int listSize) {
		this.pageNo = pageNo;
		this.listSize = listSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getBegin() {
		return listSize * (pageNo - 1);
	}
}
