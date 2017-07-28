/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase.util;

import com.gewara.util.JsonUtils;
import com.gewara.util.Util4Script;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.util.Bytes;

public class FilterBuilder implements Util4Script {
	public static final byte[] DEFAULT_COLUMN_FAMILY = "DF".getBytes();
	byte[] startRow;
	byte[] stopRow;
	Long minStamp;
	Long maxStamp;
	private List<Filter> filters = new ArrayList();
	private List<FilterBuilder> fbList = new ArrayList();
	private FilterBuilder.Logic logic;
	private Set<String> conditionFields = new LinkedHashSet();
	private List<String> queryStrList = new ArrayList();
	private boolean filterIfMissing = true;
	private byte[] columnFamily;

	public FilterBuilder setTimeRange(Long minTime, Long maxTime) {
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

	public FilterBuilder setStartRowByHex(String hexid) throws IllegalArgumentException {
		try {
			this.startRow = Hex.decodeHex(hexid.toCharArray());
			return this;
		} catch (DecoderException arg2) {
			throw new IllegalArgumentException(arg2);
		}
	}

	public FilterBuilder setStopRowByHex(String hexid) throws IllegalArgumentException {
		try {
			this.stopRow = Hex.decodeHex(hexid.toCharArray());
			return this;
		} catch (DecoderException arg2) {
			throw new IllegalArgumentException(arg2);
		}
	}

	public static FilterBuilder buildFromMap(Map<String, String> query) {
		FilterBuilder fb = new FilterBuilder();
		if (query != null && !query.isEmpty()) {
			Iterator arg1 = query.entrySet().iterator();

			while (arg1.hasNext()) {
				Entry entry = (Entry) arg1.next();
				fb.eq((String) entry.getKey(), (String) entry.getValue());
			}
		}

		return fb;
	}

	public static FilterBuilder buildFromMap(Map<String, String> query, Map<String, String> likeQuery) {
		FilterBuilder fb = new FilterBuilder();
		Iterator arg2;
		Entry entry;
		if (query != null && !query.isEmpty()) {
			arg2 = query.entrySet().iterator();

			while (arg2.hasNext()) {
				entry = (Entry) arg2.next();
				fb.eq((String) entry.getKey(), (String) entry.getValue());
			}
		}

		if (likeQuery != null) {
			arg2 = likeQuery.entrySet().iterator();

			while (arg2.hasNext()) {
				entry = (Entry) arg2.next();
				fb.like((String) entry.getKey(), (String) entry.getValue());
			}
		}

		return fb;
	}

	public static FilterBuilder buildFromJson(String queryJson, String likeJson) {
		Map query = JsonUtils.readJsonToMap(queryJson);
		Map likeQuery = JsonUtils.readJsonToMap(likeJson);
		return buildFromMap(query, likeQuery);
	}

	public FilterBuilder() {
		this.columnFamily = DEFAULT_COLUMN_FAMILY;
		this.logic = FilterBuilder.Logic.AND;
	}

	public FilterBuilder(boolean filterIfMissing) {
		this.columnFamily = DEFAULT_COLUMN_FAMILY;
		this.filterIfMissing = filterIfMissing;
	}

	public FilterBuilder gt(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key),
				CompareOp.GREATER, Bytes.toBytes(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		return this;
	}

	public FilterBuilder gte(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key),
				CompareOp.GREATER_OR_EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		this.appendQueryStr(key, "gte", value);
		return this;
	}

	public FilterBuilder lt(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key), CompareOp.LESS,
				Bytes.toBytes(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		this.appendQueryStr(key, "lt", value);
		return this;
	}

	public FilterBuilder lte(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key),
				CompareOp.LESS_OR_EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		this.appendQueryStr(key, "lte", value);
		return this;
	}

	public FilterBuilder eq(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key), CompareOp.EQUAL,
				Bytes.toBytes(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		this.appendQueryStr(key, "eq", value);
		return this;
	}

	public FilterBuilder ne(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key),
				CompareOp.NOT_EQUAL, Bytes.toBytes(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		this.appendQueryStr(key, "ne", value);
		return this;
	}

	public FilterBuilder like(String key, String value) {
		SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key), CompareOp.EQUAL,
				new SubstringComparator(value));
		f.setFilterIfMissing(this.filterIfMissing);
		this.conditionFields.add(key);
		this.filters.add(f);
		this.appendQueryStr(key, "like", value);
		return this;
	}

	public FilterBuilder in(String key, String... values) {
		this.conditionFields.add(key);
		FilterList filterList = new FilterList(Operator.MUST_PASS_ONE);
		String[] arg3 = values;
		int arg4 = values.length;

		for (int arg5 = 0; arg5 < arg4; ++arg5) {
			String value = arg3[arg5];
			SingleColumnValueFilter f = new SingleColumnValueFilter(this.columnFamily, Bytes.toBytes(key),
					CompareOp.EQUAL, new SubstringComparator(value));
			f.setFilterIfMissing(this.filterIfMissing);
			filterList.addFilter(f);
		}

		this.filters.add(filterList);
		this.appendQueryStr(key, "in", "[" + StringUtils.join(values, ",") + "]");
		return this;
	}

	public FilterBuilder join(FilterBuilder fb) {
		this.fbList.add(fb);
		this.appendQueryStr("join", "join", fb.gainQueryStr());
		return this;
	}

	public FilterList buildFilters() {
		FilterList filterList = null;
		if (this.logic.equals(FilterBuilder.Logic.OR)) {
			filterList = new FilterList(Operator.MUST_PASS_ONE, this.filters);
		} else {
			filterList = new FilterList(this.filters);
		}

		Iterator arg1 = this.fbList.iterator();

		while (arg1.hasNext()) {
			FilterBuilder fb = (FilterBuilder) arg1.next();
			filterList.addFilter(fb.buildFilters());
		}

		return filterList;
	}

	public boolean isEmptyCondition() {
		return this.filters.isEmpty();
	}

	public List<String> getConditionFields() {
		return new ArrayList(this.conditionFields);
	}

	private void appendQueryStr(String key, String op, String value) {
		this.queryStrList.add("{" + key + " $" + op + " " + value + "}");
	}

	public String gainQueryStr() {
		return StringUtils.join(this.queryStrList, " " + this.logic.name() + " ");
	}

	public byte[] getStartRow() {
		return this.startRow;
	}

	public byte[] getStopRow() {
		return this.stopRow;
	}

	public static enum Logic {
		AND, OR;
	}
}