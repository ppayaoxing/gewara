/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

public class BCConvert {
	static final char DBC_CHAR_START = '!';
	static final char DBC_CHAR_END = '~';
	static final char SBC_CHAR_START = '！';
	static final char SBC_CHAR_END = '～';
	static final int CONVERT_STEP = 65248;
	static final char SBC_SPACE = '　';
	static final char DBC_SPACE = ' ';

	public static String DBC2SBC(String src) {
		if (src == null) {
			return src;
		} else {
			StringBuilder buf = new StringBuilder(src.length());
			char[] ca = src.toCharArray();

			for (int i = 0; i < ca.length; ++i) {
				if (ca[i] == 32) {
					buf.append('　');
				} else if (ca[i] >= 33 && ca[i] <= 126) {
					buf.append((char) (ca[i] + 'ﻠ'));
				} else {
					buf.append(ca[i]);
				}
			}

			return buf.toString();
		}
	}

	public static String SBC2DBC(String src) {
		if (src == null) {
			return src;
		} else {
			StringBuilder buf = new StringBuilder(src.length());
			char[] ca = src.toCharArray();

			for (int i = 0; i < src.length(); ++i) {
				if (ca[i] >= '！' && ca[i] <= '～') {
					buf.append((char) (ca[i] - 'ﻠ'));
				} else if (ca[i] == 12288) {
					buf.append(' ');
				} else {
					buf.append(ca[i]);
				}
			}

			return buf.toString();
		}
	}
}