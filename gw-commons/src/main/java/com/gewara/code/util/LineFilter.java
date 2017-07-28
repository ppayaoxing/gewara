/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.code.util;

import java.util.regex.Pattern;

public abstract class LineFilter {
	public static LineFilter ACCEPT_ALL_FILTER = new LineFilter() {
		public boolean accept(String line) {
			return true;
		}
	};

	public abstract boolean accept(String arg0);

	public static class RegFilter extends LineFilter {
		private Pattern pattern = null;

		public RegFilter(String regexp) {
			this.pattern = Pattern.compile(regexp, 2);
		}

		public boolean accept(String line) {
			return this.pattern.matcher(line).find();
		}
	}
}