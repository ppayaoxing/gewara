package com.gewara.hbase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.hbase.util.GroupFields;

/**
 * example select ip,apiname,count(1),sum(totalcount) from apilog group by ip,apiname
 */
public class AggregateData {
	private List<String> groupByColumns;	//分组字段：ip,apiname
	private List<String> sumColumns;			//求和字段：totalcount
	private List<String> groupColumnValues;	//rowValues, 123.12.34.56@@com.gewara.service.getUser
	private Map<String/*groupColumnValue*/, Map<String, Long>/*{rowcount:10,totalcount:500}*/> rowDataMap;
	
	public AggregateData(GroupFields gf){
		this.rowDataMap = new HashMap<String, Map<String, Long>>();
		this.groupByColumns = gf.getGroupByColumns();
		this.groupColumnValues = new ArrayList<String>();
		if(gf.getSumColumns()!=null){
			this.sumColumns = gf.getSumColumns();
		}else{
			this.sumColumns = new ArrayList<String>(0);
		}
	}

	public Map<String, Long> getCountValue(String groupColumnValue) {
		return rowDataMap.get(groupColumnValue);
	}
	public void processRow(Map<String, String> rowData){
		String key = "";
		int i = 0;
		for (; i < groupByColumns.size() - 1; i++) {
			key += rowData.get(groupByColumns.get(i)) + "@@";
		}
		key += rowData.get(groupByColumns.get(i));
		Map<String, Long> groupData = rowDataMap.get(key);
		if(groupData==null){
			groupData = new LinkedHashMap<String, Long>();
			groupData.put("rowcount", 1L);
			rowDataMap.put(key, groupData);
			groupColumnValues.add(key);
		}else{
			groupData.put("rowcount", groupData.get("rowcount").longValue() + 1);
		}
		
		if(!sumColumns.isEmpty()){
			for(String column: sumColumns){
				String v = rowData.get(column);
				if(StringUtils.isNotBlank(v) && StringUtils.isNumeric(v)){
					Long old = groupData.get(column);
					if(old==null){
						groupData.put(column, Double.valueOf(v).longValue());
					}else{
						groupData.put(column, old + Double.valueOf(v).longValue());
					}
				}
			}
		}
	}

	public List<String> getSumColumns() {
		return sumColumns;
	}

	public List<String> getGroupByColumns() {
		return this.groupByColumns;
	}

	public List<String> getGroupColumnValues() {
		return groupColumnValues;
	}
	public List<String> getHeaderColumns(){
		List<String> result = new ArrayList<String>(groupByColumns);
		result.addAll(sumColumns);
		result.add("rowcount");
		return result;
	}
	/**
	 * 平铺的数据：groupColumsValue,sumCount,rowcount
	 * @return
	 */
	public Iterator<List<Object>> dataIterator(){
		return new DataIterator();
	}
	private class DataIterator implements Iterator<List<Object>>{
		Iterator<String> rows = groupColumnValues.iterator();
		@Override
		public boolean hasNext() {
			return rows.hasNext();
		}

		@Override
		public List<Object> next() {
			List<Object> result = new ArrayList<Object>();
			String groupStr = rows.next();
			String[] groupV = groupStr.split("@@");
			int i=0;
			for(;i<groupByColumns.size();i++){
				result.add(groupV[i]);
			}
			Map<String, Long> rowData = rowDataMap.get(groupStr);
			for(String sum: sumColumns){
				result.add(rowData.get(sum));
				i++;
			}
			result.add(rowData.get("rowcount"));
			return result;
		}

		@Override
		public void remove() {
			throw new IllegalArgumentException("notSupport!");
		}
		
	}
	public Map<String, Map<String, Long>> getRowDataMap() {
		return this.rowDataMap;
	}
}
