package com.gewara.movie.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class OurPlayConstant {
	public static final String BELONGTOKIND_NEWBUSINESS = "newBusiness";   //新商业
	public static final String BELONGTOKIND_NEWCLASSICS = "newClassics";   //新经典
	public static final String BELONGTOKIND_YINGZHAN = "yingzhan";      //影展
	
	public static final String OURPLAY_CONFIG_INDEX_IMG = "ourplay_index_img";      //影展
	
	public static final List<String> belongToKindList = Arrays.asList(BELONGTOKIND_NEWBUSINESS,
			BELONGTOKIND_NEWCLASSICS, BELONGTOKIND_YINGZHAN);
	
	public static final List<String> cityCodeList = Arrays.asList("110000","310000","440100"
			,"320100","330100","440300","420100","510100","500000","610100","320500");
	
	public static final Map<String, String> belongToKindMap;
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put(BELONGTOKIND_NEWBUSINESS, "新商业");
		tmp.put(BELONGTOKIND_NEWCLASSICS, "新经典");
		tmp.put(BELONGTOKIND_YINGZHAN, "影展");
		belongToKindMap = UnmodifiableMap.decorate(tmp);
		
	}
}
