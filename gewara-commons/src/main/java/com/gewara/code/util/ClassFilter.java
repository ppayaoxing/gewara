/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.code.util;

public interface ClassFilter {
	ClassFilter ACCEPT_ALL = new ClassFilter() {
		public boolean accept(Class clazz) {
			return true;
		}
	};

	boolean accept(Class arg0);
}