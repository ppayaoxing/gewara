/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service.impl;

import com.gewara.service.ReadOnlyDaoService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class ReadOnlyDaoServiceImpl implements ReadOnlyDaoService {
	private HibernateTemplate hibernateTemplate;
	private HibernateTemplate readOnlyTemplate;
	private boolean readonly = true;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void setReadOnlyTemplate(HibernateTemplate readOnlyTemplate) {
		this.readOnlyTemplate = readOnlyTemplate;
	}

	public List findByHql(String queryString, Object... values) {
		return !this.readonly && this.hibernateTemplate != null
				? this.hibernateTemplate.find(queryString, values)
				: this.readOnlyTemplate.find(queryString, values);
	}

	public List findByCriteria(DetachedCriteria criteria) {
		return !this.readonly && this.hibernateTemplate != null
				? this.hibernateTemplate.findByCriteria(criteria)
				: this.readOnlyTemplate.findByCriteria(criteria);
	}

	public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return !this.readonly && this.hibernateTemplate != null
				? this.hibernateTemplate.findByCriteria(criteria, firstResult, maxResults)
				: this.readOnlyTemplate.findByCriteria(criteria, firstResult, maxResults);
	}

	public List queryByRowsRange(final String hql, final int from, final int maxnum, final Object... params) {
		HibernateTemplate template = this.readOnlyTemplate;
		if (!this.readonly && this.hibernateTemplate != null) {
			template = this.hibernateTemplate;
		}

		return (List) template.execute(new HibernateCallback() {
			public List doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				query.setFirstResult(from).setMaxResults(maxnum);
				if (params != null) {
					int i = 0;

					for (int length = params.length; i < length; ++i) {
						query.setParameter(i, params[i]);
					}
				}

				return query.list();
			}
		});
	}

	public List<Map<String, Object>> queryMapBySQL(final String sql, final int from, final int maxnum,
			final Object... params) {
		HibernateTemplate template = this.readOnlyTemplate;
		if (!this.readonly && this.hibernateTemplate != null) {
			template = this.hibernateTemplate;
		}

		List result = (List) template.execute(new HibernateCallback() {
			public List doInHibernate(Session session) {
				SQLQuery query = session.createSQLQuery(sql);
				query.setFirstResult(from).setMaxResults(maxnum).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				if (params != null) {
					int i = 0;

					for (int length = params.length; i < length; ++i) {
						query.setParameter(i, params[i]);
					}
				}

				return query.list();
			}
		});
		return result;
	}

	public List queryByNameParams(final String hql, final int from, final int maxnum, final String paramnames,
			final Object... params) {
		HibernateTemplate template = this.readOnlyTemplate;
		if (!this.readonly && this.hibernateTemplate != null) {
			template = this.hibernateTemplate;
		}

		return (List) template.execute(new HibernateCallback() {
			public List doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				query.setFirstResult(from).setMaxResults(maxnum);
				String[] names = StringUtils.split(paramnames, ",");
				int i = 0;

				for (int length = names.length; i < length; ++i) {
					if (params[i] instanceof Collection) {
						query.setParameterList(names[i], (Collection) params[i]);
					} else {
						query.setParameter(names[i], params[i]);
					}
				}

				return query.list();
			}
		});
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public boolean isReadOnly() {
		return this.readonly;
	}
}