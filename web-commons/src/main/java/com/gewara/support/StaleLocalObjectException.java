/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

public class StaleLocalObjectException extends RuntimeException {
	private static final long serialVersionUID = 3545743639343281548L;

	public StaleLocalObjectException() {
		super("local cached object cannot be saved!!");
	}
}