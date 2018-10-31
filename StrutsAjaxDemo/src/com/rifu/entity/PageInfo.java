package com.rifu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 记录分页信息的实体类
 * 
 * @author Lifu
 *
 */
public class PageInfo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize;
	private int totalRecord;
	private int pageNum;
	private int totalPage;
	private boolean hasPrevious;
	private boolean hasNext;
	private List<Integer> navigatepageNums = new ArrayList<>();
	// 要显示的数据
	private List<T> dataList;

	public PageInfo(int pageSize, int pageNum, List<T> sourceList) {
		if (sourceList == null || sourceList.isEmpty())
			return;

		this.totalRecord = sourceList.size();
		this.pageSize = pageSize;
		this.totalPage = (totalRecord / this.pageSize) + 1;
		this.pageNum = pageNum;
		if (pageNum >= this.totalPage) {
			this.pageNum = this.totalPage;
		}
		if (pageNum <= 1) {
			this.pageNum = 1;
		}
		if (this.totalRecord % this.pageSize == 0) {
			this.totalPage--;
		}

		// 当要查询的页数大于总页数，即为查询最后一页
		//this.pageNum = this.totalPage < pageNum ? this.totalPage : pageNum;
		// 当要查询的页数小于0，即为查询第0页
		//this.pageNum = pageNum <= 1 ? 1 : pageNum;

		if (totalPage > 1)
			this.hasPrevious = pageNum <= 1 ? false : true;

		this.hasNext = pageNum >= this.totalPage ? false : true;

		navigatepageNums.clear();
		if (this.hasPrevious) {
			navigatepageNums.add(this.pageNum - 1);
		}
		;
		navigatepageNums.add(this.pageNum);
		if (this.hasNext) {
			navigatepageNums.add(this.pageNum + 1);
		}
		int startIndex = this.pageSize * (this.pageNum - 1);
		int endIndex = this.pageSize * (this.pageNum) > this.totalRecord ? this.totalRecord
				: this.pageSize * (this.pageNum);
		this.dataList = sourceList.subList(startIndex, endIndex);
	}

	public PageInfo(int pageSize, int totalRecord, int pageNum, int totalPage, List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.pageNum = pageNum;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<Integer> getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(List<Integer> navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", totalRecord=" + totalRecord + ", pageNum=" + pageNum
				+ ", totalPage=" + totalPage + ", hasPrevious=" + hasPrevious + ", hasNext=" + hasNext
				+ ", navigatepageNums=" + navigatepageNums + ", dataList=" + dataList + "]";
	}

}
