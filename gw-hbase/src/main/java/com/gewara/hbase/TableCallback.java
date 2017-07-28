/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import org.apache.hadoop.hbase.client.Table;

public interface TableCallback<T> {
	T doWithTable(Table arg0) throws Exception;
}