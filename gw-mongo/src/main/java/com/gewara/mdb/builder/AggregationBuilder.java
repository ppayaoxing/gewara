/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.operation.Projection;
import com.gewara.util.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

public class AggregationBuilder {
	private String collectionName = null;
	private Expression query;
	private Document group = new Document();
	private Projection projection;
	private List<Document> sortList = new ArrayList();
	private Document skip;
	private Document limit;
	private Expression having;

	public AggregationBuilder(String collectionName) {
		this.collectionName = collectionName;
	}

	public AggregationBuilder setGroupFields(String... groupBy) {
		Assert.isTrue(groupBy != null && groupBy.length > 0);
		if (groupBy.length == 1) {
			this.group.append("_id", "$" + groupBy[0]);
		} else {
			Document gr = new Document();
			String[] arg2 = groupBy;
			int arg3 = groupBy.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				String gf = arg2[arg4];
				gr.append(gf, "$" + gf);
			}

			this.group.append("_id", gr);
		}

		return this;
	}

	public AggregationBuilder setQuery(Expression qry) {
		this.query = qry;
		return this;
	}

	public AggregationBuilder setHaving(Expression hv) {
		this.having = hv;
		return this;
	}

	public AggregationBuilder addSum(String field, String alias) {
		this.group.append(alias, new Document("$sum", "$" + field));
		return this;
	}

	public AggregationBuilder addAvg(String field, String alias) {
		this.group.append(alias, new Document("$avg", "$" + field));
		return this;
	}

	public AggregationBuilder addMax(String field, String alias) {
		this.group.append(alias, new Document("$max", "$" + field));
		return this;
	}

	public AggregationBuilder addMin(String field, String alias) {
		this.group.append(alias, new Document("$min", "$" + field));
		return this;
	}

	public AggregationBuilder addCount(String alias) {
		this.group.append(alias, new Document("$sum", Integer.valueOf(1)));
		return this;
	}

	public AggregationBuilder addSort(String field, boolean asc) {
		this.sortList.add(new Document("$sort", new Document(field, Integer.valueOf(asc ? 1 : -1))));
		return this;
	}

	public AggregationBuilder setLimit(Integer from, Integer size) {
		if (from != null) {
			this.skip = new Document("$skip", from);
		}

		if (size != null) {
			this.limit = new Document("$limit", size);
		}

		return this;
	}

	public AggregationBuilder setProjection(Projection projection) {
		this.projection = projection;
		return this;
	}

	public String getCollectionName() {
		return this.collectionName;
	}

	public List<Bson> build() {
		ArrayList pipeLine = new ArrayList();
		if (this.query != null) {
			pipeLine.add(new Document("$match", this.query.toBson()));
		}

		pipeLine.add(new Document("$group", this.group));
		if (this.projection != null) {
			pipeLine.add(new Document("$project", this.projection.toBson()));
		}

		Iterator arg1 = this.sortList.iterator();

		while (arg1.hasNext()) {
			Document sort = (Document) arg1.next();
			pipeLine.add(sort);
		}

		if (this.having != null) {
			pipeLine.add(new Document("$match", this.having.toBson()));
		}

		if (this.skip != null) {
			pipeLine.add(this.skip);
		}

		if (this.limit != null) {
			pipeLine.add(this.limit);
		}

		return pipeLine;
	}
}