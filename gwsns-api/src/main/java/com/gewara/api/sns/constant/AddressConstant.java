/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.constant;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public class AddressConstant {
	public static final String ADDRESS_WEB = "web";
	public static final String ADDRESS_WAP = "wap";
	public static final String ADDRESS_GEWAP = "gewap";
	public static final String ADDRESS_MOBILE = "mobile";
	public static final String ADDRESS_IPHONE = "iphone";
	public static final String ADDRESS_ANDROID = "android";
	public static final String ADDRESS_SYMBIAN = "symbian";
	public static final String ADDRESS_DRAMAANDROID = "dramaandroid";
	public static final String ADDRESS_DRAMAIPHONE = "dramaiphone";
	public static Map<String, String> addressMap;
	public static Map<Long, String> partnerAddressMap;
	public static final String ADDRESS_ALL = "all";

	static {
		HashMap map = new HashMap();
		map.put("web", "ÍøÒ³°æ");
		map.put("wap", "WAP°æ");
		map.put("gewap", "WAP°æ");
		map.put("iphone", "iPhone°æ");
		map.put("android", "Android°æ");
		map.put("symbian", "Symbian°æ");
		map.put("mobile", "ÊÖ»ú¶ÌÐÅ");
		map.put("dramaiphone", "iPhone°æ");
		map.put("dramaandroid", "Android°æ");
		addressMap = UnmodifiableMap.decorate(map);
	}
}