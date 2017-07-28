/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity;

import com.gewara.msearch.external.constant.DataType;
import java.io.Serializable;

public class QueryLimit implements Serializable {
	private static final long serialVersionUID = 8742192944925589174L;
	private DataType dataType = null;
	private int limit = 3;
	private String cityID = null;

	public QueryLimit(DataType dataType) {
		this.setDataType(dataType);
	}

	public QueryLimit(DataType type, int limit) {
		this.setDataType(type);
		this.setLimit(limit);
	}

	public DataType getDataType() {
		return this.dataType;
	}

	public int getLimit() {
		return this.limit;
	}

	private void setDataType(DataType dataType) {
		assert dataType != null;

		this.dataType = dataType;
	}

	private void setLimit(int limit) {
		if ($assertionsDisabled || limit > 0 && limit < 100) {
			this.limit = limit;
		} else {
			throw new AssertionError();
		}
	}

	public String getCityID() {
		return this.cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public boolean equals(Object obj) {
		return obj == null ? false
				: (obj == this ? true : obj instanceof QueryLimit && ((QueryLimit) obj).getDataType() == this.dataType);
	}

	public int hashCode() {
		return this.dataType.hashCode();
	}
}