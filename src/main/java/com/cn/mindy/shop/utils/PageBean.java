package com.cn.mindy.shop.utils;

import java.util.List;

/**
 * 分页bean
 * @author Mindy
 *
 * @param <T>
 */
public class PageBean<T> {
	
	private int page;        //当前页数
	
	private int limit;       //每页显示的数据数
	
	private int totalCount;  //总记录数
	
	private int totalPage;  //总页数
	
	List<T> list;            //每页数据集合
	
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
	
}
