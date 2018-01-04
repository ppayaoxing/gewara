package com.gewara.untrans.hbase.impl;

import java.util.List;
import java.util.Map;

import com.gewara.hbase.Row;
import com.gewara.untrans.hbase.HBaseService;

public class HBaseServiceImpl extends com.gewara.hbase.impl.HBaseServiceImpl implements HBaseService {

	@Override
	public List<Map<String, String>> getRowListByIdRange(String tableSmsrecordhis, Object fb, Object startRowId,
			byte[] startRowId2, byte[] endRowId, int maxnum) {
		// TODO 暂定
		return null;
	}

	/**
	 * TODO 暂定
	 */
	@Override
	public void saveRowListByString(String tableName, final String idName, final List<Map<String, String>> rowList) {
		super.saveRowListByStrId(tableName, idName, rowList);
	}

	/**
	 * TODO 暂定
	 */
	@Override
	public Map<String, String> getRow(String tablename, byte[] rowid) {
		Row row = super.getRowById(tablename, rowid);
		return row.getData();
	}

}
