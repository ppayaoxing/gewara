/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.constant;

public enum MType {
	CINEMA, DRAMA, SPORT, OTHER;

	private int value = 0;

	public static MType valueOf(int value) {
		switch (value) {
		case 1:
			return CINEMA;
		case 2:
			return DRAMA;
		case 3:
			return SPORT;
		case 99:
			return OTHER;
		}
		return null;
	}

	public int value() {
		return this.value;
	}
}