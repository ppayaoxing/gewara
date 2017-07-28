/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.dao.impl;

import com.gewara.dao.Dao;
import com.gewara.model.BaseObject;
import com.gewara.support.StaleLocalObjectException;
import com.gewara.support.TraceErrorException;
import com.gewara.util.BeanUtil;
import com.gewara.util.Gcache;
import com.google.common.cache.CacheStats;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.list.UnmodifiableList;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseDaoHibernate implements Dao, InitializingBean {
	private Set<Class> cachable = new HashSet();
	private Map<Class, String> idNameMap = new HashMap();
	private Map<Class, Gcache<String, Serializable>> cachedUkeyMap = new HashMap();
	private List<Class> entityClassList = new ArrayList();
	@Autowired
	@Qualifier("hibernateTemplate")
	protected HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public <T extends BaseObject> T saveObject(T entity) {
		if (entity != null) {
			if (entity.cachable() && entity.fromCache()) {
				throw new StaleLocalObjectException();
			}

			this.hibernateTemplate.saveOrUpdate(entity);
		}

		return entity;
	}

	public <T extends BaseObject> T getObject(Class<T> clazz, Serializable id) {
		if (id != null && clazz != null) {
			BaseObject o = (BaseObject) this.hibernateTemplate.get(clazz, id);
			return o;
		} else {
			return null;
		}
	}

	public <T extends BaseObject> List<T> getAllObjects(Class<T> clazz) {
		if (clazz == null) {
			return null;
		} else if (this.cachable.contains(clazz)) {
			DetachedCriteria result1 = DetachedCriteria.forClass(clazz);
			result1.setProjection(Projections.id());
			List idList = this.hibernateTemplate.findByCriteria(result1);
			return this.getObjectList(clazz, idList);
		} else {
			List result = this.hibernateTemplate.loadAll(clazz);
			return result;
		}
	}

	public <T extends BaseObject> T removeObject(Class<T> clazz, Serializable id) {
		if (id != null && clazz != null) {
			BaseObject o = this.getObject(clazz, id);
			if (o != null) {
				this.hibernateTemplate.delete(o);
			}

			return o;
		} else {
			return null;
		}
	}

	public <T extends BaseObject> T removeObject(T entity) {
		if (entity != null) {
			this.hibernateTemplate.delete(entity);
		}

		return entity;
	}

	public <T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, Collection<S> idList) {
		return (List) (idList != null && !idList.isEmpty() ? (this.cachable.contains(clazz)
				? this.getObjectListUsingCache(clazz, idList)
				: this.getObjectBatch(clazz, (String) this.idNameMap.get(clazz), idList)) : new ArrayList(0));
	}

	private <T extends BaseObject, S extends Serializable> List<T> getObjectListUsingCache(Class<T> clazz,
			Collection<S> idList) {
		ArrayList result = new ArrayList();
		BaseObject obj = null;
		long t = System.currentTimeMillis();
		int count = 0;
		Iterator arg7 = idList.iterator();

		do {
			if (!arg7.hasNext()) {
				return result;
			}

			Serializable id = (Serializable) arg7.next();
			obj = this.getObject(clazz, id);
			if (obj != null) {
				result.add(obj);
			}

			++count;
		} while (System.currentTimeMillis() - t <= 120000L || count >= 100);

		throw new TraceErrorException("cache too slow!!");
	}

	public <T extends BaseObject, S extends Serializable> List<T> getObjectBatch(Class<T> clazz, String propertyName,
			Collection<S> valueList) {
		Object vlist = null;
		if (valueList instanceof List) {
			vlist = (List) valueList;
		} else {
			vlist = new ArrayList(valueList);
		}

		List groupList = BeanUtil.partition((List) vlist, 500);
		ArrayList result = new ArrayList();
		Iterator arg6 = groupList.iterator();

		while (arg6.hasNext()) {
			List group = (List) arg6.next();
			DetachedCriteria query = DetachedCriteria.forClass(clazz);
			query.add(Restrictions.in(propertyName, group));
			List rows = this.hibernateTemplate.findByCriteria(query);
			result.addAll(rows);
		}

		return result;
	}

	public <T extends BaseObject> void removeObjectList(Collection<T> entityList) {
		Iterator arg1 = entityList.iterator();

		while (arg1.hasNext()) {
			BaseObject entity = (BaseObject) arg1.next();
			if (entity != null) {
				this.removeObject(entity);
			}
		}

	}

	public <T extends BaseObject> void saveObjectList(Collection<T> entityList) {
		Iterator arg1 = entityList.iterator();

		while (arg1.hasNext()) {
			BaseObject entity = (BaseObject) arg1.next();
			if (entity != null) {
				this.saveObject(entity);
			}
		}

	}

	public <T extends BaseObject> void updateObjectList(Collection<T> entityList) {
		Iterator arg1 = entityList.iterator();

		while (arg1.hasNext()) {
			BaseObject entity = (BaseObject) arg1.next();
			if (entity != null) {
				this.hibernateTemplate.update(entity);
			}
		}

	}

	public <T extends BaseObject> int getObjectCount(Class<T> clazz) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.setProjection(Projections.rowCount());
		List result = this.hibernateTemplate.findByCriteria(query);
		return result.isEmpty() ? 0 : Integer.parseInt("" + result.get(0));
	}

	public <T extends BaseObject> T removeObjectById(Class<T> clazz, Serializable id) {
		BaseObject entity = this.getObject(clazz, id);
		if (entity == null) {
			return null;
		} else {
			this.removeObject(entity);
			return entity;
		}
	}

	public <T extends BaseObject> T updateObject(T entity) {
		if (entity.cachable() && entity.fromCache()) {
			throw new StaleLocalObjectException();
		} else {
			this.hibernateTemplate.update(entity);
			return entity;
		}
	}

	public <T extends BaseObject> T addObject(T entity) {
		if (entity.cachable() && entity.fromCache()) {
			throw new StaleLocalObjectException();
		} else {
			this.hibernateTemplate.save(entity);
			return entity;
		}
	}

	public <T extends BaseObject> void addObjectList(Collection<T> entityList) {
		Iterator arg1 = entityList.iterator();

		while (arg1.hasNext()) {
			BaseObject entity = (BaseObject) arg1.next();
			if (entity != null) {
				this.addObject(entity);
			}
		}

	}

	public <T extends BaseObject> List<T> getObjectList(Class<T> clazz, String orderField, boolean asc, int from,
			int rows) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		if (asc) {
			query.addOrder(Order.asc(orderField));
		} else {
			query.addOrder(Order.desc(orderField));
		}

		List result = this.hibernateTemplate.findByCriteria(query, from, rows);
		return result;
	}

	public <T extends BaseObject> void saveObjectList(T... entityList) {
		BaseObject[] arg1 = entityList;
		int arg2 = entityList.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			BaseObject entity = arg1[arg3];
			if (entity != null) {
				this.saveObject(entity);
			}
		}

	}

	public <T extends BaseObject> Map getObjectPropertyMap(Class<T> clazz, String keyname, String valuename) {
		HashMap result = new HashMap();
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.setProjection(Projections.projectionList().add(Projections.property(keyname), keyname)
				.add(Projections.property(valuename), valuename));
		query.setResultTransformer(DetachedCriteria.ALIAS_TO_ENTITY_MAP);
		List entryList = this.hibernateTemplate.findByCriteria(query);
		Iterator arg6 = entryList.iterator();

		while (arg6.hasNext()) {
			Object entry = arg6.next();
			result.put(((Map) entry).get(keyname), ((Map) entry).get(valuename));
		}

		return result;
	}

	public <T extends BaseObject, S extends Serializable> Map getObjectPropertyMap(Class<T> clazz, String keyname,
			String valuename, Collection<S> idList) {
		HashMap result = new HashMap();
		Iterator arg5 = idList.iterator();

		while (arg5.hasNext()) {
			Serializable id = (Serializable) arg5.next();
			BaseObject entity = this.getObject(clazz, id);
			if (entity != null) {
				result.put(BeanUtil.get(entity, keyname), BeanUtil.get(entity, valuename));
			}
		}

		return result;
	}

	public <T extends BaseObject> List<T> getObjectListByField(Class<T> clazz, String fieldname,
			Serializable fieldvalue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(fieldname, fieldvalue));
		List result;
		if (this.cachable.contains(clazz)) {
			query.setProjection(Projections.id());
			result = this.hibernateTemplate.findByCriteria(query);
			return this.getObjectListUsingCache(clazz, result);
		} else {
			result = this.hibernateTemplate.findByCriteria(query);
			return result;
		}
	}

	public <T extends BaseObject, S extends Serializable> List<S> getObjectPropertyList(Class<T> clazz,
			String propertyname) {
		return this.getObjectPropertyList(clazz, propertyname, false);
	}

	public <T extends BaseObject, S extends Serializable> List<S> getObjectPropertyList(Class<T> clazz,
			String propertyname, boolean isDistinct) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		if (isDistinct) {
			query.setProjection(Projections.distinct(Projections.property(propertyname)));
		} else {
			query.setProjection(Projections.property(propertyname));
		}

		List result = this.hibernateTemplate.findByCriteria(query);
		return result;
	}

	private <T extends BaseObject> T getByUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyName, ukeyValue));
		List result = this.hibernateTemplate.findByCriteria(query);
		if (result.isEmpty()) {
			return null;
		} else if (result.size() > 1) {
			throw new IllegalStateException(
					"查询出多个记录：" + clazz.getName() + ", ukey=" + ukeyName + ", value=" + ukeyValue);
		} else {
			return (BaseObject) result.get(0);
		}
	}

	public <T extends BaseObject> T getObjectByUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue) {
		boolean cache = this.cachable.contains(clazz);
		if (!cache) {
			return this.getByUkey(clazz, ukeyName, ukeyValue);
		} else {
			Serializable id = this.getUkey(clazz, ukeyName, ukeyValue);
			BaseObject result = null;
			if (id == null) {
				id = this.getIdByUkey(clazz, ukeyName, ukeyValue);
				if (id != null) {
					result = this.getObject(clazz, id);
					this.setUkey(clazz, ukeyName, ukeyValue, id);
				}
			} else {
				result = this.getObject(clazz, id);
				if (result == null) {
					id = this.getIdByUkey(clazz, ukeyName, ukeyValue);
					if (id != null) {
						this.setUkey(clazz, ukeyName, ukeyValue, id);
						result = this.getObject(clazz, id);
					} else {
						this.setUkey(clazz, ukeyName, ukeyValue, (Serializable) null);
					}
				}
			}

			return result;
		}
	}

	private <T extends BaseObject> Serializable getIdByUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyName, ukeyValue));
		query.setProjection(Projections.id());
		List result = this.hibernateTemplate.findByCriteria(query);
		if (result.isEmpty()) {
			return null;
		} else if (result.size() > 1) {
			throw new IllegalStateException(
					"查询出多个记录：" + clazz.getName() + ", ukey=" + ukeyName + ", value=" + ukeyValue);
		} else {
			return (Serializable) result.get(0);
		}
	}

	public void afterPropertiesSet() throws Exception {
		Map allData = this.hibernateTemplate.getSessionFactory().getAllClassMetadata();
		Iterator arg1 = allData.keySet().iterator();

		while (arg1.hasNext()) {
			String key = (String) arg1.next();
			AbstractEntityPersister persister = (AbstractEntityPersister) allData.get(key);
			Class clazz = persister.getMappedClass();
			EntityRegionAccessStrategy cas = persister.getCacheAccessStrategy();
			if (cas != null) {
				this.cachable.add(clazz);
				Gcache pname = new Gcache(500000L);
				this.cachedUkeyMap.put(clazz, pname);
			}

			String pname1 = persister.getIdentifierPropertyName();
			this.idNameMap.put(clazz, pname1);
		}

		this.entityClassList = UnmodifiableList.decorate(new ArrayList(this.idNameMap.keySet()));
	}

	public <T extends BaseObject> void refreshUpdateProperty(T entity, String property, Object value) {
		this.hibernateTemplate.refresh(entity);
		BeanUtil.set(entity, property, value);
		this.hibernateTemplate.update(entity);
	}

	public <T extends BaseObject> Serializable getUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue) {
		Gcache ukeyCache = (Gcache) this.cachedUkeyMap.get(clazz);
		if (ukeyCache != null) {
			Serializable idvalue = (Serializable) ukeyCache.getIfPresent(ukeyName + "_" + ukeyValue);
			if (idvalue != null) {
				return idvalue;
			}
		}

		return null;
	}

	public <T extends BaseObject> void setUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue,
			Serializable id) {
		Gcache ukeyCache = (Gcache) this.cachedUkeyMap.get(clazz);
		if (ukeyCache != null) {
			if (id != null) {
				ukeyCache.put(ukeyName + "_" + ukeyValue, id);
			} else {
				ukeyCache.invalidate(ukeyName + "_" + ukeyValue);
			}
		}

	}

	public List<Map> getUkeyCacheStats() {
		ArrayList result = new ArrayList(this.cachedUkeyMap.size());
		Iterator arg1 = this.cachedUkeyMap.keySet().iterator();

		while (arg1.hasNext()) {
			Class key = (Class) arg1.next();
			Gcache ukeyCache = (Gcache) this.cachedUkeyMap.get(key);
			CacheStats stats = ukeyCache.getStartCacheStats();
			if (ukeyCache.size() > 0L) {
				LinkedHashMap statsMap = new LinkedHashMap();
				statsMap.put("size", "" + ukeyCache.size());
				statsMap.put("hits", "" + stats.hitCount());
				statsMap.put("miss", "" + stats.missCount());
				statsMap.put("evicted", "" + stats.evictionCount());
				statsMap.put("class", key.getCanonicalName());
				result.add(statsMap);
			}
		}

		return result;
	}

	public List findByCriteria(DetachedCriteria query) {
		return this.hibernateTemplate.findByCriteria(query);
	}

	public List findByCriteria(DetachedCriteria query, int from, int maxnum) {
		return this.hibernateTemplate.findByCriteria(query, from, maxnum);
	}

	public List findByHql(String hql, Object... values) {
		return this.hibernateTemplate.find(hql, values);
	}

	public List<Class> getEntityClassList() {
		return new ArrayList(this.entityClassList);
	}

	public List<Class> getCachableEntityClassList() {
		return new ArrayList(this.cachable);
	}

	public <T extends BaseObject> String getIdName(Class<T> clazz) {
		return (String) this.idNameMap.get(clazz);
	}

	public Map<Class, String> getIdNameMap() {
		return new HashMap(this.idNameMap);
	}
}