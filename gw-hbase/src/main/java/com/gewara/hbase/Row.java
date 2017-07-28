/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Hex;

public class Row {
	private byte[] rowid;
	private Map<String, String> data;

	public Row() {
	}

	public Row(byte[] rowid) {
		this.rowid = rowid;
	}

	public Row(byte[] rowid, Map<String, String> data) {
		this.rowid = rowid;
		this.data = data;
	}

	public byte[] getRowid() {
		return this.rowid;
	}

	public void setRowid(byte[] rowid) {
		this.rowid = rowid;
	}

	public Map<String, String> getData() {
		return this.data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getHexid() {
		return Hex.encodeHexString(this.rowid);
	}

	public Map<String, String> getFullData() {
		LinkedHashMap full = new LinkedHashMap(this.data);
		full.put("rowid", this.getHexid());
		return full;
	}
}