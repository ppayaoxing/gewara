package com.gewara.cons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;

public abstract class AccountRefundConstant implements Serializable {
	
	private static final long serialVersionUID = 2425895630620383174L;
	
	public static final String STATUS_APPLY = "apply";			//新申请
	//public static final String STATUS_ACCEPT = "accept"; 		//已接收
	//public static final String STATUS_UNACCEPT = "reject"; 		//不接收退款
	public static final String STATUS_FAIL = "fail"; 			//退款失败
	public static final String STATUS_DEBIT = "debit";			//账户扣款
	public static final String STATUS_REAPPLY = "reapply";		//重新补全信息
	public static final String STATUS_SUCCESS = "success";		//返回第三方支付成功
	
	public static final String ORIGIN_REFUND = "refund";		//订单退款
	public static final String ORIGIN_APPLY = "apply";			//客服独立申请退款
	public static final String ORIGIN_CHARGE = "charge";		//充值退款
	public static final String ORIGIN_INSURE = "insure";		//保险退款
	public static final String ORIGIN_COMPENSATE= "compensate"; //赔偿保险
	
	public static final String REFUND_ORIGIN_CUSTOMER= "customer"; //客户提交
	public static final String REFUND_ORIGIN_SERVICE= "service";   //客服提交
	public static final String REFUND_ORIGIN_SYSTEM= "system";     //系统提交
	
	public static final Map<String, String> statusTextMap;
	public static final Map<String, String> originTextMap;
	public static final Map<String, String> refundOriginTextMap;
	static{
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put(STATUS_APPLY, "新申请");
		//textMap.put(STATUS_ACCEPT, "已接收");
		//textMap.put(STATUS_UNACCEPT, "不接收退款");
		textMap.put(STATUS_FAIL, "退款失败");
		textMap.put(STATUS_SUCCESS, "退款成功");
		statusTextMap = UnmodifiableMap.decorate(textMap);
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(ORIGIN_REFUND, "订单退款");
		tmp.put(ORIGIN_APPLY, "客服退款");
		tmp.put(ORIGIN_CHARGE, "充值退款");
		tmp.put(ORIGIN_INSURE, "保险退款");
		tmp.put(ORIGIN_COMPENSATE, "赔偿保险");
		tmp.putAll(OtherFeeRefundConstant.originTextMap);
		originTextMap = UnmodifiableMap.decorate(tmp);
		Map<String, String> refundOriginTmpMap = new HashMap<String, String>();
		refundOriginTmpMap.put(REFUND_ORIGIN_CUSTOMER, "客户提交");
		refundOriginTmpMap.put(REFUND_ORIGIN_SERVICE, "客服提交");
		refundOriginTmpMap.put(REFUND_ORIGIN_SYSTEM, "系统提交");
		refundOriginTextMap = UnmodifiableMap.decorate(refundOriginTmpMap);
	}
	
	public static String getStatusText(String status){
		String text = statusTextMap.get(status);
		return StringUtils.isNotBlank(text)? text : "未知";
	}
}
