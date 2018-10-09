package com.qf.entity;

import java.util.List;

public class Page<T> {

	private Integer currentPage = 1;
	
	private Integer pageSize=5;
	
	private Integer totalPage;
	
	private Integer totalCount;
	
	private List<T> data;
	
	private String url;// 记录serlvet路径

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		
		// 算出总页数
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = (totalCount / pageSize) + 1;
		}

	}


	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", data=" + getData() + "]";
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
