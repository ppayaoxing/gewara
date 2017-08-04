package com.gewara.untrans.hbase.impl;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

import com.gewara.hbase.HBaseService;
import com.gewara.hbase.HbaseData;
import com.gewara.hbase.Row;
import com.gewara.hbase.util.FilterBuilder;
import com.gewara.untrans.hbase.ChangeLogService;

public class ChangeLogServiceImpl implements ChangeLogService {

	private HBaseService hbaseService;

	public void setHbaseService(HBaseService hbaseService) {
		this.hbaseService = hbaseService;
	}

	@Override
	public void addChangeLog(String systemId, String tag, Serializable relatedid, Map<String, String> changeMap) {
		byte[] rowid = getRowId(systemId, tag, relatedid);
		hbaseService.saveRow(HbaseData.TABLE_CHANGEHIS, rowid, changeMap);
	}

	@Override
	public Map</* modifytime */Long, Map<String, String>> getChangeLogList(String systemId, String tag,
			Serializable relatedid) {
		byte[] rowid = getRowId(systemId, tag, relatedid);
		Map<Long, Map<String, String>> result = hbaseService.getMultiVersionRow(HbaseData.TABLE_CHANGEHIS, rowid, 500);
		return result;
	}

	@Override
	public List<Row> getDelLogList(String systemId, String tag, String adddate, int maxnum) {
		byte[] startRowId = getDelRowId(systemId, tag, 0);
		byte[] endRowId = getDelRowId(systemId, tag, Integer.MAX_VALUE);
		FilterBuilder fb = new FilterBuilder();
		fb.eq("adddate", adddate).eq("action", "del");
		List<Row> rowList = hbaseService.getRowListByIdRange(HbaseData.TABLE_CHANGEHIS, fb, startRowId, endRowId, null,
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
