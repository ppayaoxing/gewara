/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity;

import com.gewara.msearch.external.constant.DataType;
import com.gewara.msearch.external.entity.QueryLimit;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QueryCondition implements Serializable {
	private static final long serialVersionUID = 592656313621653118L;
	private int from = 0;
	private String queryStr = null;
	private Set<QueryLimit> queryLimits = null;

	public String getQueryStr() {
		return this.queryStr;
	}

	public Set<QueryLimit> getQueryLimits() {
		return this.queryLimits;
	}

	public int getFrom() {
		return this.from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setQueryStr(String queryStr) {
		if ($assertionsDisabled || queryStr != null && queryStr.trim().length() > 0) {
			this.queryStr = queryStr;
		} else {
			throw new AssertionError();
		}
	}

	public void setQueryLimit(Set<QueryLimit> queryLimit) {
		if ($assertionsDisabled || queryLimit != null && !queryLimit.isEmpty()) {
			this.queryLimits = queryLimit;
		} else {
			throw new AssertionError();
		}
	}

	public void addQueryLimit(QueryLimit queryLimit) {
		assert queryLimit != null;

		if (this.queryLimits == null) {
			this.queryLimits = new HashSet();
		}

		this.queryLimits.add(queryLimit);
	}

	public void addQueryLimit(DataType type, int limit) {
		this.addQueryLimit(new QueryLimit(type, limit));
	}

	public boolean validate() {
		return this.queryLimits != null && !this.queryLimits.isEmpty() && this.queryStr != null
				&& this.queryStr.trim().length() != 0;
	}

	public String toString() {
		String rv = "queryStr[" + this.queryStr + "], queryLimts[";

		QueryLimit ql;
		for (Iterator arg1 = this.queryLimits.iterator(); arg1
				.hasNext(); rv = rv + ql.getDataType() + ":" + ql.getLimit() + ",") {
			ql = (QueryLimit) arg1.next();
		}

		return rv + "]";
	}
}