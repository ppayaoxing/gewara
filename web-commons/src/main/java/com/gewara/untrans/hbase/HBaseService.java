package com.gewara.untrans.hbase;

import java.util.List;
import java.util.Map;

public interface HBaseService extends com.gewara.hbase.HBaseService {
	/**
	 * 保存记录
	 * 
	 * @param tableSmsrecordhis
	 * @param fb
	 * @param startRowId
	 * @param startRowId2
	 * @param endRowId
	 * @param maxnum
	 * @return
	 */
	List<Map<String, String>> getRowListByIdRange(String tableSmsrecordhis, Object fb, Object startRowId,
			byte[] startRowId2, byte[] endRowId, int maxnum);

	void saveRowListByString(String tablename, String idName, List<Map<String, String>> rowList);

	/**
	 * 获取记录
	 * 
	 * @param tablename
	 * @param rowid
	 * @return
	 */
	Map<String, String> getRow(String tablename, byte[] rowid);

}
