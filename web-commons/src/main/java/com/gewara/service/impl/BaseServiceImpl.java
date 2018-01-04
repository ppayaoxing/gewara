package com.gewara.service.impl;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.gewara.dao.Dao;
import com.gewara.service.BaseService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28锟斤拷锟斤拷02:05:17
 */
public class BaseServiceImpl implements BaseService{
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Autowired@Qualifier("baseDao")
	protected Dao baseDao;
	@Autowired@Qualifier("hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hbt) {
		hibernateTemplate = hbt;
	}
	
	@Autowired@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate template){
		jdbcTemplate = template;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setBaseDao(Dao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List queryByRowsRange(final String hql, final int from, final int maxnum, final Object... params){
		return hibernateTemplate.execute(new HibernateCallback<List>(){
			@Override
			public List doInHibernate(Session session) {
				Query query=session.createQuery(hql);
				query.setFirstResult(from).setMaxResults(maxnum);
				if(params != null) {
                    for (int i = 0, length = params.length; i < length; i++) {
                        query.setParameter(i, params[i]);
                    }
                }
				return query.list();
			}
		});
	}
	@Override
	public List queryByNameParams(final String hql, final int from, final int maxnum, final String paramnames, final Object... params){
		return hibernateTemplate.execute(new HibernateCallback<List>(){
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
}