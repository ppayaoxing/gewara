/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity;

import com.gewara.msearch.external.constant.DataType;
import java.io.Serializable;
import java.util.List;

public class QueryResult<T> implements Serializable {
	private static final long serialVersionUID = -6663542665736120614L;
	private DataType dataType = null;
	private List<T> dataIDs = null;
	private long total = 0L;

	public DataType getDataType() {
		return this.dataType;
	}

	public List<T> getDataIDs() {
		return this.dataIDs;
	}

	public long getTotal() {
		return this.total;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public void setDataIDs(List<T> dataIDs) {
		this.dataIDs = dataIDs;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}