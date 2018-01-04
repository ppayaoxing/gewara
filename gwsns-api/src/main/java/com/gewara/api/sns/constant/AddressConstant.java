package com.gewara.api.sns.constant;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class AddressConstant {
	public static final String ADDRESS_WEB="web";//web
	public static final String ADDRESS_WAP="wap";//wap
	public static final String ADDRESS_GEWAP="gewap";//wap
	public static final String ADDRESS_MOBILE="mobile";//手机短信
	public static final String ADDRESS_IPHONE="iphone";//iphone
	public static final String ADDRESS_ANDROID="android";//android
	public static final String ADDRESS_SYMBIAN="symbian";//symbian
	public static final String ADDRESS_DRAMAANDROID = "dramaandroid";
	public static final String ADDRESS_DRAMAIPHONE = "dramaiphone";
	public static Map<String,String> addressMap;
	public static Map<Long,String> partnerAddressMap;
	static{
		Map<String,String> map = new HashMap<String, String>();
		map.put(ADDRESS_WEB,"网页版");
		map.put(ADDRESS_WAP,"WAP版");
		map.put(ADDRESS_GEWAP,"WAP版");
		map.put(ADDRESS_IPHONE,"iPhone版");
		map.put(ADDRESS_ANDROID,"Android版");
		map.put(ADDRESS_SYMBIAN, "Symbian版");
		map.put(ADDRESS_MOBILE, "手机短信");
		map.put(ADDRESS_DRAMAIPHONE,"iPhone版");
		map.put(ADDRESS_DRAMAANDROID,"Android版");
		addressMap = UnmodifiableMap.decorate(map);
	}
	public static final String ADDRESS_ALL = "all";
}
