/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import org.apache.hadoop.hbase.client.Result;

public interface RowCallback {
	void doInRow(Result arg0) throws Exception;
}