package com.gewara.untrans.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.model.BaseObject;
import com.gewara.service.DaoService;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.CacheObjectService;
import com.gewara.util.BeanUtil;
import com.gewara.util.CacheMeta;
import com.gewara.util.DateUtil;
import com.gewara.util.Gcache;
import com.gewara.util.GcacheManager;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public final class CacheObjectServiceImpl implements CacheObjectService, InitializingBean {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private ConcurrentHashMap<String/*entityClass.getCanonicalName*/, Gcache<String, Serializable>> cachedUkeyMap = new ConcurrentHashMap<String, Gcache<String, Serializable>>();
	private Map<Class<?>/*entityClass*/, Class<?>/*id field type*/> idTypeMap = new HashMap<>();//ID字段的类型

	private DaoService daoService;
	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	@Override
	public <T extends BaseObject, S extends Serializable> T getObject(Class<T> clazz, S id){
		return getObject(null, clazz, id);
	}
	private <T extends BaseObject, S extends Serializable> T getObject(CacheMeta<T> meta, Class<T> clazz, S id){
		if(id == null){
			return null;
		}
		if(meta == null){
			meta = GcacheManager.getCacheMeta(clazz);
		}
		if(meta == null){
			return daoService.getObject(clazz, id);
		}
		T result = (T) meta.gcache.getIfPresent(id);
		if(result == null){
			result = daoService.getObject(meta.gclass, id);
			if(result!=null && result.cachable()){
				result.fix2Cache();
				meta.gcache.put(id, result);
			}
		}
		return result;
	}
	
	@Override
	public <T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, Collection<S> idList){
		if(idList == null || idList.isEmpty()){
			return new ArrayList(0);
		}
		List<T> resultList = getObjectListUsingCache(clazz, idList);
		return resultList;
	}
	
	@Override
	public <T extends BaseObject, S extends Serializable> T getObjectByUkey(Class<T> clazz, String ukeyName, S ukeyValue) {
		CacheMeta meta = GcacheManager.getCacheMeta(clazz);
		if(meta == null){
			return getByUkey(clazz, ukeyName, ukeyValue);
		}else{
			Serializable id = getUkey(clazz, ukeyName, ukeyValue);
			T result = null;
			if(id != null) {
				result = getObject(clazz, id);
				if(result == null){//不存在，可能是ID变化重查一次
					id = getIdByUkeyFromDB(clazz, ukeyName, ukeyValue);
					if(id!=null){//对象id变更了，重新设置缓存
						result = getObject(clazz, id);
						setUkey(clazz, ukeyName, ukeyValue, id);
					}else{//对象不存在，清除
						setUkey(clazz, ukeyName, ukeyValue, null);
					}
				}
			}
			return result;
		}
	}
	
	@Override
	public <T extends BaseObject> List<T> getObjectListByField(Class<T> clazz, String fieldname, Serializable fieldvalue){
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(fieldname, fieldvalue));
		CacheMeta meta = GcacheManager.getCacheMeta(clazz);
		if(meta == null){
			List result = daoService.findByCriteria(query);
			return result;
		}else{//缓存对象，先查询ID
			query.setProjection(Projections.id());
			List idList = daoService.findByCriteria(query);
			return getObjectListUsingCache(clazz, idList);
		}
	}
	
	private <T extends BaseObject, S extends Serializable> List<T> getObjectListUsingCache(Class<T> clazz, Collection<S> idList){
		CacheMeta<T> meta = GcacheManager.getCacheMeta(clazz);
		if(meta == null){
			return daoService.getObjectList(clazz, idList);
		}
		List<T> result = new ArrayList<T>(idList.size());
		T obj = null;
		long t = System.currentTimeMillis();
		int count = 0;
		for(S id: idList){
			obj = getObject(meta, clazz, id);
			if(obj != null) {
				result.add(obj);
			}
			count ++;
			if(System.currentTimeMillis() - t > DateUtil.m_minute*2 && count<200){
				//100个以内，超过2min，缓存有问题，直接抛异常
				throw new TraceErrorException("cache too slow!!");
			}
		}
		return result;
	}
	
	private <T extends BaseObject, S extends Serializable> T getByUkey(Class<T> clazz, String ukeyName, S ukeyValue) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyName, ukeyValue));
		List result = daoService.findByCriteria(query);
		if(result.isEmpty()) return null;
		if(result.size() > 1) throw new IllegalStateException("查询出多个记录：" + clazz.getName() + ", ukey=" + ukeyName + ", value=" + ukeyValue);
		return (T)result.get(0);
	}
	
	private <T extends BaseObject, S extends Serializable> S getIdByUkeyFromDB(Class<T> clazz, String ukeyName, S ukeyValue){
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		query.add(Restrictions.eq(ukeyName, ukeyValue));
		query.setProjection(Projections.id());
		List result = daoService.findByCriteria(query);
		if(result.isEmpty()) return null;
		if(result.size() > 1) throw new IllegalStateException("查询出多个记录：" + clazz.getName() + ", ukey=" + ukeyName + ", value=" + ukeyValue);
		return (S)result.get(0);
	}

	private <T extends BaseObject> Serializable getUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue){
		String cname = clazz.getCanonicalName();
		Gcache<String, Serializable> ukeyCache = cachedUkeyMap.get(cname);
		
		if(ukeyCache == null){
			ukeyCache = new Gcache<>(50000);//TODO:size??
			cachedUkeyMap.putIfAbsent(cname, ukeyCache);
		}else{
			Serializable idvalue = ukeyCache.getIfPresent(ukeyName + "_" + ukeyValue);
			if(idvalue!=null) {
				return idvalue;
			}
		}
		Serializable idvalue = getIdByUkeyFromDB(clazz, ukeyName, ukeyValue);
		if(idvalue!=null){
			ukeyCache.put(ukeyName + "_" + ukeyValue, idvalue);
		}
		return idvalue;
	}
	
	private <T extends BaseObject> void setUkey(Class<T> clazz, String ukeyName, Serializable ukeyValue, Serializable id){
		Gcache<String, Serializable> ukeyCache = cachedUkeyMap.get(clazz.getCanonicalName());
		if(ukeyCache != null){
			if(id!=null){
				ukeyCache.put(ukeyName + "_" + ukeyValue, id);
			}else{
				ukeyCache.invalidate(ukeyName + "_" + ukeyValue);
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<Class, String> nameMap = daoService.getEntityIdNameMap();
		for(Map.Entry<Class, String> entry: nameMap.entrySet()){
			try{
				Class<?> type = BeanUtil.getFieldType(entry.getKey(), entry.getValue());
				if(type!=null){
					idTypeMap.put(entry.getKey(), type);
				}
			}catch(Exception e){
				dbLogger.warn("init id type error:" + entry.getKey(), e, 10);
			}
		}
	}

	@Override
	public <T extends BaseObject> Class<?> getEntityIdType(Class<T> entityClazz) {
		return idTypeMap.get(entityClazz);
	}

	@Override
	public <T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, String sortField, boolean asc, int from, int maxnum) {
		DetachedCriteria query = DetachedCriteria.forClass(clazz);
		if(asc) query.addOrder(Order.asc(sortField));
		else query.addOrder(Order.desc(sortField));
		query.setProjection(Projections.id());
		List<Serializable> idList = daoService.findByCriteria(query, from, maxnum);
		return getObjectListUsingCache(clazz, idList);
	}
}
