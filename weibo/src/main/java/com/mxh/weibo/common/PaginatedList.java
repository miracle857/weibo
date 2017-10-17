package com.mxh.weibo.common;

import java.io.Serializable;
import java.util.List;

public class PaginatedList<T> implements Serializable {

	private static final long serialVersionUID = -2582060677791599460L;

	/**
	 * 分页结果集
	 */
	private List<T> result;

	/**
	 * 分页信息
	 */
	private Pagination pagination;

	/**
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * @param pagination
	 *            the pagination to set
	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "PaginatedList{" +
				"result=" + result +
				", pagination=" + pagination +
				'}';
	}
}
