package com.gewara.hbase.util;

import java.util.List;

import com.gewara.util.Util4Script;

public class GroupFields implements Util4Script {
	private List<String> groupByColumns;
	private List<String> sumColumns;
	private List<String> avgColumns;
	private List<String> maxColumns;
	private List<String> minColumns;
	public List<String> getGroupByColumns() {
		return groupByColumns;
	}
	public GroupFields setGroupByColumns(List<String> groupByColumns) {
		this.groupByColumns = groupByColumns;
		return this;
	}
	public List<String> getSumColumns() {
		return sumColumns;
	}
	public GroupFields setSumColumns(List<String> sumColumns) {
		this.sumColumns = sumColumns;
		return this;
	}
	public List<String> getAvgColumns() {
		return avgColumns;
	}
	public GroupFields setAvgColumns(List<String> avgColumns) {
		this.avgColumns = avgColumns;
		return this;
	}
	public List<String> getMaxColumns() {
		return maxColumns;
	}
	public GroupFields setMaxColumns(List<String> maxColumns) {
		this.maxColumns = maxColumns;
		return this;
	}
	public List<String> getMinColumns() {
		return minColumns;
	}
	public GroupFields setMinColumns(List<String> minColumns) {
		this.minColumns = minColumns;
		return this;
	}
	public boolean hasEmpty(){
		return groupByColumns == null || groupByColumns.size() == 0;
	}
	
}
