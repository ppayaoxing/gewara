package com.gewara.ucenter.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class BindConstant {
	public static final String KEY_BINDTIME = "bindTime";	//锟斤拷锟街伙拷时锟戒，锟街伙拷注锟斤拷直锟斤拷锟斤拷注锟斤拷时锟斤拷

	public static final String TAG_REGISTERCODE = "registercode"; 	//锟斤拷取锟街伙拷注锟结、锟斤拷锟劫碉拷录锟斤拷态锟斤拷
	public static final String TAG_DYNAMICCODE = "dynamiccode"; 	//锟斤拷TAG_REGISTERCODE锟较诧拷
	
	public static final String TAG_BINDMOBILE = "bindMobile"; 		//锟街伙拷锟斤拷
	public static final String TAG_CHGBINDMOBILE = "chgbindMobile"; //锟睫革拷锟街伙拷锟襟定ｏ拷锟斤拷锟街伙拷
	public static final String TAG_CHGBINDMOBILE2 = "chgbindN"; //锟睫革拷锟街伙拷锟襟定ｏ拷锟斤拷锟街伙拷
	
	public static final String TAG_ACCOUNT_BACKPASS = "account_backpass"; //锟街伙拷锟揭伙拷支锟斤拷锟斤拷锟斤拷
	public static final String TAG_DYNAMICCODE_CARD = "dynamiccode_card"; //锟斤拷锟斤拷票券锟斤拷锟街伙拷锟斤拷态锟斤拷
	public static final String TAG_BACKPASS = "backpass"; 		//锟街伙拷锟揭伙拷锟斤拷锟斤拷
	public static final String TAG_MODIFYPASS = "modifypass"; 	//锟睫革拷锟斤拷锟斤拷

	public static final String TAG_SETPAYPASS = "setpaypass"; 	//锟斤拷锟斤拷支锟斤拷锟斤拷锟斤拷
	public static final String TAG_MDYPAYPASS = "mdypaypass"; 	//锟睫革拷支锟斤拷锟斤拷锟斤拷
	public static final String TAG_DRAWMOBILE = "drawMobile"; 	//锟介奖锟街伙拷锟斤拷证
	public static final String TAG_GETPAYPASS = "getpaypass"; 	//锟揭伙拷支锟斤拷锟斤拷锟斤拷
	public static final String TAG_CCBANKCODE = "ccbankcode";	//锟斤拷锟斤拷锟斤拷锟叫讹拷态锟斤拷
	public static final String TAG_SECURITYVERIFY = "securityVerify"; 	//锟矫伙拷锟斤拷全锟斤拷证

	public static final String TAG_VDEMAIL_BY_UPDATEPWD = "vdemailbyuppwd"; //锟睫革拷锟斤拷锟斤拷前锟斤拷锟斤拷锟戒安全锟斤拷证
	public static final String TAG_UNICOM_REGISTERCODE = "unicom_registercode"; 	//锟斤拷通锟矫伙拷注锟结动态锟斤拷
	public static final String TAG_UNICOM_BACKPASS = "unicom_backpass"; 	//锟斤拷通锟矫伙拷注锟结动态锟斤拷
	public static final String TAG_MESSAGE_CHECK = "message_check";			// 专锟斤拷疃拷亩锟斤拷锟斤拷锟街�
	public static final String TAG_PRE_MES = "pre_mes";		// 预锟桔活动锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String TAG_SMSVALID = "smsvalid"; 	//锟斤拷锟脚回革拷锟斤拷证
	//public static final String PREFIX_SMSVALID = "yz";	//锟斤拷证锟斤拷锟斤拷

	
	//锟斤拷效锟斤拷签list锟斤拷锟斤拷锟斤拷锟斤拷证锟矫憋拷签锟角凤拷锟斤拷效锟斤拷锟斤拷锟斤拷锟斤拷锟津返伙拷锟斤拷锟酵达拷锟斤拷锟睫凤拷锟斤拷锟斤拷refreshBindMobile锟斤拷锟斤拷
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

	//默锟较讹拷锟斤拷
	public static final String DEFAULT_TEMPLATE = "checkpass(锟斤拷锟斤拷锟斤拷锟斤拷态锟斤拷证锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068";
	public static final String ADMIN_MOBILE_TEMPLATE = "checkpass(锟斤拷锟斤拷锟斤拷锟界话锟斤拷票校锟斤拷锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068";
	public static final int VALID_MIN = 30;			//锟斤拷效时锟斤拷(MINUTE)
	public static final int MAX_CHECKNUM = 5;
	public static final int MAX_SENDNUM = 99999;
	
	private static final Map<String, Integer> SENDNUM_MAP;
	private static final Map<String, Integer> MAXCHECK_MAP;
	private static final Map<String, String> TEMPLATE_MAP;
	//默锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�

	
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(TAG_REGISTERCODE, "checkpass(锟斤拷锟斤拷锟斤拷注锟结动态锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		tmp.put(TAG_CCBANKCODE, "checkpass(锟斤拷锟斤拷锟斤拷支锟斤拷锟斤拷态锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		
		tmp.put(TAG_UNICOM_BACKPASS, "checkpass(锟斤拷影锟姐动态锟斤拷证锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		tmp.put(TAG_UNICOM_REGISTERCODE, "锟斤拷锟节碉拷影锟斤拷注锟斤拷亩锟教拷锟斤拷牵锟絚heckpass锟斤拷 30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷使锟矫猴拷失效锟斤拷");
		
		tmp.put(TAG_BINDMOBILE, "checkpass(锟斤拷锟斤拷锟斤拷锟襟定讹拷态锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		tmp.put(TAG_CHGBINDMOBILE, "checkpass(锟斤拷锟斤拷锟斤拷锟斤拷锟侥讹拷态锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		tmp.put(TAG_CHGBINDMOBILE2, "checkpass(锟斤拷锟斤拷锟斤拷锟斤拷锟侥讹拷态锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		tmp.put(TAG_PRE_MES, "checkpass(锟斤拷锟斤拷锟斤拷锟斤拷态锟诫，锟斤拷锟斤拷泄漏),30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		tmp.put(TAG_SMSVALID, "为锟斤拷锟斤拷锟斤拷锟斤拷锟剿号帮拷全锟斤拷锟斤拷馗锟絚heckpass锟斤拷证锟斤拷锟斤拷锟剿猴拷,15锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		
		tmp.put(TAG_SECURITYVERIFY, "checkpass(锟斤拷锟斤拷锟斤拷锟斤拷全锟斤拷态锟诫，锟斤拷锟斤拷泄漏)锟斤拷30锟斤拷锟斤拷锟斤拷锟斤拷效锟斤拷锟角憋拷锟剿伙拷锟斤拷权锟斤拷锟斤拷锟斤拷锟斤拷锟铰碉拷1010-1068");
		
		TEMPLATE_MAP = UnmodifiableMap.decorate(tmp);
		
		Map<String, Integer> tmp2 = new HashMap<String, Integer>();
		tmp2.put(TAG_REGISTERCODE, 20);		//注锟斤拷锟斤拷一锟街伙拷只锟斤拷锟斤拷20锟斤拷
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
		if(TEMPLATE_MAP.containsKey(tag)) {
            return TEMPLATE_MAP.get(tag);
        }
		return DEFAULT_TEMPLATE;
	}
	public static int getMaxSendnum(String tag){
		if(SENDNUM_MAP.containsKey(tag)) {
            return SENDNUM_MAP.get(tag);
        }
		return MAX_SENDNUM;
	}
	public static int getMaxCheck(String tag){
		if(MAXCHECK_MAP.containsKey(tag)) {
            return MAXCHECK_MAP.get(tag);
        }
		return MAX_CHECKNUM;
	}
	public static String getChangeBindOldKey(Long memberid) {
		return TAG_CHGBINDMOBILE + memberid;
	}

}
