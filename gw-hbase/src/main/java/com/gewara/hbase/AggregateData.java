/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import com.gewara.hbase.util.GroupFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class AggregateData {
	private List<String> groupByColumns;
	private List<String> sumColumns;
	private List<String> groupColumnValues;
	private Map<String, Map<String, Long>> rowDataMap = new HashMap();

	public AggregateData(GroupFields gf) {
		this.groupByColumns = gf.getGroupByColumns();
		this.groupColumnValues = new ArrayList();
		if (gf.getSumColumns() != null) {
			this.sumColumns = gf.getSumColumns();
		} else {
			this.sumColumns = new ArrayList(0);
		}

	}

	public Map<String, Long> getCountValue(String groupColumnValue) {
		return (Map) this.rowDataMap.get(groupColumnValue);
	}

	public void processRow(Map<String, String> rowData) {
		String key = "";

		int i;
		for (i = 0; i < this.groupByColumns.size() - 1; ++i) {
			key = key + (String) rowData.get(this.groupByColumns.get(i)) + "@@";
		}

		key = key + (String) rowData.get(this.groupByColumns.get(i));
		Object groupData = (Map) this.rowDataMap.get(key);
		if (groupData == null) {
			groupData = new LinkedHashMap();
			((Map) groupData).put("rowcount", Long.valueOf(1L));
			this.rowDataMap.put(key, groupData);
			this.groupColumnValues.add(key);
		} else {
			((Map) groupData).put("rowcount",
					Long.valueOf(((Long) ((Map) groupData).get("rowcount")).longValue() + 1L));
		}

		if (!this.sumColumns.isEmpty()) {
			Iterator arg4 = this.sumColumns.iterator();

			while (arg4.hasNext()) {
				String column = (String) arg4.next();
				String v = (String) rowData.get(column);
				if (StringUtils.isNotBlank(v) && StringUtils.isNumeric(v)) {
					Long old = (Long) ((Map) groupData).get(column);
					if (old == null) {
						((Map) groupData).put(column, Long.valueOf(Double.valueOf(v).longValue()));
					} else {
						((Map) groupData).put(column, Long.valueOf(old.longValue() + Double.valueOf(v).longValue()));
					}
				}
			}
		}

	}

	public List<String> getSumColumns() {
		return this.sumColumns;
	}

	public List<String> getGroupByColumns() {
		return this.groupByColumns;
	}

	public List<String> getGroupColumnValues() {
		return this.groupColumnValues;
	}

	public List<String> getHeaderColumns() {
		ArrayList result = new ArrayList(this.groupByColumns);
		result.addAll(this.sumColumns);
		result.add("rowcount");
		return result;
	}

	public Iterator<List<Object>> dataIterator() {
		return new AggregateData.DataIterator();
	}

	public Map<String, Map<String, Long>> getRowDataMap() {
		return this.rowDataMap;
	}

	private class DataIterator implements Iterator<List<Object>> {
		Iterator<String> rows;

		private DataIterator() {
			this.rows = AggregateData.this.groupColumnValues.iterator();
		}

		public boolean hasNext() {
			return this.rows.hasNext();
		}

		public List<Object> next() {
			ArrayList result = new ArrayList();
			String groupStr = (String) this.rows.next();
			String[] groupV = groupStr.split("@@");

			int i;
			for (i = 0; i < AggregateData.this.groupByColumns.size(); ++i) {
				result.add(groupV[i]);
			}

			Map rowData = (Map) AggregateData.this.rowDataMap.get(groupStr);

			for (Iterator arg5 = AggregateData.this.sumColumns.iterator(); arg5.hasNext(); ++i) {
				String sum = (String) arg5.next();
				result.add(rowData.get(sum));
			}

			result.add(rowData.get("rowcount"));
			return result;
		}

		public void remove() {
			throw new IllegalArgumentException("notSupport!");
		}
	}
}