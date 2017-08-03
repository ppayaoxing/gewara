package com.gewara.movie.constant;

public class BsActivityConstant {
	public static final String ENABLE = "Y";			// 可用
	public static final String DISABLE = "N";			// 不可用
	
	public static final String ACTTYPE_BS="bs";			// 商户联盟
	public static final String ACTTYPE_SMS="sms";		// 营销短信
	
	public static final String PRINTPAPER_Y = "Y";		// 需要打印票纸
	public static final String PRINTPAPER_N = "N";		// 不需要打印票纸
	
	public static final String TAG_BSCARD_SMS = "sms";	// 营销短信券码
	public static final String TAG_BSCARD_BS = "bs";	// 营销短信券码
	
	public static final String BS_ACTIVITYID = "bsActivityid";	// 商户联盟订单otherinfo key
	
	public static final String getBsCounterKey(Long bsid){
		return "BSACTIVITYSMSSOUNTER"+bsid;
	}
}

