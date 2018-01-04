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

	@Override
    public boolean isAllowCreate() {
		return allowCreate;
	}

	@Override
    public boolean isAlwaysUseNewSession() {
		return alwaysUseNewSession;
	}

	@Override
    public boolean isExposeNativeSession() {
		return exposeNativeSession;
	}

	@Override
    public boolean isCheckWriteOperations() {
		return checkWriteOperations;
	}

	@Override
    public boolean isCacheQueries() {
		return cacheQueries;
	}

	@Override
    public String getQueryCacheRegion() {
		return queryCacheRegion;
	}

	@Override
    public int getFetchSize() {
		return fetchSize;
	}

	@Override
    public int getMaxResults() {
		return maxResults;
	}

	@Override
    public void setAllowCreate(boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	@Override
    public void setAlwaysUseNewSession(boolean alwaysUseNewSession) {
		this.alwaysUseNewSession = alwaysUseNewSession;
	}

	@Override
    public void setExposeNativeSession(boolean exposeNativeSession) {
		this.exposeNativeSession = exposeNativeSession;
	}

	@Override
    public void setCheckWriteOperations(boolean checkWriteOperations) {
		this.checkWriteOperations = checkWriteOperations;
	}

	@Override
    public void setCacheQueries(boolean cacheQueries) {
		this.cacheQueries = cacheQueries;
	}

	@Override
    public void setQueryCacheRegion(String queryCacheRegion) {
		this.queryCacheRegion = queryCacheRegion;
	}

	@Override
    public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}

	@Override
    public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	private int fetchSize = 0;

	private int maxResults = 0;

}
