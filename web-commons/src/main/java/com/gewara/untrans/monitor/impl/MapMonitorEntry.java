/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.Config;
import com.gewara.untrans.monitor.MonitorEntry;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapMonitorEntry implements MonitorEntry {
	public static final String HEADER_KEY = "__header__";
	private Map<String, String> rowdata;
	private Map<String, String> headMap;
	private String datatype;
	private byte[] rowid;

	public byte[] getRowid() {
		return this.rowid;
	}

	public MapMonitorEntry(String datatype, Map<String, String> rowdata) {
		this.datatype = datatype;
		this.rowdata = new LinkedHashMap(rowdata);
		this.rowdata.put("datatype", datatype);
		this.rowdata.put("systemid", Config.SYSTEMID);
		this.rowdata.put("fromhost", Config.getHostname());
	}

	public MapMonitorEntry(String datatype, byte[] rowid, Map<String, String> rowdata) {
		this(datatype, rowdata);
		this.rowid = rowid;
	}

	public String getDatatype() {
		return this.datatype;
	}

	public Map<String, String> getDataMap() {
		return this.rowdata;
	}

	public Map<String, String> getHeadMap() {
		return this.headMap;
	}

	public void setHeadMap(Map<String, String> headMap) {
		this.headMap = headMap;
	}
}