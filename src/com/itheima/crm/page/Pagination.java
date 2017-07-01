package com.itheima.crm.page;

import java.util.List;
import java.util.Map;

public class Pagination<T> {
	//当前页
	private int page=1;
	
	//每页行数
	private int pageSize=2;
	//总页数
	private Long totalPage;
	//总行数
	private Long totalCount;
	//每页显示的数据
	private List<T> resultList;
	
	private Map<String, String[]> parameterMap;
	
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}
	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}
	//每页数据的起始条数
	public int getFirstResult(){
		int firstResult=(page-1)*pageSize;
		return firstResult;
	}
	//每页数据的最后条数
	public int getMaxResults(){
		return pageSize;
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		this.totalPage=(totalCount+pageSize-1)/pageSize;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	@Override
	public String toString() {
		return "Pagination [page=" + page + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", totalCount="
				+ totalCount + ", resultList=" + resultList + "]";
	}
	
	
	
}
