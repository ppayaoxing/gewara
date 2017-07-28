/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.constant;

public enum MCategory {
	SYS, INTERACT, INSTANT, RECOMMEND, COMMENT;

	private int value = 0;

	public int value() {
		return this.value;
	}

	public static MCategory valueOf(int value) {
		switch (value) {
		case 1:
			return SYS;
		case 2:
			return INTERACT;
		case 3:
			return INSTANT;
		case 4:
			return RECOMMEND;
		case 5:
			return COMMENT;
		}
		return null;
	}
}