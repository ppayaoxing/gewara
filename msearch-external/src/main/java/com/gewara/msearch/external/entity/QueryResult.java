package com.gewara.msearch.external.entity;

import java.io.Serializable;
import java.util.List;

import com.gewara.msearch.external.constant.DataType;

public class QueryResult<T> implements Serializable {
	private static final long serialVersionUID = -6663542665736120614L;

	private DataType dataType = null;
	private List<T> dataIDs = null;
	private long total = 0;

	public DataType getDataType() {
		return dataType;
	}

	public List<T> getDataIDs() {
		return dataIDs;
	}

	public long getTotal() {
		return total;
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
