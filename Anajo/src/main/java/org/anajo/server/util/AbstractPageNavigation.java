package org.anajo.server.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPageNavigation implements IPageNavigation {

	private int rowSize;

	private int pageSize;

	private int totalRow;

	private int currPage;

	private List<Object> list = new ArrayList<Object>();

	private final Map<String, Object> eqCondition = new HashMap<String, Object>();

	private final Map<String, Object> neCondition = new HashMap<String, Object>();

	private final Map<String, Object> likeCondition = new HashMap<String, Object>();

	private final Map<String, Object> inCondition = new HashMap<String, Object>();

	private final Map<String, Object> betweenCondition = new HashMap<String, Object>();

	public AbstractPageNavigation() {
		this(10, 10, 1, 0);
	}

	public AbstractPageNavigation(int currPage) {
		this(10, 10, currPage);
	}

	public AbstractPageNavigation(int rowSize, int currPage) {
		this(rowSize, 10, currPage);
	}

	public AbstractPageNavigation(int rowSize, int pageSize, int currPage) {
		this(rowSize, pageSize, currPage, 0);
	}

	public AbstractPageNavigation(int rowSize, int pageSize, int currPage,
			int totalRow) {
		this.rowSize = rowSize;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalRow = totalRow;
	}

	public int getTotalPage() {
		return (this.totalRow - 1) / this.rowSize + 1;
	}

	public int getStartPage() {
		return (this.currPage - 1) / this.pageSize * this.pageSize + 1;
	}

	public int getEndPage() {
		int endPage = getStartPage() + this.pageSize - 1;
		return getTotalPage() < endPage ? getTotalPage() : endPage;
	}

	public int getStartRow() {
		return this.currPage * this.rowSize - this.rowSize;
	}

	public int getEndRow() {
		return this.currPage * this.rowSize;
	}

	public boolean isPrev() {
		return getStartPage() != 1 ? true : false;
	}

	public boolean isNext() {
		return getEndPage() < getTotalPage() ? true : false;
	}

	public int getPrev() {
		return (this.currPage - this.rowSize) / this.rowSize * this.pageSize
				+ 1;
	}

	public int getNext() {
		return (this.currPage + this.rowSize) / this.rowSize * this.pageSize
				+ 1;
	}

	public boolean isFirst() {
		return this.currPage != 1 ? true : false;
	}

	public boolean isLast() {
		return this.currPage != getTotalPage() ? true : false;
	}

	public int getPrevPage() {
		return this.currPage - 1;
	}

	public int getNextPage() {
		return this.currPage + 1;
	}

	public int getRowNum() {
		return this.totalRow - (this.rowSize * (getCurrPage() - 1));
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void addList(List<?> value) {
		list.addAll(value);
	}

	@SuppressWarnings("unchecked")
	public void setList(List<?> value) {
		this.list = (List<Object>) value;
	}

	public List<?> getList() {
		return this.list;
	}

	public int size() {
		return this.list.size();
	}

	public void setEqCondition(String key, Object value) {
		this.eqCondition.put(key, value);
	}

	public void setEqConditionAll(Map<String, Object> condition) {
		this.eqCondition.putAll(condition);
	}

	public Map<String, Object> getEqCondition() {
		return Collections.unmodifiableMap(this.eqCondition);
	}

	public void setLikeCondition(String key, Object value) {
		this.likeCondition.put(key, value);
	}

	public void setLikeConditionAll(Map<String, Object> condition) {
		this.likeCondition.putAll(condition);
	}

	public Map<String, Object> getLikeCondition() {
		return Collections.unmodifiableMap(this.likeCondition);
	}

	public void setInCondition(String key, Object value) {
		this.inCondition.put(key, value);
	}

	public void setInConditionAll(Map<String, Object> condition) {
		this.inCondition.putAll(condition);
	}

	public Map<String, Object> getInCondition() {
		return Collections.unmodifiableMap(this.inCondition);
	}

	public Map<String, Object> getBetweenCondition() {
		return Collections.unmodifiableMap(this.betweenCondition);
	}

	public void setBetweenCondition(String key, Object lo, Object hi) {
		Map<String, Object> value = new HashMap<String, Object>();
		value.put("lo", lo);
		value.put("hi", hi);

		this.betweenCondition.put(key, value);
	}

	public void setBetweenCondition(Map<String, Object> condition) {
		this.betweenCondition.putAll(condition);
	}

	public void setNeCondition(String key, Object value) {
		this.neCondition.put(key, value);
	}

	public void setNeConditionAll(Map<String, Object> condition) {
		this.neCondition.putAll(condition);
	}

	public Map<String, Object> getNeCondition() {
		return Collections.unmodifiableMap(this.neCondition);
	}

	public abstract String getNavi();
}
