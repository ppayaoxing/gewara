package com.gewara.hbase;

public interface RowFilter {
	boolean accept(Row row);
}
