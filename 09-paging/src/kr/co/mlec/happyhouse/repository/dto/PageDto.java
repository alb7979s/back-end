package kr.co.mlec.happyhouse.repository.dto;

public class PageDto {
	private int pageNo;
	// 목록의 개수가 페이징에 영향을 줄 수 있음
	private int listSize;
	
	public PageDto() {
		this(1, 10);
//		this.pageNo = 1;
//		this.listSize = 10;
	}
	
	public PageDto(int pageNo) {
		this(pageNo, 10);
//		this.pageNo = pageNo;
//		this.listSize = 10;
	}
	
	public PageDto(int pageNo, int listSize) {
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
	
	// 몇번 위치부터 가져올지 계산할거(잘 감이 안오면 그려서 계산해보면 됨)
	public int getBegin() {
		return listSize * (pageNo - 1);
	}
}
