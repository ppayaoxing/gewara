/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase.util;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.filter.Filter.ReturnCode;
import org.apache.hadoop.hbase.util.Bytes;

public class CustomFilter extends FilterBase {
	private byte[] value = null;
	private boolean filterRow = true;

	public CustomFilter() {
	}

	public CustomFilter(byte[] value) {
		this.value = value;
	}

	public void reset() {
		this.filterRow = true;
	}

	public ReturnCode filterKeyValue(Cell kv) {
		if (Bytes.compareTo(this.value, kv.getQualifierArray()) == 0) {
			this.filterRow = false;
		}

		return ReturnCode.INCLUDE;
	}

	public boolean filterRow() {
		return this.filterRow;
	}
}