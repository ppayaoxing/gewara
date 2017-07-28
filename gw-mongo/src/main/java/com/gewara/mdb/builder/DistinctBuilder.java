/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.operation.Expression;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

public class DistinctBuilder {
	private Bson condition = null;
	private String collectionName = null;
	private String distincField = null;
	private Bson ids = null;

	public DistinctBuilder(String collectionName) {
		this.collectionName = collectionName;
	}

	public DistinctBuilder setCondition(Expression queryExpre) {
		this.condition = queryExpre.toBson();
		return this;
	}

	public <TItem> DistinctBuilder setIDByFindOlny(TItem... ids) {
		if (ids != null) {
			this.ids = ids.length == 1 ? Filters.eq("_id", ids[0]) : Filters.in("_id", ids);
		}

		return this;
	}

	public DistinctBuilder setDistinctField(String fieldName) {
		this.distincField = fieldName;
		return this;
	}

	public Bson getQueryCondition() {
		return (Bson) (this.ids != null ? this.ids : (this.condition != null ? this.condition : new BsonDocument()));
	}

	public String getCollectionName() {
		return this.collectionName;
	}

	public String getDistincField() {
		return this.distincField;
	}

	public Bson getIds() {
		return this.ids;
	}
}