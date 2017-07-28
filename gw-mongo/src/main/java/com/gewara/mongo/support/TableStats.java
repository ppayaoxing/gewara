/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.support;

public class TableStats {
	private String namespace;
	private long starttime;
	private int queryCount;
	private int updateCount;
	private int removeCount;

	public TableStats() {
	}

	public TableStats(String namespace) {
		this.starttime = System.currentTimeMillis();
		this.namespace = namespace;
	}

	public String getNamespace() {
		return this.namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public long getStarttime() {
		return this.starttime;
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public int getQueryCount() {
		return this.queryCount;
	}

	public void setQueryCount(int queryCount) {
		this.queryCount = queryCount;
	}

	public int getUpdateCount() {
		return this.updateCount;
	}

	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}

	public void addQuery() {
		++this.queryCount;
	}

	public void addUpdate() {
		++this.updateCount;
	}

	public void addRemove() {
		++this.removeCount;
	}

	public int total() {
		return this.queryCount + this.updateCount + this.removeCount;
	}

	public void reset() {
		this.starttime = System.currentTimeMillis();
		this.queryCount = 0;
		this.updateCount = 0;
		this.removeCount = 0;
	}
}