package com.ssg.Jasmine.controller.book;

public class ListBookCriteria {
	private int page;
	private int perPageNum;
	
	public ListBookCriteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart()
	{
		return (this.page-1)*perPageNum;
	}
	
	public ListBookCriteria()
	{
		this.page = 1;
		this.perPageNum = 5;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) { this.page = 1;}
		else { this.page = page;}
	}
	
	
	// 페이지당 보여줄 게시글의 개수 perPageNum : getter, setter
		public int getPerPageNum() {
			return perPageNum;
		}

		public void setPerPageNum(int perPageNum) {
			int cnt = this.perPageNum;
			
			if(perPageNum != cnt) {
				this.perPageNum = cnt;	
			} else {
				this.perPageNum = perPageNum;
			}
			
		}
		
		@Override
		public String toString() {
			return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
		}
}