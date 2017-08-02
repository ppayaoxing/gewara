/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.gewara.mdb.GWMongoClient;
import com.gewara.mdb.builder.AggregationBuilder;
import com.gewara.mdb.builder.DeleteBuilder;
import com.gewara.mdb.builder.DistinctBuilder;
import com.gewara.mdb.builder.FindBuilder;
import com.gewara.mdb.builder.IndexBuilder;
import com.gewara.mdb.builder.InsertBuilder;
import com.gewara.mdb.builder.UpdateBuilder;
import com.gewara.mdb.helper.BuilderUtils;
import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.operation.Projection;
import com.gewara.mdb.result.DeleteRes;
import com.gewara.mdb.result.FindRes;
import com.gewara.mdb.result.UpdateRes;
import com.gewara.mongo.MongoDataException;
import com.gewara.mongo.MongoService;
import com.gewara.mongo.support.MGObject;
import com.gewara.mongo.support.MongoRowCallback;
import com.gewara.mongo.support.MongoStats;
import com.gewara.support.ErrorCode;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.mongodb.DBObject;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
@Service("mongoService")
public class MongoServiceImpl implements MongoService, InitializingBean {
	private MongoDatabase currentDB = null;
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(MongoService3Impl.class);

	public MongoServiceImpl(GWMongoClient mongoClient) {
		this.currentDB = mongoClient.prepareDatabase();
	}

	public MongoServiceImpl(GWMongoClient mongoClient, String databaseName) {
		this.currentDB = mongoClient.prepareDatabase(databaseName);
	}

	public void enableStats(boolean enable) {
		MongoStats.setEnableStats(enable);
	}

	public void afterPropertiesSet() throws Exception {
		if (this.currentDB == null) {
			throw new IllegalStateException("currentDB must be set!");
		}
	}

	public <T extends MGObject> T getObjectById(Class<T> clazz, String idName, Serializable id) {
		return this
				.execQuery(BuilderUtils.prepareFind(clazz).setCondition((new Expression()).eq(idName, id)).setSize(1))
				.toBean();
	}

	public <T extends MGObject> List<T> getObjectList(Class<T> clazz) {
		return this.execQuery(BuilderUtils.prepareFind(clazz)).toBeans();
	}

	public <T extends MGObject> List<T> getObjectList(Class<T> clazz, String orderField, boolean asc) {
		return this.execQuery(BuilderUtils.prepareFind(clazz).addSort(orderField, asc)).toBeans();
	}

	public <T extends MGObject> List<T> getObjectList(Class<T> clazz, String orderField, boolean asc, int from,
			int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(clazz).addSort(orderField, asc).setFrom(from).setSize(maxnum))
				.toBeans();
	}

	public <T extends MGObject> void saveOrUpdateObject(T bean, String idName) {
		Map beanMap = this.getObjectMap(bean);
		Object id = beanMap.get(idName);
		if (id == null) {
			throw new MongoDataException("mongodb: id can\'t be null!");
		} else {
			this.execUpdate(BuilderUtils.prepareUpdate(bean.getClass()).setCondition((new Expression()).eq(idName, id))
					.setUpdateFirst(true).setInsert4NotFind(true).addData(beanMap));
		}
	}

	public <T extends MGObject> void addObject(T bean, String idName) {
		if (bean != null) {
			Map beanMap = this.getObjectMap(bean);
			Serializable id = (Serializable) beanMap.get(idName);
			if (id == null) {
				throw new MongoDataException("id can not be null!");
			} else {
				this.execInsert(BuilderUtils.prepareInsert(bean.getClass().getCanonicalName())
						.addData4Bean(new Object[] { beanMap }));
			}
		}
	}

	private Map getObjectMap(MGObject bean) {
		Map beanMap = BeanUtil.getBeanMap(bean);
		if (beanMap.containsKey("_id")) {
			Object _id = BeanUtil.get(bean, "_id");
			if (_id == null) {
				beanMap.remove("_id");
			} else if (_id instanceof ObjectId) {
				beanMap.put("_id", _id);
			}
		} else if (bean.realId() != null) {
			beanMap.put("_id", bean.realId());
		}

		return beanMap;
	}

	public <T extends MGObject> boolean removeObject(T o, String idName) {
		Object id = BeanUtil.get(o, idName);
		return id != null ? this.execDelete(BuilderUtils.prepareDelete(o.getClass())
				.setCondition((new Expression()).eq(idName, id)).setDeleteOne(true)).success() : false;
	}

	public <T extends MGObject> boolean removeObjectById(Class<T> clazz, String idName, Serializable id) {
		return this.execDelete(
				BuilderUtils.prepareDelete(clazz).setCondition((new Expression()).eq(idName, id)).setDeleteOne(true))
				.success();
	}

	public boolean removeObjectById(String namespace, String idName, Serializable id) {
		return this.execDelete(BuilderUtils.prepareDelete(namespace).setCondition((new Expression()).eq(idName, id))
				.setDeleteOne(true)).success();
	}

	public <T extends MGObject> int removeObjectList(Collection<T> entityList, String idName) {
		if (entityList.isEmpty()) {
			return 0;
		} else {
			Class clazz = ((MGObject) entityList.iterator().next()).getClass();
			List idList = BeanUtil.getBeanPropertyList(entityList, idName, true);
			return this.removeObjectList(clazz, idName, idList);
		}
	}

	public <T extends MGObject> int removeObjectList(Class<T> clazz, String idName,
			List<? extends Serializable> idList) {
		return this.execDelete(BuilderUtils.prepareDelete(clazz).setCondition((new Expression()).in(idName, idList)))
				.deleteCount();
	}

	public <T extends MGObject> int removeObjectList(Class<T> clazz, Expression params) {
		return this.execDelete(BuilderUtils.prepareDelete(clazz).setCondition(params)).deleteCount();
	}

	public int removeObjectList(String namespace, Expression params) {
		return this.execDelete(BuilderUtils.prepareDelete(namespace).setCondition(params)).deleteCount();
	}

	public void saveOrUpdateMap(Map map, String idName, String namespace) {
		Object id = map.get(idName);
		if (id == null) {
			throw new MongoDataException("mongodb: id can\'t be null!");
		} else {
			this.execUpdate(BuilderUtils.prepareUpdate(namespace).setCondition((new Expression()).eq(idName, id))
					.setUpdateFirst(true).setInsert4NotFind(true).setData(map));
		}
	}

	public void addMap(Map map, String idName, String namespace) {
		this.execInsert(BuilderUtils.prepareInsert(namespace).addData4Bean(new Object[] { map }));
	}

	public List<Map> find(String namespace) {
		return this.execQuery(BuilderUtils.prepareFind(namespace)).toMapList();
	}

	public List<Map<String, String>> getAllTables() {
		ArrayList result = new ArrayList();
		Set names = this.getCollections();
		Iterator arg2 = names.iterator();

		while (arg2.hasNext()) {
			String namespace = (String) arg2.next();
			if (!StringUtils.startsWith(namespace, "system.")) {
				HashMap data = new HashMap();
				data.put(namespace, "" + this.getCount(namespace));
				result.add(data);
			}
		}

		return result;
	}

	public List<Map> find(String namespace, Expression params, String orderField, boolean asc) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params).addSort(orderField, asc))
				.toMapList();
	}

	public List<Map> find(String namespace, Expression params, String[] orderField, boolean[] asc, int from,
			int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params).addSort(orderField, asc)
				.setFrom(from).setSize(maxnum)).toMapList();
	}

	public List<Map> find(String namespace, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setFrom(from).setSize(maxnum)).toMapList();
	}

	public List<Map> find(String namespace, Expression params, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params).addSort("_id", false)
				.setFrom(from).setSize(maxnum)).toMapList();
	}

	public Map findOne(String namespace, Expression params) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params).setSize(1)).toMap();
	}

	public Map findById(String namespace, String idName, Serializable idValue) {
		return this.execQuery(
				BuilderUtils.prepareFind(namespace).setCondition((new Expression()).eq(idName, idValue)).setSize(1))
				.toMap();
	}

	public <T extends MGObject> void saveOrUpdateObjectList(List<T> beanList, String idName) {
		if (!beanList.isEmpty()) {
			Class clazz = ((MGObject) beanList.get(0)).getClass();
			String namespace = clazz.getCanonicalName();
			Iterator arg4 = beanList.iterator();

			while (arg4.hasNext()) {
				MGObject bean = (MGObject) arg4.next();
				Map beanMap = this.getObjectMap(bean);
				Object id = beanMap.get(idName);
				if (id == null) {
					throw new MongoDataException("mongodb: id can\'t be null!");
				}

				this.execUpdate(BuilderUtils.prepareUpdate(namespace).setCondition((new Expression()).eq(idName, id))
						.setUpdateFirst(true).setInsert4NotFind(true).setData(beanMap));
			}

		}
	}

	public <T extends MGObject> void addObjectList(List<T> beanList, String idName) {
		if (beanList != null && !beanList.isEmpty()) {
			Class c = ((MGObject) beanList.get(0)).getClass();
			InsertBuilder insert = BuilderUtils.prepareInsert(c.getCanonicalName());
			Iterator arg4 = beanList.iterator();

			while (arg4.hasNext()) {
				MGObject bean = (MGObject) arg4.next();
				Map beanMap = this.getObjectMap(bean);
				Serializable id = (Serializable) beanMap.get(idName);
				if (id == null) {
					throw new MongoDataException("id can not be null!");
				}

				insert.addData4Bean(new Map[] { beanMap });
			}

			this.execInsert(insert);
		}
	}

	public void addMapList(List<Map> mapList, String idName, String namespace) {
		this.execInsert(BuilderUtils.prepareInsert(namespace).setData4Bean(mapList));
	}

	public int getCount(String namespace) {
		return this.count(namespace);
	}

	public List<Map> find(String namespace, Expression params) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params)).toMapList();
	}

	public List<Map> find(String namespace, Expression params, String orderField, boolean asc, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params).addSort(orderField, asc)
				.setFrom(from).setSize(maxnum)).toMapList();
	}

	public List<Map> find(String namespace, Expression params, Map<String, Integer> fields, String orderField,
			boolean asc, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params)
				.setProjection((new Projection()).addFields(fields)).addSort(orderField, asc).setFrom(from)
				.setSize(maxnum)).toMapList();
	}

	public List<Map> find(String namespace, Expression params, Map<String, Integer> fields, String[] orderField,
			boolean[] asc, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace).setCondition(params)
				.setProjection((new Projection()).addFields(fields)).addSort(orderField, asc).setFrom(from)
				.setSize(maxnum)).toMapList();
	}

	public <T extends MGObject> List<T> getObjectList(Class<T> clazz, Expression params) {
		return this.execQuery(BuilderUtils.prepareFind(clazz).setCondition(params)).toBeans();
	}

	public <T extends MGObject> List<T> getObjectList(Class<T> clazz, Expression params, String orderField, boolean asc,
			int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(clazz).setCondition(params).addSort(orderField, asc)
				.setFrom(from).setSize(maxnum)).toBeans();
	}

	public <T extends MGObject> List<T> getObjectListByNs(String namespace, Class<T> clazz, Expression params) {
		return this.execQuery(BuilderUtils.prepareFind(namespace, clazz).setCondition(params)).toBeans();
	}

	public <T extends MGObject> List<T> getObjectListByNs(String namespace, Class<T> clazz, Expression params,
			String orderField, boolean asc, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace, clazz).setCondition(params).addSort(orderField, asc)
				.setFrom(from).setSize(maxnum)).toBeans();
	}

	public <T extends MGObject> int getObjectCount(Class<T> clazz, Expression params) {
		return this.count(BuilderUtils.prepareFind(clazz).setCondition(params));
	}

	public int getCount(String namespace, Expression params) {
		return this.count(BuilderUtils.prepareFind(namespace).setCondition(params));
	}

	public <T> List<T> getDistinctPropertyList(String namespace, Expression params, String propertyname,
			Class<T> clazz) {
		return this.execDistinct(
				BuilderUtils.prepareDistinct(namespace).setDistinctField(propertyname).setCondition(params), clazz);
	}

	public int copyCollection(String fromCollection, String toCollection) {
		int total = 0;
		MongoCursor ite = this.currentDB.getCollection(fromCollection).find().iterator();
		if (ite.hasNext()) {
			for (MongoCollection target = this.currentDB.getCollection(toCollection); ite.hasNext(); ++total) {
				target.insertOne(ite.next());
			}
		}

		return total;
	}

	public <T extends MGObject> List<T> getObjectList(Class<T> clazz, Expression params, String[] orderField,
			boolean[] asc, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(clazz).setCondition(params).addSort(orderField, asc)
				.setFrom(from).setSize(maxnum)).toBeans();
	}

	public <T extends MGObject> List<T> getObjectList(String namespace, Class<T> clazz, Expression params,
			String[] orderField, boolean[] asc, int from, int maxnum) {
		return this.execQuery(BuilderUtils.prepareFind(namespace, clazz).setCondition(params).addSort(orderField, asc)
				.setFrom(from).setSize(maxnum)).toBeans();
	}

	public ErrorCode<Integer> processData(String namespace, Expression params, MongoRowCallback callback,
			boolean exitOnError) {
		return this.process(BuilderUtils.prepareFind(namespace).setCondition(params), callback, exitOnError);
	}

	public Set<String> getCollections() {
		MongoCursor ite = this.currentDB.listCollectionNames().iterator();
		HashSet r = new HashSet();

		while (ite.hasNext()) {
			r.add(ite.next());
		}

		return r;
	}

	public List<Map> getIndexesByNamespace(String namespace) {
		return this.listIndexes(namespace).toMapList();
	}

	public void createIndex(String namespace, String fields) {
		if (StringUtils.isNotBlank(fields)) {
			String indexname = StringUtils.replace(fields, ",", "_");
			String[] arrs = StringUtils.split(fields, ",");
			this.createIndex(BuilderUtils.prepareIndex(namespace).setIndexName(indexname).addIndexField(arrs));
		}

	}

	public void dropIndex(String namespace, String indexname) {
		this.dropIndex(BuilderUtils.prepareIndex(namespace).setIndexName(indexname));
	}

	public <T extends MGObject> int getObjectCount(Class<T> clazz) {
		return this.count(clazz);
	}

	public Map getCollectionStat(String collectionName) {
		Document doc = this.currentDB.runCommand(new Document("collStats", collectionName));
		return doc;
	}

	public UpdateRes execUpdate(UpdateBuilder ub) {
		MongoCollection mc = this.currentDB.getCollection(ub.getCollectionName());
		Bson filter = ub.getQueryCondition();
		UpdateResult ur = null;
		Document data = new Document();
		if (!ub.getSource().isEmpty()) {
			data.append("$set", ub.getSource());
		}

		if (ub.getOtherSource() != null && !ub.getOtherSource().isEmpty()) {
			if (data.isEmpty()) {
				data.putAll(ub.getOtherSource());
			} else {
				if (ub.getOtherSource().get("$set") != null) {
					((Map) data.get("$set", Map.class)).putAll((Map) ub.getOtherSource().remove("$set"));
				}

				data.putAll(ub.getOtherSource());
			}
		}

		if (ub.isUpdateMany()) {
			ur = mc.updateMany(filter, data, ub.getUpdateOptions());
		} else {
			ur = mc.updateOne(filter, data, ub.getUpdateOptions());
		}

		MongoStats.addOp(ub.getCollectionName(), MongoStats.OP_UPDATE);
		return new UpdateRes(ur);
	}

	public <T> FindRes<T> execQuery(FindBuilder<T> fb) {
		MongoCollection mc = this.currentDB.getCollection(fb.getCollectionName());
		Bson c = fb.getQueryCondition();
		FindIterable fi = c == null ? mc.find() : mc.find(c);
		MongoStats.addOp(fb.getCollectionName(), MongoStats.OP_QUERY);
		if (fb.getProjection() != null) {
			fi.projection(fb.getProjection());
		}

		if (fb.getSort() != null) {
			fi.sort(fb.getSort());
		}

		if (fb.getFrom() > 0) {
			fi.skip(fb.getFrom());
		}

		if (fb.getSize() != null && fb.getSize().intValue() > 0) {
			fi.limit(fb.getSize().intValue());
		}

		return new FindRes(fi.iterator(), fb.getMapping());
	}

	public <T> List<T> execDistinct(DistinctBuilder dis, Class<T> fieldType) {
		DistinctIterable result = this.currentDB.getCollection(dis.getCollectionName()).distinct(dis.getDistincField(),
				fieldType);
		MongoCursor ite = result.filter(dis.getQueryCondition()).iterator();
		ArrayList list = new ArrayList();

		while (ite.hasNext()) {
			list.add(ite.next());
		}

		return list;
	}

	public <T> ErrorCode<Integer> process(FindBuilder<T> fb, MongoRowCallback callback, boolean exitOnError) {
		MongoCollection mc = this.currentDB.getCollection(fb.getCollectionName());
		FindIterable fi = null;
		Bson c = fb.getQueryCondition();
		fi = mc.find(c);
		if (fb.getProjection() != null) {
			fi.projection(fb.getProjection());
		}

		if (fb.getSort() != null) {
			fi.sort(fb.getSort());
		}

		if (fb.getFrom() > 0) {
			fi.skip(fb.getFrom());
		}

		if (fb.getSize() != null && fb.getSize().intValue() > 0) {
			fi.limit(fb.getSize().intValue());
		}

		MongoCursor docs = fi.iterator();
		MongoStats.addOp(fb.getCollectionName(), MongoStats.OP_QUERY);
		int count = 0;
		if (docs != null && docs.hasNext()) {
			while (docs.hasNext()) {
				try {
					callback.processRow((Map) docs.next());
					++count;
				} catch (Exception arg9) {
					dbLogger.warn(LoggerUtils.getExceptionTrace(arg9, 20));
					if (exitOnError) {
						return ErrorCode.getFailureReturn(Integer.valueOf(count));
					}
				}
			}
		}

		return ErrorCode.getSuccessReturn(Integer.valueOf(count));
	}

	public DeleteRes execDelete(DeleteBuilder del) {
		Bson c = del.getQueryCondition();
		MongoCollection mc = this.currentDB.getCollection(del.getCollectionName());
		DeleteResult result = null;
		if (del.isDeleteOne()) {
			result = mc.deleteOne(c);
		} else {
			result = mc.deleteMany(c);
		}

		MongoStats.addOp(del.getCollectionName(), MongoStats.OP_REMOVE);
		return new DeleteRes(result, del.isDeleteOne());
	}

	public void execInsert(InsertBuilder ib) {
		MongoCollection mc = this.currentDB.getCollection(ib.getCollectionName());
		if (ib.getSources().size() == 1) {
			Document doc = ib.getTop();
			mc.insertOne(doc);
		} else {
			mc.insertMany(ib.getSources(), ib.getInsertManyOptions());
		}

		MongoStats.addOp(ib.getCollectionName(), MongoStats.OP_UPDATE);
	}

	private int count(String collectionName) {
		MongoCollection mc = this.currentDB.getCollection(collectionName);
		return (int) mc.count();
	}

	private int count(Class clazz) {
		MongoCollection mc = this.currentDB.getCollection(clazz.getCanonicalName());
		return (int) mc.count();
	}

	private <T> int count(FindBuilder<T> fb) {
		MongoCollection mc = this.currentDB.getCollection(fb.getCollectionName());
		return (int) mc.count(fb.getQueryCondition());
	}

	private void createIndex(IndexBuilder idx) {
		this.currentDB.getCollection(idx.getCollectionName()).createIndex(idx.getIndex(), idx.getIndexOptions());
	}

	private void dropIndex(IndexBuilder idx) {
		this.currentDB.getCollection(idx.getCollectionName()).dropIndex(idx.getIndexOptions().getName());
	}

	private FindRes listIndexes(String collectionName) {
		MongoCursor ite = this.currentDB.getCollection(collectionName).listIndexes().iterator();
		return new FindRes(ite);
	}

	public FindRes<Object> group(AggregationBuilder ab) {
		MongoCursor result = this.currentDB.getCollection(ab.getCollectionName()).aggregate(ab.build()).iterator();
		return new FindRes(result);
	}

//	========================== TODO  新加的方法========================================
	@Override
	public DBObject queryBasicDBObject(String string, String string2, String tagCinema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBObject queryAdvancedDBObject(String string, String[] strings, Date[] dates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends MGObject> getObjectList(Class<?> class1, DBObject queryCondition, String orderField,
			boolean asc, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getMap(String defaultIdName, String nsIndexDatasheet, String indexKey) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map getMap(String defaultIdName, String nsIndexDatasheet, Long indexKey) {
		// TODO Auto-generated method stub
		return null;
	}
}