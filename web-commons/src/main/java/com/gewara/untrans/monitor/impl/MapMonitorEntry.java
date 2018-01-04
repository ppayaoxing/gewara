package com.gewara.untrans.monitor.impl;

import com.gewara.Config;
import com.gewara.untrans.monitor.MonitorEntry;
import com.google.common.collect.Maps;

import java.util.Map;

public class MapMonitorEntry implements MonitorEntry{
	public static final String HEADER_KEY = "__header__";
	private Map<String, String> rowdata;
	private Map<String, String> headMap;
	private String datatype;
	private byte[] rowid;
	@Override
	public byte[] getRowid() {
		return rowid;
	}
	public MapMonitorEntry(String datatype, Map<String, String> rowdata){
		this.datatype = datatype;
		this.rowdata = Maps.newHashMap(rowdata);
		this.rowdata.put(KEY_COLUMN_DATATYPE, datatype);
		this.rowdata.put("systemid", Config.SYSTEMID);
		this.rowdata.put("fromhost", Config.getHostname());
	}
	public MapMonitorEntry(String datatype, byte[] rowid, Map<String, String> rowdata){
		this(datatype, rowdata);
		this.rowid = rowid;
	}
	@Override
	public String getDatatype() {
		return datatype;
	}
	@Override
	public Map<String, String> getDataMap() {
		return rowdata;
	}
	@Override
    public Map<String, String> getHeadMap() {
		return headMap;
	}
	public void setHeadMap(Map<String, String> headMap) {
		this.headMap = headMap;
	}
}
