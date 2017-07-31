package com.gewara.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.gewara.service.ReadOnlyDaoService;

public class ReadOnlyDaoServiceImpl implements ReadOnlyDaoService {
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	private HibernateTemplate readOnlyTemplate;
	public void setReadOnlyTemplate(HibernateTemplate readOnlyTemplate) {
		this.readOnlyTemplate = readOnlyTemplate;
	}
	private boolean readonly = true;

	@Override
	public List findByHql(String queryString, Object... values) {
		if(readonly || hibernateTemplate==null){
			return readOnlyTemplate.find(queryString, values);
		}else{
			return hibernateTemplate.find(queryString, values);
		}
	}
	@Override
	public List findByCriteria(DetachedCriteria criteria) {
		if(readonly || hibernateTemplate==null){
			return readOnlyTemplate.findByCriteria(criteria);
		}else{
			return hibernateTemplate.findByCriteria(criteria);
		}
	}
	@Override
	public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		if(readonly || hibernateTemplate==null){
			return readOnlyTemplate.findByCriteria(criteria, firstResult, maxResults);
		}else{
			return hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
		}
	}
	@Override
	public List queryByRowsRange(final String hql, final int from, final int maxnum, final Object... params){
		HibernateTemplate template = readOnlyTemplate;
		if(!readonly && hibernateTemplate!=null){
			template = hibernateTemplate;
		}

		return template.execute(new HibernateCallback<List>(){
			@Override
			public List doInHibernate(Session session) {
				Query query=session.createQuery(hql);
				query.setFirstResult(from).setMaxResults(maxnum);
				if(params != null)
					for (int i = 0,length=params.length; i < length; i++) {
						query.setParameter(i, params[i]);
					}
				return query.list();
			}
		});
	}
	@Override
	public List<Map<String, Object>> queryMapBySQL(final String sql, final int from,
			final int maxnum,final  Object... params) {
		HibernateTemplate template = readOnlyTemplate;
		if(!readonly && hibernateTemplate!=null){
			template = hibernateTemplate;
		}
		List result = template.execute(new HibernateCallback<List>(){
			@Override
			public List doInHibernate(Session session) {
				Query query=session.createSQLQuery(sql);
				query.setFirstResult(from).setMaxResults(maxnum).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				if(params != null)
					for (int i = 0,length=params.length; i < length; i++) {
						query.setParameter(i, params[i]);
					}
				return query.list();
			}
		});
		return result;
	}
	@Override
	public List queryByNameParams(final String hql, final int from, final int maxnum, final String paramnames, final Object... params){
		HibernateTemplate template = readOnlyTemplate;
		if(!readonly && hibernateTemplate!=null){
			template = hibernateTemplate;
		}
		return template.execute(new HibernateCallback<List>(){
			@Override
			public List doInHibernate(Session session) {
				Query query=session.createQuery(hql);
				query.setFirstResult(from).setMaxResults(maxnum);
				String[] names = StringUtils.split(paramnames, ",");
				for (int i=0,length=names.length; i < length; i++) {
					if(params[i] instanceof Collection){
						query.setParameterList(names[i], (Collection)params[i]);
					}else{
						query.setParameter(names[i], params[i]);
					}
				}
				return query.list();
			}
		});
	}
	@Override
	public void setReadonly(boolean readonly) {
		this.readonly  = readonly;
	}
	@Override
	public boolean isReadOnly() {
		return readonly;
	}

}
