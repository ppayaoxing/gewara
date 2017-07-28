/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import com.gewara.hbase.Row;

public interface RowDataCallback {
	void processRow(Row arg0) throws Exception;
}