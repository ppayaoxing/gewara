package com.gewara.service;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
public interface ReadOnlyDaoService {
	List findByCriteria(DetachedCriteria criteria);
	List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);
	List findByHql(String queryString, Object... values);
	List<Map<String, Object>> queryMapBySQL(String sql, int from, int maxnum, Object... params);
	List queryByRowsRange(final String hql, final int from, final int maxnum, final Object... params);
	List queryByNameParams(final String hql, final int from, final int maxnum, final String paramnames, final Object... params);
	/**
	 * ¿ªÆô»ò¹Ø±ÕreadOnly
	 * @param readonly
	 * @return
	 */
	void setReadonly(boolean readonly);
	boolean isReadOnly();
}
