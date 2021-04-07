package kr.co.mlec.happyhouse.repository.dto;

public class PageResultDto {
	private int pageNo;
	private int count;
	private int listSize;
	private int blockSize;
	
	// 화면에서 직접 쓸 애들 멤버변수로 선언해줌
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
	
//	생각보다 별거 없는데 이런 구조를 뽑는게 어려운거래유 연습하기!!	
	private void calculator() {
		int lastPage = (int)Math.ceil(count / (double)listSize);
		
		// 데이터 공유는 controller가 할 일. 아래 같은거 지움
//		request.setAttribute("pageNo", pageDto.getPageNo());	
		
		// 화면 하단 페이지 블럭 구하기
		int currentBlock = (int) Math.ceil(pageNo / (double)blockSize);
		beginPage = (currentBlock - 1) * blockSize + 1;
		endPage = Math.min((currentBlock * blockSize), lastPage);	
		
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
	// boolean은 get대신 is로 접근!
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
}
