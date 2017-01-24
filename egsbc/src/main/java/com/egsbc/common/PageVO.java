package com.egsbc.common;

public class PageVO extends IPCMsgVO {
	private int page; 			// current page number *
	private int pageSize;		// row length per page *
	private int pageLength=10;	// display page number
	private int totalPages;		// total pages 
	private int totalRows;		// total rows *
	private int pageStart;
	private int pageEnd;
	private int offset;			// start index


	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageLength() {
		return pageLength;
 	}
	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		
		this.totalPages = ((this.totalRows % pageSize) != 0) ? totalRows / pageSize +1 : totalRows / pageSize;
		
		// start page number
		if(this.page % this.pageLength == 0) {
			this.pageStart = this.page - this.pageLength + 1;
		}else{
			this.pageStart = (this.page - (this.page % this.pageLength)) + 1;
		}
		
		// end page number
		if(this.page % this.pageLength == 0) {
			this.pageEnd = this.page;
		}else{
			this.pageEnd = this.page - (this.page % this.pageLength) + this.pageLength;
		}
		if(this.pageEnd > this.totalPages){
			this.pageEnd = this.totalPages;
		}
		
	}
	public int getOffset() {
		return (this.page - 1) * this.pageSize;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
