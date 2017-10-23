package com.mxh.weibo.web.response;

import java.io.Serializable;

public class ResponsePageVo implements Serializable {
	private static final long serialVersionUID = 5220691960214651467L;

	private Integer total;
	private Integer pageCount;
	private Integer page;
	private Integer pageSize;
	private Object rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

}
