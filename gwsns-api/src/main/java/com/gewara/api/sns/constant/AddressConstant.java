package com.gewara.api.sns.constant;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class AddressConstant {
	public static final String ADDRESS_WEB="web";//web
	public static final String ADDRESS_WAP="wap";//wap
	public static final String ADDRESS_GEWAP="gewap";//wap
	public static final String ADDRESS_MOBILE="mobile";//ÊÖ»ú¶ÌÐÅ
	public static final String ADDRESS_IPHONE="iphone";//iphone
	public static final String ADDRESS_ANDROID="android";//android
	public static final String ADDRESS_SYMBIAN="symbian";//symbian
	public static final String ADDRESS_DRAMAANDROID = "dramaandroid";
	public static final String ADDRESS_DRAMAIPHONE = "dramaiphone";
	public static Map<String,String> addressMap;
	public static Map<Long,String> partnerAddressMap;
	static{
		Map<String,String> map = new HashMap<String, String>();
		map.put(ADDRESS_WEB,"ÍøÒ³°æ");
		map.put(ADDRESS_WAP,"WAP°æ");
		map.put(ADDRESS_GEWAP,"WAP°æ");
		map.put(ADDRESS_IPHONE,"iPhone°æ");
		map.put(ADDRESS_ANDROID,"Android°æ");
		map.put(ADDRESS_SYMBIAN, "Symbian°æ");
		map.put(ADDRESS_MOBILE, "ÊÖ»ú¶ÌÐÅ");
		map.put(ADDRESS_DRAMAIPHONE,"iPhone°æ");
		map.put(ADDRESS_DRAMAANDROID,"Android°æ");
		addressMap = UnmodifiableMap.decorate(map);
	}
	public static final String ADDRESS_ALL = "all";
}
