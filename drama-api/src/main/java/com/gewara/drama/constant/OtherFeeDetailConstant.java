/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.constant;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public class OtherFeeDetailConstant {
	public static final String FEETYPE_E = "E";
	public static final String FEETYPE_U = "U";
	public static final String FEETYPE_C = "C";
	public static final String FEETYPE_I = "I";
	public static final String INSURE_USER_NAME = "insureUName";
	public static final String INSURE_USER_BIRTHDAY = "insureUBirthday";
	public static final String STATUS_NEW = "new";
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_REFUND = "refund";
	public static final Map<String, String> originFeetypeMap;

	static {
		HashMap tmpOrigin = new HashMap();
		tmpOrigin.put("express", "E");
		tmpOrigin.put("insure", "I");
		tmpOrigin.put("umpay", "U");
		tmpOrigin.put("change", "C");
		originFeetypeMap = UnmodifiableMap.decorate(tmpOrigin);
	}
}