package com.gewara.hbase;

import java.util.Map;

public interface FilterExpression {
	boolean isAccepted(Map<String, String> rowData);
}
