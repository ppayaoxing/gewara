/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.model.BaseObject;
import com.gewara.service.DaoService;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.CacheObjectService;
import com.gewara.util.BeanUtil;
import com.gewara.util.CacheMeta;
import com.gewara.util.Gcache;
import com.gewara.util.GcacheManager;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.InitializingBean;

public final class CacheObjectServiceImpl implements CacheObjectService, InitializingBean {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private ConcurrentHashMap<String, Gcache<String, Serializable>> cachedUkeyMap = new ConcurrentHashMap();
	private Map<Class<?>, Class<?>> idTypeMap = new HashMap();
	private DaoService daoService;

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public <T extends BaseObject, S extends Serializable> T getObject(Class<T> clazz, S id) {
		return this.getObject((CacheMeta) null, clazz, id);
	}

	private <T extends BaseObject, S extends Serializable> T getObject(CacheMeta<T> meta, Class<T> clazz, S id) {
		if (id == null) {
			return null;
		} else {
			if (meta == null) {
				meta = GcacheManager.getCacheMeta(clazz);
			}

			if (meta == null) {
				return this.daoService.getObject(clazz, id);
			} else {
				BaseObject result = (BaseObject) meta.gcache.getIfPresent(id);
				if (result == null) {
					result = this.daoService.getObject(meta.gclass, id);
					if (result != null && result.cachable()) {
						result.fix2Cache();
						meta.gcache.put(id, result);
					}
				}

				return result;
			}
		}
	}

	public <T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, Collection<S> idList) {
		if (idList != null && !idList.isEmpty()) {
			List resultList = this.getObjectListUsingCache(clazz, idList);
			return resultList;
		} else {
			return new ArrayList(0);
		}
	}

	public <T extends BaseObject, S extends Serializable> T getObjectByUkey(Class<T> clazz, String ukeyName,
			S ukeyValue) {
		CacheMeta meta = GcacheManager.getCacheMeta(clazz);
		if (meta == null) {
			return this.getByUkey(clazz, ukeyName, ukeyValue);
		} else {
			Serializable id = this.getUkey(clazz, ukeyName, ukeyValue);
			BaseObject result = null;
			if (id != null) {
				result = this.getObject(clazz, id);
				if (result == null) {
					id = this.getIdByUkeyFromDB(clazz, ukeyName, ukeyValue);
					if (id != null) {
						result = this.getObject(clazz, id);
						this.setUkey(clazz, ukeyName, ukeyValue, id);
					} else {
						this.setUkey(clazz, ukeyName, ukeyValue, (Serializable) null);
					}
				}
			}

			return result;
		}
	}

	public <T extends BaseObject> List<T> getObjectListByField(Class<T> clazz, String fieldname,
			Serializable fieldvalue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(fieldname, fieldvalue));
		CacheMeta meta = GcacheManager.getCacheMeta(clazz);
		List idList;
		if (meta == null) {
			idList = this.daoService.findByCriteria(query);
			return idList;
		} else {
			query.setProjection(Projections.id());
			idList = this.daoService.findByCriteria(query);
			return this.getObjectListUsingCache(clazz, idList);
		}
	}

	private <T extends BaseObject, S extends Serializable> List<T> getObjectListUsingCache(Class<T> clazz,
			Collection<S> idList) {
		CacheMeta meta = GcacheManager.getCacheMeta(clazz);
		if (meta == null) {
			return this.daoService.getObjectList(clazz, idList);
		} else {
			ArrayList result = new ArrayList(idList.size());
			BaseObject obj = null;
			long t = System.currentTimeMillis();
			int count = 0;
			Iterator arg8 = idList.iterator();

			do {
				if (!arg8.hasNext()) {
					return result;
				}

				Serializable id = (Serializable) arg8.next();
				obj = this.getObject(meta, clazz, id);
				if (obj != null) {
					result.add(obj);
				}

				++count;
			} while (System.currentTimeMillis() - t <= 120000L || count >= 200);

			throw new TraceErrorException("cache too slow!!");
		}
	}

	private <T extends BaseObject, S extends Serializable> T getByUkey(Class<T> clazz, String ukeyName, S ukeyValue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyName, ukeyValue));
		List result = this.daoService.findByCriteria(query);
		if (result.isEmpty()) {
			return null;
		} else if (result.size() > 1) {
			throw new IllegalStateException(
					"查询出多个记录：" + clazz.getName() + ", ukey=" + ukeyName + ", value=" + ukeyValue);
		} else {
			return (BaseObject) result.get(0);
		}
	}

	private <T extends BaseObject, S extends Serializable> S getIdByUkeyFromDB(Class<T> clazz, String ukeyName,
			S ukeyValue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyName, ukeyValue));
		query.setProjection(Projections.id());
		List result = this.daoService.findByCriteria(query);
		if (result.isEmpty()) {
			return null;
		} else if (result.size() > 1) {
			throw new IllegalStateException(
					"查询出多个记录：" + clazz.getName() + ", ukey=" + ukeyName + ", value=" + ukeyValue);
		} else {
			return (Serializable) result.get(0);
		}
	}

	private <T extends BaseObject> Serializable getUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue) {
		String cname = clazz.getCanonicalName();
		Gcache ukeyCache = (Gcache) this.cachedUkeyMap.get(cname);
		Serializable idvalue;
		if (ukeyCache == null) {
			ukeyCache = new Gcache(50000L);
			this.cachedUkeyMap.putIfAbsent(cname, ukeyCache);
		} else {
			idvalue = (Serializable) ukeyCache.getIfPresent(ukeyName + "_" + ukeyValue);
			if (idvalue != null) {
				return idvalue;
			}
		}

		idvalue = this.getIdByUkeyFromDB(clazz, ukeyName, ukeyValue);
		if (idvalue != null) {
			ukeyCache.put(ukeyName + "_" + ukeyValue, idvalue);
		}

		return idvalue;
	}

	private <T extends BaseObject> void setUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue,
			Serializable id) {
		Gcache ukeyCache = (Gcache) this.cachedUkeyMap.get(clazz.getCanonicalName());
		if (ukeyCache != null) {
			if (id != null) {
				ukeyCache.put(ukeyName + "_" + ukeyValue, id);
			} else {
				ukeyCache.invalidate(ukeyName + "_" + ukeyValue);
			}
		}

	}

	public void afterPropertiesSet() throws Exception {
		Map nameMap = this.daoService.getEntityIdNameMap();
		Iterator arg1 = nameMap.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();

			try {
				Class e = BeanUtil.getFieldType((Class) entry.getKey(), (String) entry.getValue());
				if (e != null) {
					this.idTypeMap.put(entry.getKey(), e);
				}
			} catch (Exception arg4) {
				this.dbLogger.warn("init id type error:" + entry.getKey(), arg4, 10);
			}
		}

	}

	public <T extends BaseObject> Class<?> getEntityIdType(Class<T> entityClazz) {
		return (Class) this.idTypeMap.get(entityClazz);
	}

	public <T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, String sortField,
			boolean asc, int from, int maxnum) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		if (asc) {
			query.addOrder(Order.asc(sortField));
		} else {
			query.addOrder(Order.desc(sortField));
		}

		query.setProjection(Projections.id());
		List idList = this.daoService.findByCriteria(query, from, maxnum);
		return this.getObjectListUsingCache(clazz, idList);
	}
}