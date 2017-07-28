/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import org.apache.hadoop.hbase.client.HTable;

public interface HBaseCallback {
	Object doInHbase(HTable arg0) throws Exception;
}