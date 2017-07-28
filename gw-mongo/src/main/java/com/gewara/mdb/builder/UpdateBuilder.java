/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.operation.ArrayOperation;
import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.result.UpdateRes;
import com.gewara.util.BeanUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import java.util.Map;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

public class UpdateBuilder<T> {
	private Class<T> sourceType = null;
	private Bson condition = null;
	private Document source = new Document();
	private Document otherSource = new Document();
	private UpdateOptions updateOptions = (new UpdateOptions()).upsert(false);
	private boolean updateMany = true;
	private String collectionName = null;

	public UpdateBuilder(String collectionName) {
		this.collectionName = collectionName;
	}

	public UpdateBuilder(Class<T> mapping) {
		this.collectionName = mapping.getCanonicalName();
		this.sourceType = mapping;
	}

	public UpdateBuilder<T> addAndCondition(Expression queryCondition) {
		if (this.condition != null) {
			this.condition = Filters.and(new Bson[] { this.condition, queryCondition.toBson() });
		} else {
			this.condition = queryCondition.toBson();
		}

		return this;
	}

	public UpdateBuilder<T> addOrCondition(Expression queryCondition) {
		if (this.condition != null) {
			this.condition = Filters.or(new Bson[] { this.condition, queryCondition.toBson() });
		} else {
			this.condition = queryCondition.toBson();
		}

		return this;
	}

	public UpdateBuilder<T> setCondition(Expression queryCondition) {
		this.condition = queryCondition.toBson();
		return this;
	}

	public <V> UpdateBuilder<T> addData(String field, V value) {
		this.source.put(field, value);
		return this;
	}

	public UpdateBuilder<T> addData(Map<String, Object> map) {
		this.source.putAll(map);
		return this;
	}

	public UpdateBuilder<T> addData2Array(ArrayOperation arrayOp) {
		this.otherSource.putAll(arrayOp.toDocument());
		return this;
	}

	public UpdateBuilder<T> setData(T source) {
		this.source = new Document();
		if (source instanceof Map) {
			this.source.putAll((Map) source);
		} else {
			this.source.putAll(BeanUtil.getBeanMap(source));
		}

		return this;
	}

	public UpdateBuilder<T> addData2Inc(String field, int number) {
		this.otherSource.put("$inc", new Document(field, Integer.valueOf(number)));
		return this;
	}

	public UpdateBuilder<T> setUpdateFirst(boolean updateFirst) {
		this.updateMany = !updateFirst;
		return this;
	}

	public UpdateBuilder<T> setInsert4NotFind(boolean insert) {
		this.updateOptions.upsert(true);
		return this;
	}

	public UpdateRes replaceOne(MongoDatabase database) {
		MongoCollection mc = database.getCollection(this.collectionName);
		UpdateResult ur = mc.replaceOne(this.condition, this.source, this.updateOptions);
		return new UpdateRes(ur);
	}

	public Class<T> getSourceType() {
		return this.sourceType;
	}

	public Bson getQueryCondition() {
		return (Bson) (this.condition != null ? this.condition : new BsonDocument());
	}

	public Document getSource() {
		return this.source;
	}

	public Document getOtherSource() {
		return this.otherSource;
	}

	public UpdateOptions getUpdateOptions() {
		return this.updateOptions;
	}

	public boolean isUpdateMany() {
		return this.updateMany;
	}

	public String getCollectionName() {
		return this.collectionName;
	}
}