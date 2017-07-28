/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.cons;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class ApiConstant {
	public static final String OPENAPI_AUTH_KEY = "__OPENAPI_AUTH_KEY__";
	public static final String CODE_SUCCESS = "0000";
	public static final String CODE_OPI_NOT_EXISTS = "1001";
	public static final String CODE_OPI_CLOSED = "1002";
	public static final String CODE_OPI_UNSYNCH = "1003";
	public static final String CODE_OPI_UNTO_OPENTIME = "1100";
	public static final String CODE_OPI_EXPIRE = "1101";
	public static final String CODE_OPI_STATUS_CLOSE = "1102";
	public static final String CODE_OPI_BEFORE_CLOSETIME = "1104";
	public static final String CODE_OPI_SOLD_OUT = "1105";
	public static final String CODE_OPI_UN_MID_TIME = "1106";
	public static final String CODE_OPI_SD_QUOTA_FULL = "1201";
	public static final String CODE_OPI_SD_QUTY_MORE = "1202";
	public static final String CODE_CONNECTION_ERROR = "2001";
	public static final String CODE_SEAT_POS_ERROR = "2002";
	public static final String CODE_SEAT_OCCUPIED = "2003";
	public static final String CODE_SEAT_NUM_ERROR = "2004";
	public static final String CODE_SEAT_LIMITED = "2005";
	public static final String CODE_SEAT_BREAK_RULE = "2006";
	public static final String CODE_SEAT_SEATTYPE_ERROR = "2007";
	public static final String CODE_SEAT_LOCK_ERROR_CINEMA = "2010";
	public static final String CODE_CCTO_ERROR = "2011";
	public static final String CODE_TC_ERROR = "2012";
	public static final String CODE_SEAT_RELEASED = "2013";
	public static final String CODE_SYNCH_DATA = "2098";
	public static final String CODE_SEAT_LOCK_ERROR = "2099";
	public static final String CODE_ORDER_NEED_CANCEL = "3100";
	public static final String CODE_ORDER_SD_REPEAT = "3101";
	public static final String CODE_PARTNER_NOT_EXISTS = "4001";
	public static final String CODE_PARTNER_NORIGHTS = "4002";
	public static final String CODE_SIGN_ERROR = "4003";
	public static final String CODE_PARAM_ERROR = "4004";
	public static final String CODE_DATA_ERROR = "4005";
	public static final String CODE_PAY_ERROR = "4006";
	public static final String CODE_SECURITY_VERIFY = "4999";
	public static final String CODE_SUBSCRIBE_ERROR = "4040";
	public static final String CODE_WEIBO_EXPRIES = "4100";
	public static final String CODE_UNBIND_MOBILE = "4101";
	public static final String CODE_MEMBER_NOT_EXISTS = "5000";
	public static final String CODE_NOTLOGIN = "5001";
	public static final String CODE_USER_NORIGHTS = "5002";
	public static final String CODE_REPEAT_OPERATION = "5003";
	public static final String CODE_NOT_EXISTS = "5004";
	public static final String CODE_DATA_NULL = "5005";
	public static final String CODE_TRAFFIC_CONTROL = "6000";
	public static final String CODE_PAYPASS_ERROR = "6001";
	public static final String CODE_ELECARD_ISBIND = "8001";
	public static final String CODE_NIDE_BINDMOBILE = "8100";
	public static final String CODE_MOBILE_NOTREG = "8101";
	public static final String CODE_UNKNOWN_ERROR = "9999";
	public static final String CODE_GETED_POINT_STABLE_ERROR = "9001";
	public static final String CODE_GETED_POINT_BIT_ERROR = "9002";
	public static final String CODE_GETED_POINT_BRT_ERROR = "9003";
	public static final String CODE_GETED_POINT_FESTIVAL_ERROR = "9004";
	public static final String CODE_MOBILE_VALID = "9900";
	public static final String CODE_FCARD_ERROR = "9101";
	public static final String CODE_FCARD_CHANGE_ERROR = "9102";
	public static final String CODE_FCARD_USE_ERROR = "9103";
	public static final String CODE_FCARD_USEOUT = "9104";
	public static final String CODE_FCARD_LOCK = "9201";
	public static final String CODE_FCARD_LOCK_FAIL = "9202";
	public static final String CODE_FCARD_LOCK_NOT_MATCH = "9203";
	public static final String CODE_FCARD_NOT_LOCK = "9204";
	public static final Map<String, String> ORDER_STATUS_MAP;

	public static Map<String, String> getOrderStatusMap() {
		return ORDER_STATUS_MAP;
	}

	public static String getMappedOrderStatus(String status) {
		return (String) ORDER_STATUS_MAP.get(status);
	}

	static {
		HashMap tmp = new HashMap();
		tmp.put("new", "new");
		tmp.put("new_unlock", "new");
		tmp.put("new_confirm", "new");
		tmp.put("paid", "paid");
		tmp.put("paid_failure", "paid");
		tmp.put("paid_failure_unfix", "paid");
		tmp.put("paid_success", "success");
		tmp.put("paid_return", "refund");
		tmp.put("cancel", "cancel");
		tmp.put("cancel_sys", "cancel");
		tmp.put("cancel_repeat", "repeat");
		tmp.put("cancel_user", "cancel");
		tmp.put("cancel_timeout", "cancel");
		ORDER_STATUS_MAP = UnmodifiableMap.decorate(tmp);
	}
}