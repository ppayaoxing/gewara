package com.gewara.ucenter.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class BindConstant {
	public static final String KEY_BINDTIME = "bindTime";	//绑定手机时间，手机注册直接是注册时间

	public static final String TAG_REGISTERCODE = "registercode"; 	//获取手机注册、快速登录动态码
	public static final String TAG_DYNAMICCODE = "dynamiccode"; 	//与TAG_REGISTERCODE合并
	
	public static final String TAG_BINDMOBILE = "bindMobile"; 		//手机绑定
	public static final String TAG_CHGBINDMOBILE = "chgbindMobile"; //修改手机绑定，老手机
	public static final String TAG_CHGBINDMOBILE2 = "chgbindN"; //修改手机绑定，新手机
	
	public static final String TAG_ACCOUNT_BACKPASS = "account_backpass"; //手机找回支付密码
	public static final String TAG_DYNAMICCODE_CARD = "dynamiccode_card"; //激活票券的手机动态码
	public static final String TAG_BACKPASS = "backpass"; 		//手机找回密码
	public static final String TAG_MODIFYPASS = "modifypass"; 	//修改密码

	public static final String TAG_SETPAYPASS = "setpaypass"; 	//设置支付密码
	public static final String TAG_MDYPAYPASS = "mdypaypass"; 	//修改支付密码
	public static final String TAG_DRAWMOBILE = "drawMobile"; 	//抽奖手机验证
	public static final String TAG_GETPAYPASS = "getpaypass"; 	//找回支付密码
	public static final String TAG_CCBANKCODE = "ccbankcode";	//建设银行动态码
	public static final String TAG_SECURITYVERIFY = "securityVerify"; 	//用户安全认证

	public static final String TAG_VDEMAIL_BY_UPDATEPWD = "vdemailbyuppwd"; //修改密码前置邮箱安全验证
	public static final String TAG_UNICOM_REGISTERCODE = "unicom_registercode"; 	//联通用户注册动态吗
	public static final String TAG_UNICOM_BACKPASS = "unicom_backpass"; 	//联通用户注册动态吗
	public static final String TAG_MESSAGE_CHECK = "message_check";			// 专题活动的短信验证
	public static final String TAG_PRE_MES = "pre_mes";		// 预售活动短信提醒
	public static final String TAG_SMSVALID = "smsvalid"; 	//短信回复验证
	//public static final String PREFIX_SMSVALID = "yz";	//验证短信

	
	//有效标签list，用于验证该标签是否有效。不存在则返回类型错误。无法进行refreshBindMobile操作
	public static final List<String> VALID_TAG_LIST = Arrays.asList(
			TAG_REGISTERCODE,
			TAG_DYNAMICCODE,
			TAG_BINDMOBILE,
			TAG_ACCOUNT_BACKPASS,
			TAG_DYNAMICCODE_CARD,
			TAG_BACKPASS,
			TAG_MODIFYPASS,
			TAG_SETPAYPASS,
			TAG_MDYPAYPASS,
			TAG_CHGBINDMOBILE,
			TAG_CHGBINDMOBILE2,
			TAG_DRAWMOBILE,
			TAG_CCBANKCODE,
			TAG_GETPAYPASS,
			TAG_VDEMAIL_BY_UPDATEPWD,
			TAG_UNICOM_REGISTERCODE,
			TAG_UNICOM_BACKPASS,
			TAG_MESSAGE_CHECK,
			TAG_PRE_MES,
			TAG_SMSVALID,
			TAG_SECURITYVERIFY
		);

	//默认短信
	public static final String DEFAULT_TEMPLATE = "checkpass(格瓦拉动态验证码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068";
	public static final String ADMIN_MOBILE_TEMPLATE = "checkpass(格瓦拉电话购票校验码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068";
	public static final int VALID_MIN = 30;			//有效时长(MINUTE)
	public static final int MAX_CHECKNUM = 5;
	public static final int MAX_SENDNUM = 99999;
	
	private static final Map<String, Integer> SENDNUM_MAP;
	private static final Map<String, Integer> MAXCHECK_MAP;
	private static final Map<String, String> TEMPLATE_MAP;
	//默认最大发送数量

	
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(TAG_REGISTERCODE, "checkpass(格瓦拉注册动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put(TAG_CCBANKCODE, "checkpass(格瓦拉支付动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		
		tmp.put(TAG_UNICOM_BACKPASS, "checkpass(电影秀动态验证码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put(TAG_UNICOM_REGISTERCODE, "您在电影秀注册的动态码是：checkpass， 30分钟内有效，使用后失效。");
		
		tmp.put(TAG_BINDMOBILE, "checkpass(格瓦拉绑定动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put(TAG_CHGBINDMOBILE, "checkpass(格瓦拉更改动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put(TAG_CHGBINDMOBILE2, "checkpass(格瓦拉更改动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put(TAG_PRE_MES, "checkpass(格瓦拉动态码，请勿泄漏),30分钟内有效；非本人或授权操作，请致电1010-1068");
		tmp.put(TAG_SMSVALID, "为保护您的账号安全，请回复checkpass验证您的账号,15分钟内有效；非本人或授权操作，请致电1010-1068");
		
		tmp.put(TAG_SECURITYVERIFY, "checkpass(格瓦拉安全动态码，请勿泄漏)，30分钟内有效；非本人或授权操作，请致电1010-1068");
		
		TEMPLATE_MAP = UnmodifiableMap.decorate(tmp);
		
		Map<String, Integer> tmp2 = new HashMap<String, Integer>();
		tmp2.put(TAG_REGISTERCODE, 20);		//注册码一手机只允许发20次
		tmp2.put(TAG_UNICOM_REGISTERCODE, 20);
		tmp2.put(TAG_MODIFYPASS, 20);
		tmp2.put(TAG_BINDMOBILE, 20);
		SENDNUM_MAP = UnmodifiableMap.decorate(tmp2);
		
		tmp2 = new HashMap<String, Integer>();
		tmp2.put(TAG_MODIFYPASS, 8);
		tmp2.put(TAG_SETPAYPASS, 8);
		MAXCHECK_MAP = UnmodifiableMap.decorate(tmp2);
	}

	public static String getMsgTemplate(String tag) {
		if(TEMPLATE_MAP.containsKey(tag)) return TEMPLATE_MAP.get(tag);
		return DEFAULT_TEMPLATE;
	}
	public static int getMaxSendnum(String tag){
		if(SENDNUM_MAP.containsKey(tag)) return SENDNUM_MAP.get(tag);
		return MAX_SENDNUM;
	}
	public static int getMaxCheck(String tag){
		if(MAXCHECK_MAP.containsKey(tag)) return MAXCHECK_MAP.get(tag);
		return MAX_CHECKNUM;
	}
	public static String getChangeBindOldKey(Long memberid) {
		return TAG_CHGBINDMOBILE + memberid;
	}

}
