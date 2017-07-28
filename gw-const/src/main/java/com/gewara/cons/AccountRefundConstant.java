/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import com.gewara.cons.OtherFeeRefundConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;

public abstract class AccountRefundConstant implements Serializable {
	private static final long serialVersionUID = 2425895630620383174L;
	public static final String STATUS_APPLY = "apply";
	public static final String STATUS_FAIL = "fail";
	public static final String STATUS_DEBIT = "debit";
	public static final String STATUS_REAPPLY = "reapply";
	public static final String STATUS_SUCCESS = "success";
	public static final String ORIGIN_REFUND = "refund";
	public static final String ORIGIN_APPLY = "apply";
	public static final String ORIGIN_CHARGE = "charge";
	public static final String ORIGIN_INSURE = "insure";
	public static final String ORIGIN_COMPENSATE = "compensate";
	public static final String REFUND_ORIGIN_CUSTOMER = "customer";
	public static final String REFUND_ORIGIN_SERVICE = "service";
	public static final String REFUND_ORIGIN_SYSTEM = "system";
	public static final Map<String, String> statusTextMap;
	public static final Map<String, String> originTextMap;
	public static final Map<String, String> refundOriginTextMap;

	public static String getStatusText(String status) {
		String text = (String) statusTextMap.get(status);
		return StringUtils.isNotBlank(text) ? text : "未知";
	}

	static {
		HashMap textMap = new HashMap();
		textMap.put("apply", "新申请");
		textMap.put("fail", "退款失败");
		textMap.put("success", "退款成功");
		statusTextMap = UnmodifiableMap.decorate(textMap);
		HashMap tmp = new HashMap();
		tmp.put("refund", "订单退款");
		tmp.put("apply", "客服退款");
		tmp.put("charge", "充值退款");
		tmp.put("insure", "保险退款");
		tmp.put("compensate", "赔偿保险");
		tmp.putAll(OtherFeeRefundConstant.originTextMap);
		originTextMap = UnmodifiableMap.decorate(tmp);
		HashMap refundOriginTmpMap = new HashMap();
		refundOriginTmpMap.put("customer", "客户提交");
		refundOriginTmpMap.put("service", "客服提交");
		refundOriginTmpMap.put("system", "系统提交");
		refundOriginTextMap = UnmodifiableMap.decorate(refundOriginTmpMap);
	}
}