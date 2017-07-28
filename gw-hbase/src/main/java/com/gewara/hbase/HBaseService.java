/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import com.gewara.hbase.AggregateData;
import com.gewara.hbase.Row;
import com.gewara.hbase.RowDataCallback;
import com.gewara.hbase.RowFilter;
import com.gewara.hbase.util.FilterBuilder;
import com.gewara.hbase.util.GroupFields;
import java.util.List;
import java.util.Map;

public interface HBaseService {
	String COUNT_FLAG_HOUR = "hour";
	String COUNT_FLAG_MIN = "min";
	String COUNT_FLAG_DAY = "day";
	String COLUMN_ADDTIME = "addtime";
	int CACHE_SIZE = 500;

	void saveRow(String arg0, Map<String, String> arg1);

	void saveRow(String arg0, byte[] arg1, Map<String, String> arg2);

	void saveRow(String arg0, String arg1, Map<String, String> arg2);

	void saveRowListByStrId(String arg0, String arg1, List<Map<String, String>> arg2);

	void saveRowListByHex(String arg0, String arg1, List<Map<String, String>> arg2);

	void saveRowList(String arg0, List<Row> arg1);

	void removeRowById(String arg0, byte[] arg1);

	void removeRowByHex(String arg0, String arg1);

	void removeRowList(String arg0, List<byte[]> arg1);

	void removeRowListByHex(String arg0, String[] arg1);

	void removeRowListByHex(String arg0, List<String> arg1);

	int removeByRange(String arg0, FilterBuilder arg1, Long arg2, Long arg3, String arg4);

	boolean isAvaliable();

	Row getRowByHex(String arg0, String arg1);

	Row getRowByStrId(String arg0, String arg1);

	Row getRowById(String arg0, byte[] arg1);

	Map<Long, Map<String, String>> getMultiVersionRow(String arg0, byte[] arg1, int arg2);

	List<Map<Long, Map<String, String>>> getMultiRowListByIdRange(String arg0, int arg1, FilterBuilder arg2,
			byte[] arg3, byte[] arg4, int arg5);

	List<Row> getRowList(String arg0, FilterBuilder arg1, int arg2);

	List<Row> getRowListByHexids(String arg0, List<String> arg1);

	List<Row> getRowListByIdList(String arg0, List<byte[]> arg1);

	List<Row> getRowListByRange(String arg0, FilterBuilder arg1, Long arg2, Long arg3, RowFilter arg4, int arg5);

	List<Row> getRowListByIdRange(String arg0, FilterBuilder arg1, byte[] arg2, byte[] arg3, RowFilter arg4, int arg5);

	AggregateData getGroupData(String arg0, GroupFields arg1, FilterBuilder arg2, Long arg3, Long arg4, int arg5,
			RowFilter arg6);

	List<byte[]> getRowidListByRange(String arg0, FilterBuilder arg1, Long arg2, Long arg3, int arg4);

	List<byte[]> getRowidListByRange(String arg0, FilterBuilder arg1, Long arg2, Long arg3, int arg4, String arg5);

	void processRowListByRange(String arg0, FilterBuilder arg1, Long arg2, Long arg3, RowDataCallback arg4,
			RowFilter arg5);

	void processRowListByRowIdRange(String arg0, FilterBuilder arg1, byte[] arg2, byte[] arg3, RowDataCallback arg4,
			RowFilter arg5);

	long getRowCountByRange(String arg0, FilterBuilder arg1, Long arg2, Long arg3);

	boolean createTable(String arg0, int arg1);
}