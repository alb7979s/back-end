package com.happyhouse.model;

public class PageResultDto {
	private int pageNo;
	private int count;
	private int listSize;
	private int blockSize;

	private int beginPage, endPage;
	private boolean prev, next;

	public PageResultDto(int pageNo, int count) {
		this(pageNo, count, 10, 10);
	}

	public PageResultDto(int pageNo, int count, int listSize) {
		this(pageNo, count, listSize, 10);
	}

	public PageResultDto(int pageNo, int count, int listSize, int blockSize) {
		this.pageNo = pageNo;
		this.count = count;
		this.listSize = listSize;
		this.blockSize = blockSize;

		calculator();
	}

	private void calculator() {
		int lastPage = (int) Math.ceil(count / (double) listSize);

		int currentBlock = (int) Math.ceil(pageNo / (double) blockSize);
		beginPage = (currentBlock - 1) * blockSize + 1;
		endPage = Math.min(currentBlock * blockSize, lastPage);

		// 이전 페이지와 다음 페이지 설정하기
		prev = beginPage != 1;
		next = endPage != lastPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getCount() {
		return count;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean getPrev() {
		return prev;
	}

	public boolean getNext() {
		return next;
	}

}
