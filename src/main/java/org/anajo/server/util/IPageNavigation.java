package org.anajo.server.util;

import java.util.List;
import java.util.Map;

public interface IPageNavigation {

	public int getCurrPage();

	public int getStartRow();

	public int getEndRow();

	public int getRowSize();

	public int getPageSize();

	public List<?> getList();

	public void addList(List<?> list);

	public void setList(List<?> list);

	public void setTotalRow(int totalRow);

	public Map<String, Object> getEqCondition();

	public void setEqCondition(String key, Object value);

	public void setEqConditionAll(Map<String, Object> condition);

	public Map<String, Object> getLikeCondition();

	public void setLikeCondition(String key, Object value);

	public void setLikeConditionAll(Map<String, Object> condition);

	public Map<String, Object> getInCondition();

	public void setInCondition(String key, Object value);

	public void setInConditionAll(Map<String, Object> condition);

	public Map<String, Object> getBetweenCondition();

	public void setBetweenCondition(String key, Object lo, Object hi);

	public void setBetweenCondition(Map<String, Object> condition);

	public void setNeCondition(String key, Object value);

	public void setNeConditionAll(Map<String, Object> condition);

	public Map<String, Object> getNeCondition();

}
