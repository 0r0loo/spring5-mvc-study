package com.cho.beans;

public class PageBean {

	// 최소 페이지 번호
	private int min;
	
	// 최대 페이지 번호
	private int max;
	
	// 이전 버튼의 페이지 번호
	private int prevPage;
	
	// 다음 버튼의 페이지 번호
	private int nextPage;
	
	// 전체 페이지 갯수
	private int pageCnt;
	
	// 현재 페이지 번호
	private int currentPage;
	
	
	// contentCnt : 전체글 갯수, currentPage : 현재 글번호, contentPageCnt : 페이지당 글의 갯수, pagenationCnt : 페이지 버튼의 갯수
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int pagenationCnt) {
		super();
		// 현재 페이지 번호
		this.currentPage = currentPage;
		
		// 전체 페이지 갯수  ex) 533/10 -> 53이니까 3이남으니까 페이지 하나더추가해야됨
		pageCnt = contentCnt / contentPageCnt;
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		/*
		 * 1 ~ 10 : 1, 10  최소 최대
		 * 11 ~ 20 : 11, 20
		 * 21 ~ 30 : 21, 30
		 * 
		 * -1씩함
		 * 0 ~ 9 : 
		 * 10 ~ 19 :
		 * 20 ~ 29 :
		 */
		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		max = min + pagenationCnt -1;
		
		if(max > pageCnt) {
			max = pageCnt;
		}
		
		prevPage = min - 1;
		nextPage = max + 1;
		
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
		
		
		
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	
}
