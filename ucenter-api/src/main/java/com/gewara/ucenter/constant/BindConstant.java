/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public class BindConstant {
	public static final String KEY_BINDTIME = "bindTime";
	public static final String TAG_REGISTERCODE = "registercode";
	public static final String TAG_DYNAMICCODE = "dynamiccode";
	public static final String TAG_BINDMOBILE = "bindMobile";
	public static final String TAG_CHGBINDMOBILE = "chgbindMobile";
	public static final String TAG_CHGBINDMOBILE2 = "chgbindN";
	public static final String TAG_ACCOUNT_BACKPASS = "account_backpass";
	public static final String TAG_DYNAMICCODE_CARD = "dynamiccode_card";
	public static final String TAG_BACKPASS = "backpass";
	public static final String TAG_MODIFYPASS = "modifypass";
	public static final String TAG_SETPAYPASS = "setpaypass";
	public static final String TAG_MDYPAYPASS = "mdypaypass";
	public static final String TAG_DRAWMOBILE = "drawMobile";
	public static final String TAG_GETPAYPASS = "getpaypass";
	public static final String TAG_CCBANKCODE = "ccbankcode";
	public static final String TAG_SECURITYVERIFY = "securityVerify";
	public static final String TAG_VDEMAIL_BY_UPDATEPWD = "vdemailbyuppwd";
	public static final String TAG_UNICOM_REGISTERCODE = "unicom_registercode";
	public static final String TAG_UNICOM_BACKPASS = "unicom_backpass";
	public static final String TAG_MESSAGE_CHECK = "message_check";
	public static final String TAG_PRE_MES = "pre_mes";
	public static final String TAG_SMSVALID = "smsvalid";
	public static final List<String> VALID_TAG_LIST = Arrays.asList(new String[] { "registercode", "dynamiccode",
			"bindMobile", "account_backpass", "dynamiccode_card", "backpass", "modifypass", "setpaypass", "mdypaypass",
			"chgbindMobile", "chgbindN", "drawMobile", "ccbankcode", "getpaypass", "vdemailbyuppwd",
			"unicom_registercode", "unicom_backpass", "message_check", "pre_mes", "smsvalid", "securityVerify" });
	public static final String DEFAULT_TEMPLATE = "checkpass(格瓦拉动态验证码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068";
	public static final String ADMIN_MOBILE_TEMPLATE = "checkpass(格瓦拉电话购票校验码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068";
	public static final int VALID_MIN = 30;
	public static final int MAX_CHECKNUM = 5;
	public static final int MAX_SENDNUM = 99999;
	private static final Map<String, Integer> SENDNUM_MAP;
	private static final Map<String, Integer> MAXCHECK_MAP;
	private static final Map<String, String> TEMPLATE_MAP;

	public static String getMsgTemplate(String tag) {
		return TEMPLATE_MAP.containsKey(tag) ? (String) TEMPLATE_MAP.get(tag)
				: "checkpass(格瓦拉动态验证码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068";
	}

	public static int getMaxSendnum(String tag) {
		return SENDNUM_MAP.containsKey(tag) ? ((Integer) SENDNUM_MAP.get(tag)).intValue() : 99999;
	}

	public static int getMaxCheck(String tag) {
		return MAXCHECK_MAP.containsKey(tag) ? ((Integer) MAXCHECK_MAP.get(tag)).intValue() : 5;
	}

	public static String getChangeBindOldKey(Long memberid) {
		return "chgbindMobile" + memberid;
	}

	static {
		HashMap tmp = new HashMap();
		tmp.put("registercode", "checkpass(格瓦拉注册动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("ccbankcode", "checkpass(格瓦拉支付动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("unicom_backpass", "checkpass(电影秀动态验证码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("unicom_registercode", "您在电影秀注册的动态码是：checkpass， 30分钟内有效，使用后失效。");
		tmp.put("bindMobile", "checkpass(格瓦拉绑定动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("chgbindMobile", "checkpass(格瓦拉更改动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("chgbindN", "checkpass(格瓦拉更改动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("pre_mes", "checkpass(格瓦拉动态码，请勿泄漏),30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("smsvalid", "为保护您的账号安全，请回复checkpass验证您的账号,15分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put("securityVerify", "checkpass(格瓦拉安全动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		TEMPLATE_MAP = UnmodifiableMap.decorate(tmp);
		HashMap tmp2 = new HashMap();
		tmp2.put("registercode", Integer.valueOf(20));
		tmp2.put("unicom_registercode", Integer.valueOf(20));
		tmp2.put("modifypass", Integer.valueOf(20));
		tmp2.put("bindMobile", Integer.valueOf(20));
		SENDNUM_MAP = UnmodifiableMap.decorate(tmp2);
		tmp2 = new HashMap();
		tmp2.put("modifypass", Integer.valueOf(8));
		tmp2.put("setpaypass", Integer.valueOf(8));
		MAXCHECK_MAP = UnmodifiableMap.decorate(tmp2);
	}
}