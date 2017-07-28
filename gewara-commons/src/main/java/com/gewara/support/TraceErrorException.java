/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

public class TraceErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TraceErrorException(String msg) {
		super(msg);
	}

	public TraceErrorException(String msg, Throwable e) {
		super(msg, e);
	}
}