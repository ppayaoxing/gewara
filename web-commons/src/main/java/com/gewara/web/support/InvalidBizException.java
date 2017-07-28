/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

public class InvalidBizException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidBizException() {
	}

	public InvalidBizException(String msg) {
		super(msg);
	}
}