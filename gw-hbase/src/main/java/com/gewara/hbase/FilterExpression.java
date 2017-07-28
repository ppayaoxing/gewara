/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import java.util.Map;

public interface FilterExpression {
	boolean isAccepted(Map<String, String> arg0);
}