/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class OtherFeeRefundConstant implements Serializable {
	private static final long serialVersionUID = 6682861817043274469L;
	public static final String STATUS_APPLY = "apply";
	public static final String STATUS_ACCEPT = "accept";
	public static final String STATUS_REJECT = "reject";
	public static final String STATUS_SUCCESS = "success";
	public static final String ORIGIN_EXPRESS = "express";
	public static final String ORIGIN_INSURE = "insure";
	public static final String ORIGIN_UMPAY = "umpay";
	public static final String ORIGIN_CHANGE = "change";
	public static final String REASON_MEMBER = "member";
	public static final String REASON_EXPRESS_MERGE = "expressMerge";
	public static final String REASON_EXPRESS_LOSE = "expressLose";
	public static final String REASON_UNKNOWN = "unknown";
	public static final String RETBACK_Y = "Y";
	public static final String RETBACK_N = "N";
	public static final String RETBACK_OTHER = "O";
	public static final String RETBACK_SUBMIT = "S";
	public static final String RETBACK_REFUND = "R";
	public static final String RETBACK_FAILURE = "F";
	public static final Map<String, String> statusTextMap;
	public static final Map<String, String> originTextMap;
	public static final Map<String, String> shortOrignMap;
	public static final Map<String, String> reasonTextMap;
	public static final Map<String, String> retbackMap;

	static {
		HashMap tmpStatus = new HashMap();
		tmpStatus.put("apply", "申请");
		tmpStatus.put("accept", "接受");
		tmpStatus.put("reject", "拒绝退款");
		tmpStatus.put("success", "退款成功");
		statusTextMap = UnmodifiableMap.decorate(tmpStatus);
		HashMap tmp = new HashMap();
		tmp.put("express", "快递退款");
		tmp.put("insure", "保险退款");
		tmp.put("umpay", "移动手续费退款");
		tmp.put("change", "更换订单余费退款");
		originTextMap = UnmodifiableMap.decorate(tmp);
		HashMap tmpOrigin = new HashMap();
		tmpOrigin.put("E", "express");
		tmpOrigin.put("I", "insure");
		tmpOrigin.put("U", "umpay");
		tmpOrigin.put("C", "change");
		shortOrignMap = UnmodifiableMap.decorate(tmpOrigin);
		LinkedHashMap tmpReason = new LinkedHashMap();
		tmpReason.put("expressMerge", "快递合并");
		tmpReason.put("expressLose", "快递丢失");
		tmpReason.put("member", "用户原因");
		tmpReason.put("unknown", "未知");
		reasonTextMap = UnmodifiableMap.decorate(tmpReason);
		LinkedHashMap tmpRetback = new LinkedHashMap();
		tmpRetback.put("Y", "需要");
		tmpRetback.put("N", "不需要");
		tmpRetback.put("O", "参见描述");
		tmpRetback.put("S", "已提交财务");
		tmpRetback.put("R", "财务成功");
		tmpRetback.put("F", "财务失败");
		retbackMap = UnmodifiableMap.decorate(tmpRetback);
	}
}