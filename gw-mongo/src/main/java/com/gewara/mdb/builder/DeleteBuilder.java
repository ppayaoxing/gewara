/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.operation.Expression;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

public class DeleteBuilder {
	private Bson condition = null;
	private boolean deleteOne = false;
	private Bson ids = null;
	private String collectionName = null;

	public DeleteBuilder(String collectionName) {
		this.collectionName = collectionName;
	}

	public DeleteBuilder setCondition(Expression queryExpre) {
		this.condition = queryExpre.toBson();
		return this;
	}

	public DeleteBuilder setDeleteOne(boolean removeFirst) {
		this.deleteOne = removeFirst;
		return this;
	}

	public Bson getQueryCondition() {
		return (Bson) (this.ids != null ? this.ids : (this.condition != null ? this.condition : new BsonDocument()));
	}

	public boolean isDeleteOne() {
		return this.deleteOne;
	}

	public Bson getIds() {
		return this.ids;
	}

	public String getCollectionName() {
		return this.collectionName;
	}
}