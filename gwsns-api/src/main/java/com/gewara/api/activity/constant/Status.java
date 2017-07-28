/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.constant;

import org.apache.commons.lang.StringUtils;

public abstract class Status {
	public static final String Y = "Y";
	public static final String Y_NEW = "Y_NEW";
	public static final String Y_LOCK = "Y_LOCK";
	public static final String Y_DOWN = "Y_DOWN";
	public static final String Y_LOCK_DOWN = "Y_LD";
	public static final String Y_ANS_AUDIT = "ANS_AUDIT";
	public static final String DEL = "D";
	public static final String N = "N";
	public static final String N_LOTTERY = "N_LOTTERY";
	public static final String N_DELETE = "N_DELETE";
	public static final String N_FILTER = "N_FILTER";
	public static final String N_DELETE_M = "N_DELETE_M";
	public static final String N_NIGHT = "N_NIGHT";
	public static final String N_ACCUSE = "N_ACCUSE";
	public static final String N_ERROR = "N_ERR";
	public static final String N_AUDIT = "N_AUDIT";
	public static final String Y_STOP = "Y_STOP";
	public static final String Y_PROCESS = "Y_PROCESS";
	public static final String Y_TREAT = "Y_TREAT";
	public static final String Y_CREATE = "Y_CREATED";
	public static final String STATUS_OPEN = "Y";
	public static final String STATUS_UNOPEN = "N";
	public static final String STATUS_OPENED = "Y_OPEN";
	public static final String STATUS_UNPOST = "Y_NOTPOST";
	public static final String STATUS_POST_EXPRESS = "Y_EXP";
	public static final String STATUS_POST_COMMON = "Y_POST";
	public static final String STATUS_UNOPENED = "N_NOTOPEN";
	public static final String STATUS_APPLY = "N_APPLY";
	public static final String STATUS_TRASH = "N_TRASH";
	public static final String STATUS_APPLY_AGAIN = "N_APPLYAGAIN";
	public static final String STATUS_OPEN_AGAIN = "Y_AGAIN";
	public static final String NO_ATTENTION = "0";
	public static final String ONLY_ATTENTION = "1";
	public static final String ONLY_BEATTENTION = "2";
	public static final String EACH_ATTENTION = "3";
	public static final String MOBILE_PHONE = "mobile";
	public static final String SINA = "sina";
	public static final String MOBILE_MD5_CODE = "!*@#$d";
	public static final Integer VALDMIN = Integer.valueOf(30);

	public static boolean isHidden(String status) {
		return StringUtils.isNotBlank(status) && status.startsWith("N");
	}
}