package com.gewara.drama.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class OtherFeeRefundConstant implements Serializable {

	private static final long serialVersionUID = 6682861817043274469L;
	public static final String STATUS_APPLY = "apply"; 		//申请
	public static final String STATUS_ACCEPT = "accept"; 	//接受
	public static final String STATUS_REJECT = "reject"; 	//拒绝退款
	public static final String STATUS_SUCCESS = "success";	//退款成功
	
	public static final String ORIGIN_EXPRESS = "express";		//快递费
	public static final String ORIGIN_INSURE = "insure";		//保险费
	public static final String ORIGIN_UMPAY = "umpay";			//移动手续费
	public static final String ORIGIN_CHANGE = "change";		//更换订单产生多余的费用
	
	//退款原因
	public static final String REASON_MEMBER = "member";				//用户原因
	public static final String REASON_EXPRESS_MERGE = "expressMerge";	//快递合并
	public static final String REASON_EXPRESS_LOSE = "expressLose";		//快递丢失
	public static final String REASON_UNKNOWN = "unknown";				//未知
	
	//账户退款 Y：需要，N：不需要，O：未知, 参见描述(Other)，S: 已提交账务(Submit) R：财务已经返还(Refund)，F：财务返还出错(Failure)
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
	static{
		Map<String, String> tmpStatus = new HashMap<String, String>();
		tmpStatus.put(STATUS_APPLY, "申请");
		tmpStatus.put(STATUS_ACCEPT, "接受");
		tmpStatus.put(STATUS_REJECT, "拒绝退款");
		tmpStatus.put(STATUS_SUCCESS, "退款成功");
		statusTextMap = UnmodifiableMap.decorate(tmpStatus);
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(ORIGIN_EXPRESS, "快递退款");
		tmp.put(ORIGIN_INSURE, "保险退款");
		tmp.put(ORIGIN_UMPAY, "移动手续费退款");
		tmp.put(ORIGIN_CHANGE, "更换订单余费退款");
		originTextMap = UnmodifiableMap.decorate(tmp);
		Map<String, String> tmpOrigin = new HashMap<String, String>();
		tmpOrigin.put(OtherFeeDetailConstant.FEETYPE_E, ORIGIN_EXPRESS);
		tmpOrigin.put(OtherFeeDetailConstant.FEETYPE_I, ORIGIN_INSURE);
		tmpOrigin.put(OtherFeeDetailConstant.FEETYPE_U, ORIGIN_UMPAY);
		tmpOrigin.put(OtherFeeDetailConstant.FEETYPE_C, ORIGIN_CHANGE);
		shortOrignMap = UnmodifiableMap.decorate(tmpOrigin);
		Map<String, String> tmpReason = new LinkedHashMap<String, String>();
		tmpReason.put(REASON_EXPRESS_MERGE, "快递合并");
		tmpReason.put(REASON_EXPRESS_LOSE, "快递丢失");
		tmpReason.put(REASON_MEMBER, "用户原因");
		tmpReason.put(REASON_UNKNOWN, "未知");
		reasonTextMap = UnmodifiableMap.decorate(tmpReason);
		
		Map<String, String> tmpRetback = new LinkedHashMap<String, String>();
		tmpRetback.put(RETBACK_Y, "需要");
		tmpRetback.put(RETBACK_N, "不需要");
		tmpRetback.put(RETBACK_OTHER, "参见描述");
		tmpRetback.put(RETBACK_SUBMIT, "已提交财务");
		tmpRetback.put(RETBACK_REFUND, "财务成功");
		tmpRetback.put(RETBACK_FAILURE, "财务失败");
		retbackMap = UnmodifiableMap.decorate(tmpRetback);
	}
}
