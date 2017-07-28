/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service.impl;

import com.gewara.dao.Dao;
import com.gewara.model.BaseObject;
import com.gewara.service.DaoService;
import com.gewara.util.BeanUtil;
import com.gewara.util.ChangeEntry;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

public final class DaoServiceImpl implements DaoService {
	@Autowired
	@Qualifier("baseDao")
	private Dao baseDao;
	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public void setBaseDao(Dao baseDao) {
		this.baseDao = baseDao;
	}

	public void setHibernateTemplate(HibernateTemplate hbt) {
		this.hibernateTemplate = hbt;
	}

	public <T extends BaseObject> T saveObject(T entity) {
		return this.baseDao.saveObject(entity);
	}

	public <T extends BaseObject> T getObject(Class<T> clazz, Serializable id) {
		return this.baseDao.getObject(clazz, id);
	}

	public <T extends BaseObject> List<T> getAllObjects(Class<T> clazz) {
		return this.baseDao.getAllObjects(clazz);
	}

	public <T extends BaseObject> T removeObject(T entity) {
		return this.baseDao.removeObject(entity);
	}

	public <T extends BaseObject> T removeObjectById(Class<T> clazz, Serializable id) {
		BaseObject entity = this.baseDao.getObject(clazz, id);
		if (entity == null) {
			return null;
		} else {
			this.removeObject(entity);
			return entity;
		}
	}

	public <T extends BaseObject> int getObjectCount(Class<T> clazz) {
		return this.baseDao.getObjectCount(clazz);
	}

	public <T extends BaseObject> void removeObjectList(Collection<T> entityList) {
		this.baseDao.removeObjectList(entityList);
	}

	public <T extends BaseObject> void saveObjectList(Collection<T> entityList) {
		this.baseDao.saveObjectList(entityList);
	}

	public <T extends BaseObject> void addObjectList(Collection<T> entityList) {
		this.baseDao.addObjectList(entityList);
	}

	public <T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, Collection<S> idList) {
		return this.baseDao.getObjectList(clazz, idList);
	}

	public <T extends BaseObject> List<T> getObjectList(Class<T> clazz, String orderField, boolean asc, int from,
			int rows) {
		return this.baseDao.getObjectList(clazz, orderField, asc, from, rows);
	}

	public <T extends BaseObject> void saveObjectList(T... entityList) {
		BaseObject[] arg1 = entityList;
		int arg2 = entityList.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			BaseObject entity = arg1[arg3];
			if (entity != null) {
				this.baseDao.saveObject(entity);
			}
		}

	}

	public <T extends BaseObject, S extends Serializable> Map<S, T> getObjectMap(Class<T> clazz, Collection<S> idList) {
		HashMap result = new HashMap();
		Iterator arg3 = idList.iterator();

		while (arg3.hasNext()) {
			Serializable id = (Serializable) arg3.next();
			BaseObject obj = this.baseDao.getObject(clazz, id);
			if (obj != null) {
				result.put(id, obj);
			}
		}

		return result;
	}

	public <T extends BaseObject> Map getObjectPropertyMap(Class<T> clazz, String keyname, String valuename) {
		return this.baseDao.getObjectPropertyMap(clazz, keyname, valuename);
	}

	public <T extends BaseObject> T updateObject(T entity) {
		return this.baseDao.updateObject(entity);
	}

	public <T extends BaseObject> T addObject(T entity) {
		return this.baseDao.addObject(entity);
	}

	public <T extends BaseObject> T getObjectByUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue) {
		return this.baseDao.getObjectByUkey(clazz, ukeyName, ukeyValue);
	}

	public <T extends BaseObject, S extends Serializable> Map getObjectPropertyMap(Class<T> clazz, String keyname,
			String valuename, Collection<S> idList) {
		return this.baseDao.getObjectPropertyMap(clazz, keyname, valuename, idList);
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

	public <T extends BaseObject> List<T> getObjectListByField(Class<T> clazz, String fieldname,
			Serializable fieldvalue) {
		return this.baseDao.getObjectListByField(clazz, fieldname, fieldvalue);
	}

	public <T extends BaseObject> T addPropertyNum(Class<T> clazz, Serializable id, String property, Integer num) {
		BaseObject entity = this.baseDao.getObject(clazz, id);
		if (entity != null) {
			try {
				PropertyUtils.setProperty(entity, property, Integer
						.valueOf(((Integer) PropertyUtils.getProperty(entity, property)).intValue() + num.intValue()));
				this.baseDao.saveObject(entity);
			} catch (Exception arg6) {
				;
			}
		}

		return entity;
	}

	public <T extends BaseObject> void addPropertyNum(T entity, String property, Integer num) {
		this.hibernateTemplate.refresh(entity);
		if (entity != null) {
			try {
				PropertyUtils.setProperty(entity, property, Integer
						.valueOf(((Integer) PropertyUtils.getProperty(entity, property)).intValue() + num.intValue()));
				this.baseDao.saveObject(entity);
			} catch (Exception arg4) {
				;
			}
		}

	}

	public <T extends BaseObject> T addPropertiesNum(Class<T> clazz, Serializable id, String properties,
			Integer... nums) {
		BaseObject entity = this.baseDao.getObject(clazz, id);
		if (entity != null) {
			String[] propertyList = StringUtils.split(properties, ",");
			this.addPropertiesNum(entity, propertyList, nums);
		}

		return entity;
	}

	public <T extends BaseObject> void addPropertiesNum(T entity, String properties, Integer... nums) {
		if (entity != null) {
			this.hibernateTemplate.refresh(entity);
			String[] propertyList = StringUtils.split(properties, ",");
			this.addPropertiesNum(entity, propertyList, nums);
		}

	}

	private <T extends BaseObject> void addPropertiesNum(T entity, String[] propertyList, Integer[] values) {
		if (propertyList.length != 0 && values != null && propertyList.length == values.length) {
			int i = 0;
			String[] arg4 = propertyList;
			int arg5 = propertyList.length;

			for (int arg6 = 0; arg6 < arg5; ++arg6) {
				String property = arg4[arg6];

				try {
					PropertyUtils.setProperty(entity, property, Integer.valueOf(
							((Integer) PropertyUtils.getProperty(entity, property)).intValue() + values[i].intValue()));
				} catch (Exception arg9) {
					;
				}

				++i;
			}

			this.baseDao.saveObject(entity);
		}
	}

	public <T extends BaseObject> T updateProperties(Class<T> clazz, Serializable id, String properties,
			Serializable... values) {
		BaseObject entity = this.baseDao.getObject(clazz, id);
		String[] propertyList = properties.split(",");
		this.updateProperties(entity, propertyList, values);
		return entity;
	}

	public <T extends BaseObject> void updateProperties(T entity, String properties, Serializable... values) {
		if (entity != null) {
			this.hibernateTemplate.refresh(entity);
			String[] propertyList = properties.split(",");
			this.updateProperties(entity, propertyList, values);
		}

	}

	private <T extends BaseObject> void updateProperties(T entity, String[] propertyList, Serializable... values) {
		if (propertyList.length != 0 && values != null && propertyList.length == values.length) {
			int i = 0;
			String[] arg4 = propertyList;
			int arg5 = propertyList.length;

			for (int arg6 = 0; arg6 < arg5; ++arg6) {
				String property = arg4[arg6];

				try {
					PropertyUtils.setProperty(entity, property, values[i]);
				} catch (Exception arg9) {
					;
				}

				++i;
			}

			this.baseDao.saveObject(entity);
		}
	}

	public <T extends BaseObject> int updateProperties2(T entity, String properties, Serializable... values) {
		if (entity != null) {
			this.hibernateTemplate.refresh(entity);
			String[] propertyList = properties.split(",");
			return this.updateProperties2(entity, propertyList, values);
		} else {
			return 0;
		}
	}

	private <T extends BaseObject> int updateProperties2(T entity, String[] propertyList, Serializable... values) {
		if (propertyList.length != 0 && values != null && propertyList.length == values.length) {
			int i = 0;
			ChangeEntry changeEntry = new ChangeEntry(entity);
			String[] changeMap = propertyList;
			int arg6 = propertyList.length;

			for (int arg7 = 0; arg7 < arg6; ++arg7) {
				String property = changeMap[arg7];

				try {
					PropertyUtils.setProperty(entity, property, values[i]);
				} catch (Exception arg10) {
					;
				}

				++i;
			}

			this.baseDao.saveObject(entity);
			Map arg11 = changeEntry.getChangeMap(entity);
			return arg11.size();
		} else {
			return 0;
		}
	}

	public <T extends BaseObject, S extends Serializable> List<S> getObjectPropertyList(Class<T> clazz,
			String propertyname, boolean isDistinct) {
		return this.baseDao.getObjectPropertyList(clazz, propertyname, isDistinct);
	}

	public <T extends BaseObject, S extends Serializable> S getObjectPropertyByUkey(Class<T> clazz, String ukeyname,
			Serializable ukeyvalue, String propertyname) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyname, ukeyvalue));
		query.setProjection(Projections.property(propertyname));
		List result = this.hibernateTemplate.findByCriteria(query);
		return result.isEmpty() ? null : (Serializable) result.get(0);
	}

	public List<Map<String, Object>> queryMapBySQL(final String sql, final int from, final int maxnum,
			final Object... params) {
		List result = (List) this.hibernateTemplate.execute(new HibernateCallback() {
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

	public <T extends BaseObject> Object getObjectProperty(Class<T> clazz, Serializable id, String propertyname) {
		BaseObject entity = this.baseDao.getObject(clazz, id);
		return entity == null ? null : BeanUtil.get(entity, propertyname);
	}

	public <T extends BaseObject, S extends Serializable> List<T> getObjectBatch(Class<T> clazz, String propertyName,
			Collection<S> valueList) {
		return this.baseDao.getObjectBatch(clazz, propertyName, valueList);
	}

	public <T extends BaseObject> void refreshUpdateProperty(T entity, String property, Object value) {
		this.baseDao.refreshUpdateProperty(entity, property, value);
	}

	public List findByCriteria(DetachedCriteria query) {
		return this.baseDao.findByCriteria(query);
	}

	public List findByCriteria(DetachedCriteria query, int from, int maxnum) {
		return this.baseDao.findByCriteria(query, from, maxnum);
	}

	public List findByHql(String hql, Object... values) {
		return this.baseDao.findByHql(hql, values);
	}

	public Map<Class, String> getEntityIdNameMap() {
		return this.baseDao.getIdNameMap();
	}
}