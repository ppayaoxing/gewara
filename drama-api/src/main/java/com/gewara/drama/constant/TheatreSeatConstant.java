/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.constant;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreSeatConstant implements Serializable {
	private static final long serialVersionUID = -3625538381513198225L;
	public static final String STATUS_NEW = "A";
	public static final String STATUS_SELLING = "W";
	public static final String STATUS_SOLD = "S";
	public static final String STATUS_LOCKB = "B";
	public static final String STATUS_LOCKC = "C";
	public static final String STATUS_LOCKD = "D";
	public static final String SEATMAP_KEY = "ODI_AREA_SEATMAP_";
	public static final String SEATMAP_UPDATE = "ODI_AREA_SEATMAP_UPDATE_";
	private static final Map<String, String> statusTextMap = new HashMap();
	public static final List<String> STATUS_LOCK_LIST = Arrays.asList(new String[] { "B", "C", "D" });

	static {
		statusTextMap.put("B", "场馆售出锁定");
		statusTextMap.put("C", "保留座位锁定");
		statusTextMap.put("D", "赠票锁定");
	}
}