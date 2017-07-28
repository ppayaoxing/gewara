/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service.impl;

import com.gewara.dao.Dao;
import com.gewara.service.BaseService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseServiceImpl implements BaseService {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired
	@Qualifier("baseDao")
	protected Dao baseDao;
	@Autowired
	@Qualifier("hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;
	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	public void setHibernateTemplate(HibernateTemplate hbt) {
		this.hibernateTemplate = hbt;
	}

	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setBaseDao(Dao baseDao) {
		this.baseDao = baseDao;
	}

	public List queryByRowsRange(final String hql, final int from, final int maxnum, final Object... params) {
		return (List) this.hibernateTemplate.execute(new HibernateCallback() {
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

	public List queryByNameParams(final String hql, final int from, final int maxnum, final String paramnames,
			final Object... params) {
		return (List) this.hibernateTemplate.execute(new HibernateCallback() {
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
}