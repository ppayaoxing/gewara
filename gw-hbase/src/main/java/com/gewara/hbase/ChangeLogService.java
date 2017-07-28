/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import com.gewara.hbase.Row;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ChangeLogService {
	void addChangeLog(String arg0, String arg1, Serializable arg2, Map<String, String> arg3);

	Map<Long, Map<String, String>> getChangeLogList(String arg0, String arg1, Serializable arg2);

	List<Row> getDelLogList(String arg0, String arg1, String arg2, int arg3);
}