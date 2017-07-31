package com.gewara.hbase.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

import com.gewara.util.JsonUtils;
import com.gewara.util.Util4Script;

public class FilterBuilder implements Util4Script {
	public static final byte[] DEFAULT_COLUMN_FAMILY = "DF".getBytes();
	public static enum Logic {AND, OR};

	byte[] startRow;
	byte[] stopRow;
	//时间戳范围
	Long minStamp;
	Long maxStamp;

	
	private List<Filter> filters = new ArrayList<Filter>();
	private List<FilterBuilder> fbList = new ArrayList<FilterBuilder>();
	private Logic logic;
	//all fields used in filter
	private Set<String> conditionFields = new LinkedHashSet<String>();
	private List<String> queryStrList = new ArrayList<String>();
	
	/**
	 * @see SingleColumnValueFilter#setFilterIfMissing(boolean)
	 */
	private boolean filterIfMissing = true;
	private byte[] columnFamily = DEFAULT_COLUMN_FAMILY;
	/**
	 * 数据的时间戳，两个时间必须同时设置
	 * @param minTime
	 * @param maxTime
	 * @return
	 */
	public FilterBuilder setTimeRange(Long minTime, Long maxTime){
		this.minStamp = minTime;
		this.maxStamp = maxTime;
		return this;
	}
	public FilterBuilder setStartRow(byte[] startRow) {
		this.startRow = startRow;
		return this;
	}
	public FilterBuilder setStopRow(byte[] stopRow) {
		this.stopRow = stopRow;
		return this;
	}
	public FilterBuilder setStartRowByHex(String hexid) throws IllegalArgumentException{
		try {
			this.startRow = Hex.decodeHex(hexid.toCharArray());
		} catch (DecoderException e) {
			throw new IllegalArgumentException(e);
		}
		return this;
	}
	public FilterBuilder setStopRowByHex(String hexid) throws IllegalArgumentException{
		try {
			this.stopRow = Hex.decodeHex(hexid.toCharArray());
		} catch (DecoderException e) {
			throw new IllegalArgumentException(e);
		}
		return this;
	}
	public static FilterBuilder buildFromMap(Map<String, String> query){
		FilterBuilder fb = new FilterBuilder();
		if(query!=null && !query.isEmpty()){
			for(Map.Entry<String, String> entry: query.entrySet()){
				fb.eq(entry.getKey(), entry.getValue());
			}
		}
		return fb;
	}
	
	public static FilterBuilder buildFromMap(Map<String, String> query, Map<String, String> likeQuery){
		FilterBuilder fb = new FilterBuilder();
		if(query!=null && !query.isEmpty()){
			for(Map.Entry<String, String> entry: query.entrySet()){
				fb.eq(entry.getKey(), entry.getValue());
			}
		}
		if(likeQuery!=null){
			for(Map.Entry<String, String> entry: likeQuery.entrySet()){
				fb.like(entry.getKey(), entry.getValue());
			}
		}
		return fb;
	}
	
	public static FilterBuilder buildFromJson(String queryJson, String likeJson){
		Map<String, String> query = JsonUtils.readJsonToMap(queryJson);
		Map<String, String> likeQuery = JsonUtils.readJsonToMap(likeJson);
		return buildFromMap(query, likeQuery);
	}
	
	public FilterBuilder(){
		this.logic = Logic.AND;
	}
	public FilterBuilder(boolean filterIfMissing){
		this.filterIfMissing = filterIfMissing;
	}
	
	public FilterBuilder gt(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.GREATER, Bytes.toBytes(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		return this;
	}
	public FilterBuilder gte(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.GREATER_OR_EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		appendQueryStr(key,"gte", value);
		return this;
	}
	public FilterBuilder lt(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.LESS, Bytes.toBytes(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		appendQueryStr(key,"lt", value);
		return this;
	}
	public FilterBuilder lte(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.LESS_OR_EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		appendQueryStr(key,"lte", value);
		return this;
	}
	public FilterBuilder eq(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		appendQueryStr(key,"eq", value);
		return this;
	}
	public FilterBuilder ne(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.NOT_EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		appendQueryStr(key,"ne", value);
		return this;
	}
	public FilterBuilder like(String key, String value){
		SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.EQUAL, new SubstringComparator(value));
		f.setFilterIfMissing(filterIfMissing);
		conditionFields.add(key);
		filters.add(f);
		appendQueryStr(key,"like", value);
		return this;
	}
	public FilterBuilder in(String key, String... values){
		conditionFields.add(key);
		FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);
		for(String value: values){
			SingleColumnValueFilter f = new SingleColumnValueFilter(columnFamily, Bytes.toBytes(key), CompareOp.EQUAL, new SubstringComparator(value));
			f.setFilterIfMissing(filterIfMissing);
			filterList.addFilter(f);
		}
		filters.add(filterList);
		appendQueryStr(key,"in", "[" + StringUtils.join(values, ",") + "]");
		return this;
	}
	public FilterBuilder join(FilterBuilder fb){
		fbList.add(fb);
		appendQueryStr("join","join", fb.gainQueryStr());
		return this;
	}
	
	/**
	 * 输出条件
	 * @return
	 */
	public FilterList buildFilters(){
		FilterList filterList = null;
		if(this.logic.equals(Logic.OR)){
			filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE, filters);
		}else{
			filterList = new FilterList(filters);
		}
		for(FilterBuilder fb: fbList){
			filterList.addFilter(fb.buildFilters());
		}
		return filterList;
	}

	/**
	 * 没有任何条件
	 * @return
	 */
	public boolean isEmptyCondition() {
		return filters.isEmpty();
	}

	public List<String> getConditionFields() {
		return new ArrayList<String>(conditionFields);
	}
	private void appendQueryStr(String key, String op, String value){
		this.queryStrList.add("{" + key + " $" + op + " " + value + "}");
	}
	public String gainQueryStr(){
		return StringUtils.join(queryStrList, " " + logic.name() + " ");
	}
	public byte[] getStartRow() {
		return startRow;
	}
	public byte[] getStopRow() {
		return stopRow;
	}

}
