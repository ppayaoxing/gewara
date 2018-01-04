package com.gewara.mongo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gewara.mdb.builder.AggregationBuilder;
import com.gewara.mdb.builder.DeleteBuilder;
import com.gewara.mdb.builder.DistinctBuilder;
import com.gewara.mdb.builder.FindBuilder;
import com.gewara.mdb.builder.InsertBuilder;
import com.gewara.mdb.builder.UpdateBuilder;
import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.result.DeleteRes;
import com.gewara.mdb.result.FindRes;
import com.gewara.mdb.result.UpdateRes;
import com.gewara.mongo.support.MGObject;
import com.gewara.mongo.support.MongoRowCallback;
import com.gewara.support.ErrorCode;

public interface MongoService3 {
	<T extends MGObject> T getObjectById(Class<T> clazz, String idName, Serializable id);
	<T extends MGObject> List<T> getObjectList(Class<T> clazz);
	/**
	 * @param clazz
	 * @param params
	 * @param orderField
	 * @param asc
	 * @param from
	 * @param rows
	 * @return
	 */
	<T extends MGObject> List<T> getObjectList(Class<T> clazz, Expression params, String orderField, boolean asc, int from, int maxnum);

	<T extends MGObject> List<T> getObjectList(Class<T> clazz, String orderField, boolean asc);
	/**
	 * 查询
	 * @param clazz
	 * @param params
	 * @return
	 */
	<T extends MGObject> List<T> getObjectList(Class<T> clazz, Expression params);
	<T extends MGObject> List<T> getObjectListByNs(String namespace, Class<T> clazz, Expression params);

	<T extends MGObject> List<T> getObjectList(Class<T> clazz, String orderField, boolean asc, int from, int maxnum);
	<T extends MGObject> List<T> getObjectListByNs(String namespace, Class<T> clazz, Expression params, String orderField, boolean asc, int from, int maxnum);

	<T extends MGObject> List<T> getObjectList(Class<T> clazz, Expression params, String[] orderField, boolean[] asc, int from, int maxnum);
	<T extends MGObject> List<T> getObjectList(String namespace, Class<T> clazz, Expression params, String[] orderField, boolean[] asc, int from, int maxnum);

	List<Map> find(String namespace);
	List<Map> find(String namespace, int from, int maxnum);

	List<Map> find(String namespace, Expression params);
	List<Map> find(String namespace, Expression params, String orderField, boolean asc);
	List<Map> find(String namespace, Expression params, int from, int maxnum);

	List<Map> find(String namespace, Expression params, String orderField, boolean asc, int from, int maxnum);
	
	/**
	 * @param namespace
	 * @param params
	 * @param fields(field--->value) value>0:include,else exclude
	 * @param orderField
	 * @param asc
	 * @param from
	 * @param maxnum
	 * @return
	 */
	List<Map> find(String namespace, Expression params, Map<String, Integer> fields, String orderField, boolean asc, int from, int maxnum);
	List<Map> find(String namespace, Expression params, Map<String, Integer> fields, String[] orderField, boolean[] asc, int from, int maxnum);
	List<Map> find(String namespace, Expression params, String[] orderField, boolean[] asc, int from, int maxnum);
	Map findOne(String namespace, Expression params);
	Map findById(String namespace, String idName, Serializable idValue);


	<T extends MGObject> int getObjectCount(Class<T> clazz);
	<T extends MGObject> int getObjectCount(Class<T> clazz, Expression params);
	int getCount(String namespace);
	int getCount(String namespace, Expression params);

	<T> List<T> getDistinctPropertyList(String namespace, Expression params, String propertyname, Class<T> clazz);

	//~~~~~~~~~~~~~~~~~~~~~~modify method ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * @param mapList
	 * @param idName
	 * @param namespace
	 * @param nested
	 * @param ignoreNull
	 */
	void addMapList(List<Map> mapList, String idName, String namespace);
	<T extends MGObject> void saveOrUpdateObject(T bean, String idName);
	<T extends MGObject> void addObject(T o, String idName);

	<T extends MGObject> boolean removeObject(T o, String idName);
	<T extends MGObject> boolean removeObjectById(Class<T> clazz, String idName, Serializable id);
	boolean removeObjectById(String namespace, String idName, Serializable id);
	/**
	 * 返回删除的数量
	 * @param entityList
	 * @return
	 */
	<T extends MGObject> int removeObjectList(Collection<T> entityList, String idName);
	<T extends MGObject> int removeObjectList(Class<T> clazz, String idName, List<? extends Serializable> idList);
	<T extends MGObject> int removeObjectList(Class<T> clazz, Expression params);
	int removeObjectList(String namespace, Expression params);

	void saveOrUpdateMap(Map map, String idName, String namespace);
	void addMap(Map map, String idName, String namespace);
	
	List<Map<String, String>> getAllTables();
	/**
	 * @param beanList
	 * @param idName
	 */
	<T extends MGObject> void saveOrUpdateObjectList(List<T> beanList, String idName);
	/**
	 * @param beanList
	 * @param idName
	 */
	<T extends MGObject> void addObjectList(List<T> beanList, String idName);

	/**
	 * 针对查询的数据做处理,返回处理的行数
	 * @param namespace
	 * @param params
	 * @param callback
	 * @param exitOnError 
	 */
	ErrorCode<Integer> processData(String namespace, Expression params, MongoRowCallback callback, boolean exitOnError);
	
	//~~~~~~~~~~~~~~~~~~~mongo manage~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	void enableStats(boolean enableStats);
	Set<String> getCollections();
	Map getCollectionStat(String collectionName);
	/**
	 * @param namespace
	 * @return
	 */
	List<Map> getIndexesByNamespace(String namespace);
	void createIndex(String namespace, String fields);
	void dropIndex(String namespace, String indexname);
	int copyCollection(String fromCollection, String toCollection);
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	<T> FindRes<T> execQuery(FindBuilder<T> fb);
	UpdateRes execUpdate(UpdateBuilder ub);
	void execInsert(InsertBuilder ib);
	DeleteRes execDelete(DeleteBuilder del);
	<T> ErrorCode<Integer> process(FindBuilder<T> fb, MongoRowCallback callback, boolean exitOnError);
	<T> List<T> execDistinct(DistinctBuilder dis, Class<T> fieldType);
	FindRes<Object> group(AggregationBuilder ab);
}
