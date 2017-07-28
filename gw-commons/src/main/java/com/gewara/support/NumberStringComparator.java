/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

import java.util.Comparator;
import org.apache.commons.lang.StringUtils;

public class NumberStringComparator implements Comparator<String> {
	private int strlen;

	public NumberStringComparator(int strlen) {
		this.strlen = strlen;
	}

	public int compare(String str1, String str2) {
		str1 = StringUtils.leftPad(str1, this.strlen, '0');
		str2 = StringUtils.leftPad(str2, this.strlen, '0');
		return str1.compareTo(str2);
	}
}