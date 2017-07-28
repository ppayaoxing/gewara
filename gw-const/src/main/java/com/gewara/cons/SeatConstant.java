/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SeatConstant {
	public static final String STATUS_NEW = "A";
	public static final String STATUS_SELLING = "W";
	public static final String STATUS_SOLD = "S";
	public static final String STATUS_LOCKB = "B";
	public static final String STATUS_LOCKC = "C";
	public static final String STATUS_LOCKD = "D";
	public static final String STATUS_LOCKZ = "Z";
	public static final String STATUS_LOCKM = "M";
	public static final String STATUS_LOCKG = "G";
	public static final String STATUS_LOCK_REMOTE = "R";
	private static final Map<String, String> statusTextMap = new HashMap();
	public static final List<String> STATUS_LOCK_LIST;
	public static final List<String> STATUS_LOCK_LIST2;

	static {
		statusTextMap.put("B", "影院售出锁定");
		statusTextMap.put("C", "保留座位锁定");
		statusTextMap.put("D", "赠票锁定");
		statusTextMap.put("Z", "影院维修锁定");
		STATUS_LOCK_LIST = Arrays.asList(new String[] { "B", "C", "D" });
		STATUS_LOCK_LIST2 = Arrays.asList(new String[] { "B", "C", "D", "Z" });
	}
}