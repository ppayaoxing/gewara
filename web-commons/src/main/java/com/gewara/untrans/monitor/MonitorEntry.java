/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import java.util.Map;

public interface MonitorEntry {
	String KEY_COLUMN_DATATYPE = "datatype";

	String getDatatype();

	byte[] getRowid();

	Map<String, String> getDataMap();

	Map<String, String> getHeadMap();
}