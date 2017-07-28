/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.code.util;

import org.apache.commons.lang.StringUtils;

public class MethodLine {
	public String method;
	public Integer lineNo;
	public String callname;
	public String clazz;
	public boolean error;

	public MethodLine(String clazz, String method, Integer lineNo) {
		this.clazz = StringUtils.substringAfterLast(clazz, ".");
		this.method = method;
		this.lineNo = lineNo;
	}

	public String toString() {
		return this.callname + ",line:" + this.lineNo;
	}

	public String full() {
		return this.clazz + ":" + this.method + ",line:" + this.lineNo;
	}
}