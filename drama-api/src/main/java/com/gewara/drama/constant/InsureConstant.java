package com.gewara.drama.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class InsureConstant implements Serializable {

	private static final long serialVersionUID = -1000044432709835122L;
	
	public static final String STATUS_NEW = "new";							//新创建
	public static final String STATUS_INSURE_FAIL = "insure_fail";			//投保未成功
	public static final String STATUS_INSURE_SUCCESS = "insure_success";	//投保成功
	public static final String STATUS_INSURE_CANCEL = "insure_cancel";		//保险退保
	public static final String STATUS_GW_RETURN = "gw_return";				//格瓦拉退保完成
	public static final String STATUS_POLIEY_PAID = "poliey_paid";			//保险理赔完成
	public static final String STATUS_NO_PAY_POLIEY = "no_pay_poliey";		//不赔付保险
	public static final String STATUS_NO_PAY_TK = "no_pay_tk";				//已经取票，不赔付
	
	public static final Map<String, String> statusTextMap;
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(STATUS_NEW, "新创建");
		tmp.put(STATUS_INSURE_FAIL, "投保未成功");
		tmp.put(STATUS_INSURE_SUCCESS, "投保成功");
		tmp.put(STATUS_INSURE_CANCEL, "已取消保费(第三方)");
		tmp.put(STATUS_GW_RETURN, "已取消保费(格瓦拉)");
		tmp.put(STATUS_POLIEY_PAID, "保险理赔完成");
		tmp.put(STATUS_NO_PAY_POLIEY, "不赔付保险");
		tmp.put(STATUS_NO_PAY_TK, "已取票，不赔付");
		statusTextMap = UnmodifiableMap.decorate(tmp);
	}
	
}
