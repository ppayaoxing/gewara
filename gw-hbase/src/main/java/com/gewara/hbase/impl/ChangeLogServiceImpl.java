/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase.impl;

import com.gewara.hbase.ChangeLogService;
import com.gewara.hbase.HBaseService;
import com.gewara.hbase.Row;
import com.gewara.hbase.RowFilter;
import com.gewara.hbase.util.FilterBuilder;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class ChangeLogServiceImpl implements ChangeLogService {
	private HBaseService hbaseService;

	public void setHbaseService(HBaseService hbaseService) {
		this.hbaseService = hbaseService;
	}

	public void addChangeLog(String systemId, String tag, Serializable relatedid, Map<String, String> changeMap) {
		byte[] rowid = this.getRowId(systemId, tag, relatedid);
		this.hbaseService.saveRow("changehis", rowid, changeMap);
	}

	public Map<Long, Map<String, String>> getChangeLogList(String systemId, String tag, Serializable relatedid) {
		byte[] rowid = this.getRowId(systemId, tag, relatedid);
		Map result = this.hbaseService.getMultiVersionRow("changehis", rowid, 500);
		return result;
	}

	public List<Row> getDelLogList(String systemId, String tag, String adddate, int maxnum) {
		byte[] startRowId = this.getDelRowId(systemId, tag, 0);
		byte[] endRowId = this.getDelRowId(systemId, tag, Integer.MAX_VALUE);
		FilterBuilder fb = new FilterBuilder();
		fb.eq("adddate", adddate).eq("action", "del");
		List rowList = this.hbaseService.getRowListByIdRange("changehis", fb, startRowId, endRowId, (RowFilter) null,
				maxnum);
		return rowList;
	}

	private byte[] getRowId(String systemId, String tag, Serializable relatedid) {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt(systemId.hashCode());
		bb.putInt(tag.hashCode());
		bb.putInt(relatedid.toString().hashCode());
		return b;
	}

	private byte[] getDelRowId(String systemId, String tag, int i) {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt(systemId.hashCode());
		bb.putInt(tag.hashCode());
		bb.putInt(i);
		return b;
	}
}