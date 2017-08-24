package com.gewara.support;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**  只读数据源
 * @author sunder
 *
 */
public class ReadOnlyHibernateTemplate extends HibernateTemplate {
	private boolean allowCreate = true;

	private boolean alwaysUseNewSession = false;

	private boolean exposeNativeSession = false;

	private boolean checkWriteOperations = true;

	private boolean cacheQueries = false;

	private String queryCacheRegion;

	public ReadOnlyHibernateTemplate() {
	}

	public ReadOnlyHibernateTemplate(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
		afterPropertiesSet();
	}

	public ReadOnlyHibernateTemplate(SessionFactory sessionFactory, boolean allowCreate) {
		setSessionFactory(sessionFactory);
		setAllowCreate(allowCreate);
		afterPropertiesSet();
	}

	public boolean isAllowCreate() {
		return allowCreate;
	}

	public boolean isAlwaysUseNewSession() {
		return alwaysUseNewSession;
	}

	public boolean isExposeNativeSession() {
		return exposeNativeSession;
	}

	public boolean isCheckWriteOperations() {
		return checkWriteOperations;
	}

	public boolean isCacheQueries() {
		return cacheQueries;
	}

	public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	public int getFetchSize() {
		return fetchSize;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setAllowCreate(boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	public void setAlwaysUseNewSession(boolean alwaysUseNewSession) {
		this.alwaysUseNewSession = alwaysUseNewSession;
	}

	public void setExposeNativeSession(boolean exposeNativeSession) {
		this.exposeNativeSession = exposeNativeSession;
	}

	public void setCheckWriteOperations(boolean checkWriteOperations) {
		this.checkWriteOperations = checkWriteOperations;
	}

	public void setCacheQueries(boolean cacheQueries) {
		this.cacheQueries = cacheQueries;
	}

	public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	private int fetchSize = 0;

	private int maxResults = 0;

}
