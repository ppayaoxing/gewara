package com.gewara.hbase;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
/**
 * 描述数据的一行
 *
 */
public class Row {
	private byte[] rowid;
	private Map<String, String> data;
	public Row(){
		
	}
	public Row(byte[] rowid){
		this.rowid = rowid;
	}
	public Row(byte[] rowid, Map<String, String> data){
		this.rowid = rowid;
		this.data = data;
	}
	
	public byte[] getRowid() {
		return rowid;
	}
	public void setRowid(byte[] rowid) {
		this.rowid = rowid;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getHexid() {
		return Hex.encodeHexString(rowid);
	}
	public Map<String, String> getFullData(){
		Map<String, String> full = new LinkedHashMap<>(data);
		full.put("rowid", getHexid());
		return full;
	}
}
