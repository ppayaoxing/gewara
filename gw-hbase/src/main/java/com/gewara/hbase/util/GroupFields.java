/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase.util;

import com.gewara.util.Util4Script;
import java.util.List;

public class GroupFields implements Util4Script {
	private List<String> groupByColumns;
	private List<String> sumColumns;
	private List<String> avgColumns;
	private List<String> maxColumns;
	private List<String> minColumns;

	public List<String> getGroupByColumns() {
		return this.groupByColumns;
	}

	public GroupFields setGroupByColumns(List<String> groupByColumns) {
		this.groupByColumns = groupByColumns;
		return this;
	}

	public List<String> getSumColumns() {
		return this.sumColumns;
	}

	public GroupFields setSumColumns(List<String> sumColumns) {
		this.sumColumns = sumColumns;
		return this;
	}

	public List<String> getAvgColumns() {
		return this.avgColumns;
	}

	public GroupFields setAvgColumns(List<String> avgColumns) {
		this.avgColumns = avgColumns;
		return this;
	}

	public List<String> getMaxColumns() {
		return this.maxColumns;
	}

	public GroupFields setMaxColumns(List<String> maxColumns) {
		this.maxColumns = maxColumns;
		return this;
	}

	public List<String> getMinColumns() {
		return this.minColumns;
	}

	public GroupFields setMinColumns(List<String> minColumns) {
		this.minColumns = minColumns;
		return this;
	}

	public boolean hasEmpty() {
		return this.groupByColumns == null || this.groupByColumns.size() == 0;
	}
}