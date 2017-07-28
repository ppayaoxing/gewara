/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo;

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
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MongoService3 {
	<T extends MGObject> T getObjectById(Class<T> arg0, String arg1, Serializable arg2);

	<T extends MGObject> List<T> getObjectList(Class<T> arg0);

	<T extends MGObject> List<T> getObjectList(Class<T> arg0, Expression arg1, String arg2, boolean arg3, int arg4,
			int arg5);

	<T extends MGObject> List<T> getObjectList(Class<T> arg0, String arg1, boolean arg2);

	<T extends MGObject> List<T> getObjectList(Class<T> arg0, Expression arg1);

	<T extends MGObject> List<T> getObjectListByNs(String arg0, Class<T> arg1, Expression arg2);

	<T extends MGObject> List<T> getObjectList(Class<T> arg0, String arg1, boolean arg2, int arg3, int arg4);

	<T extends MGObject> List<T> getObjectListByNs(String arg0, Class<T> arg1, Expression arg2, String arg3,
			boolean arg4, int arg5, int arg6);

	<T extends MGObject> List<T> getObjectList(Class<T> arg0, Expression arg1, String[] arg2, boolean[] arg3, int arg4,
			int arg5);

	<T extends MGObject> List<T> getObjectList(String arg0, Class<T> arg1, Expression arg2, String[] arg3,
			boolean[] arg4, int arg5, int arg6);

	List<Map> find(String arg0);

	List<Map> find(String arg0, int arg1, int arg2);

	List<Map> find(String arg0, Expression arg1);

	List<Map> find(String arg0, Expression arg1, String arg2, boolean arg3);

	List<Map> find(String arg0, Expression arg1, int arg2, int arg3);

	List<Map> find(String arg0, Expression arg1, String arg2, boolean arg3, int arg4, int arg5);

	List<Map> find(String arg0, Expression arg1, Map<String, Integer> arg2, String arg3, boolean arg4, int arg5,
			int arg6);

	List<Map> find(String arg0, Expression arg1, Map<String, Integer> arg2, String[] arg3, boolean[] arg4, int arg5,
			int arg6);

	List<Map> find(String arg0, Expression arg1, String[] arg2, boolean[] arg3, int arg4, int arg5);

	Map findOne(String arg0, Expression arg1);

	Map findById(String arg0, String arg1, Serializable arg2);

	<T extends MGObject> int getObjectCount(Class<T> arg0);

	<T extends MGObject> int getObjectCount(Class<T> arg0, Expression arg1);

	int getCount(String arg0);

	int getCount(String arg0, Expression arg1);

	<T> List<T> getDistinctPropertyList(String arg0, Expression arg1, String arg2, Class<T> arg3);

	void addMapList(List<Map> arg0, String arg1, String arg2);

	<T extends MGObject> void saveOrUpdateObject(T arg0, String arg1);

	<T extends MGObject> void addObject(T arg0, String arg1);

	<T extends MGObject> boolean removeObject(T arg0, String arg1);

	<T extends MGObject> boolean removeObjectById(Class<T> arg0, String arg1, Serializable arg2);

	boolean removeObjectById(String arg0, String arg1, Serializable arg2);

	<T extends MGObject> int removeObjectList(Collection<T> arg0, String arg1);

	<T extends MGObject> int removeObjectList(Class<T> arg0, String arg1, List<? extends Serializable> arg2);

	<T extends MGObject> int removeObjectList(Class<T> arg0, Expression arg1);

	int removeObjectList(String arg0, Expression arg1);

	void saveOrUpdateMap(Map arg0, String arg1, String arg2);

	void addMap(Map arg0, String arg1, String arg2);

	List<Map<String, String>> getAllTables();

	<T extends MGObject> void saveOrUpdateObjectList(List<T> arg0, String arg1);

	<T extends MGObject> void addObjectList(List<T> arg0, String arg1);

	ErrorCode<Integer> processData(String arg0, Expression arg1, MongoRowCallback arg2, boolean arg3);

	void enableStats(boolean arg0);

	Set<String> getCollections();

	Map getCollectionStat(String arg0);

	List<Map> getIndexesByNamespace(String arg0);

	void createIndex(String arg0, String arg1);

	void dropIndex(String arg0, String arg1);

	int copyCollection(String arg0, String arg1);

	<T> FindRes<T> execQuery(FindBuilder<T> arg0);

	UpdateRes execUpdate(UpdateBuilder arg0);

	void execInsert(InsertBuilder arg0);

	DeleteRes execDelete(DeleteBuilder arg0);

	<T> ErrorCode<Integer> process(FindBuilder<T> arg0, MongoRowCallback arg1, boolean arg2);

	<T> List<T> execDistinct(DistinctBuilder arg0, Class<T> arg1);

	FindRes<Object> group(AggregationBuilder arg0);
}