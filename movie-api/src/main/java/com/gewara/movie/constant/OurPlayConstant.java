/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public class OurPlayConstant {
	public static final String BELONGTOKIND_NEWBUSINESS = "newBusiness";
	public static final String BELONGTOKIND_NEWCLASSICS = "newClassics";
	public static final String BELONGTOKIND_YINGZHAN = "yingzhan";
	public static final String OURPLAY_CONFIG_INDEX_IMG = "ourplay_index_img";
	public static final List<String> belongToKindList = Arrays
			.asList(new String[] { "newBusiness", "newClassics", "yingzhan" });
	public static final List<String> cityCodeList = Arrays.asList(new String[] { "110000", "310000", "440100", "320100",
			"330100", "440300", "420100", "510100", "500000", "610100", "320500" });
	public static final Map<String, String> belongToKindMap;

	static {
		LinkedHashMap tmp = new LinkedHashMap();
		tmp.put("newBusiness", "新商业");
		tmp.put("newClassics", "新经典");
		tmp.put("yingzhan", "影展");
		belongToKindMap = UnmodifiableMap.decorate(tmp);
	}
}