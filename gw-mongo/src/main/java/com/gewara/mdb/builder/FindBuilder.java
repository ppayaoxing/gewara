/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.operation.Projection;
import com.gewara.mongo.MongoDataException;
import com.gewara.util.Util4Script;
import org.apache.commons.lang.StringUtils;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

public class FindBuilder<T> implements Util4Script {
	private Class<T> mapping;
	private Bson condition = null;
	private Bson projection = null;
	private Document sort = null;
	private int from = 0;
	private Integer size = null;
	private String collectionName = null;

	public FindBuilder(String collectionName) {
		this.collectionName = collectionName;
		if (this.collectionName == null) {
			throw new MongoDataException("please check the param,the collectionName is null");
		}
	}

	public FindBuilder(Class<T> mappingClass) {
		this.collectionName = mappingClass.getCanonicalName();
		if (this.collectionName == null) {
			throw new MongoDataException("please check the param,don\'t get mappingClass\'s canonicalName");
		} else {
			this.mapping = mappingClass;
		}
	}

	public FindBuilder(String collectionName, Class<T> mappingClass) {
		this.collectionName = collectionName;
		if (this.collectionName == null) {
			throw new MongoDataException("please check the param,don\'t get mappingClass\'s canonicalName");
		} else {
			this.mapping = mappingClass;
		}
	}

	public FindBuilder<T> setCondition(Expression queryExpre) {
		this.condition = queryExpre.toBson();
		return this;
	}

	public FindBuilder<T> addSort(String field, boolean asc) {
		if (StringUtils.isNotBlank(field)) {
			if (this.sort == null) {
				this.sort = new Document(field, Integer.valueOf(asc ? 1 : -1));
			} else {
				this.sort.put(field, Integer.valueOf(asc ? 1 : -1));
			}
		}

		return this;
	}

	public FindBuilder<T> addSort(String[] fields, boolean[] ascs) {
		if (fields.length != ascs.length) {
			throw new MongoDataException(" params length is not equal");
		} else {
			for (int i = 0; i < fields.length; ++i) {
				this.addSort(fields[i], ascs[i]);
			}

			return this;
		}
	}

	public FindBuilder<T> addSortByMetaTextSocre() {
		if (this.sort == null) {
			this.sort = new Document("score", new Document("$meta", "textScore"));
		} else {
			this.sort.put("score", new Document("$meta", "textScore"));
		}

		return this;
	}

	public FindBuilder<T> setFrom(int from) {
		if (from < 0) {
			from = 0;
		}

		this.from = from;
		return this;
	}

	public FindBuilder<T> setSize(int limit) {
		this.size = Integer.valueOf(limit);
		return this;
	}

	public FindBuilder<T> setIncludeFields(String... fieldNames) {
		this.projection = (new Projection()).addIncludeField(fieldNames).toBson();
		return this;
	}

	public FindBuilder<T> setProjection(Projection projection) {
		this.projection = projection.toBson();
		return this;
	}

	public Class<T> getMapping() {
		return this.mapping;
	}

	public Bson getQueryCondition() {
		return (Bson) (this.condition != null ? this.condition : new BsonDocument());
	}

	public Bson getProjection() {
		return this.projection;
	}

	public Document getSort() {
		return this.sort;
	}

	public int getFrom() {
		return this.from;
	}

	public Integer getSize() {
		return this.size;
	}

	public String getCollectionName() {
		return this.collectionName;
	}
}