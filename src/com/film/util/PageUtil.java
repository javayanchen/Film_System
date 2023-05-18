package com.film.util;

import java.util.List;

/**
 * @author lzl
 * @version 1.0
 * @description: 自定义泛型类
 * @date 2023/5/4 9:31
 */
public class PageUtil<T> {
	// 当前页码
	private int currentPage;
	// 页大小
	private int pageSize;
	// 总行数
	private int totalCount;
	// 总页数
	private int totalPageCount;
	// 当前页数据
	private List<T> pageList;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
}
