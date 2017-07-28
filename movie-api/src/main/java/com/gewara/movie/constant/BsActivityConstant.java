/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.constant;

public class BsActivityConstant {
	public static final String ENABLE = "Y";
	public static final String DISABLE = "N";
	public static final String ACTTYPE_BS = "bs";
	public static final String ACTTYPE_SMS = "sms";
	public static final String PRINTPAPER_Y = "Y";
	public static final String PRINTPAPER_N = "N";
	public static final String TAG_BSCARD_SMS = "sms";
	public static final String TAG_BSCARD_BS = "bs";
	public static final String BS_ACTIVITYID = "bsActivityid";

	public static final String getBsCounterKey(Long bsid) {
		return "BSACTIVITYSMSSOUNTER" + bsid;
	}
}