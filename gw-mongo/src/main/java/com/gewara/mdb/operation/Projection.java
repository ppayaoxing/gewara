/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.operation;

import com.gewara.mdb.operation.Expression;
import com.mongodb.client.model.Projections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bson.conversions.Bson;

public class Projection {
	protected final List<Bson> returnResult = new ArrayList();

	public Projection addIncludeField(String... fieldNames) {
		this.returnResult.add(Projections.include(fieldNames));
		return this;
	}

	public Projection addIncludeField(List<String> fieldNames) {
		this.returnResult.add(Projections.include(fieldNames));
		return this;
	}

	public Projection addExcludeField(String... fieldNames) {
		this.returnResult.add(Projections.exclude(fieldNames));
		return this;
	}

	public Projection addExcludeField(List<String> fieldNames) {
		this.returnResult.add(Projections.exclude(fieldNames));
		return this;
	}

	public Projection addFields(Map<String, Integer> fields) {
		if (fields != null && !fields.isEmpty()) {
			ArrayList exclude = new ArrayList();
			ArrayList include = new ArrayList();
			Iterator arg3 = fields.entrySet().iterator();

			while (arg3.hasNext()) {
				Entry entry = (Entry) arg3.next();
				if (((Integer) entry.getValue()).intValue() < 0) {
					exclude.add(entry.getKey());
				} else if (((Integer) entry.getValue()).intValue() > 0) {
					include.add(entry.getKey());
				}
			}

			if (!exclude.isEmpty()) {
				this.addExcludeField((List) exclude);
			}

			if (!include.isEmpty()) {
				this.addIncludeField((List) include);
			}

			return this;
		} else {
			return this;
		}
	}

	public Projection addExcludeId() {
		this.returnResult.add(Projections.excludeId());
		return this;
	}

	public Projection addPosition4Array(String fieldName) {
		this.returnResult.add(Projections.elemMatch(fieldName));
		return this;
	}

	public Projection addElemMatch4Array(String fieldName, Expression condition) {
		this.returnResult.add(Projections.elemMatch(fieldName, condition.toBson()));
		return this;
	}

	public Projection addMetaTextScore(String fieldName) {
		this.returnResult.add(Projections.metaTextScore(fieldName));
		return this;
	}

	public Projection addSlice4Array(String fieldName, int limit) {
		this.returnResult.add(Projections.slice(fieldName, limit));
		return this;
	}

	public Projection addSlice4Array(String fieldName, int from, int limit) {
		this.returnResult.add(Projections.slice(fieldName, from, limit));
		return this;
	}

	public Bson toBson() {
		return Projections.fields(this.returnResult);
	}
}