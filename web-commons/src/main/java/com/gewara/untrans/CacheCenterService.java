/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.util.ServiceCacheHelper;
import java.util.Map;

public interface CacheCenterService {
	ServiceCacheHelper getServiceCacheHelper(Class arg0);

	ServiceCacheHelper getServiceCacheHelperByName(String arg0);

	ServiceCacheHelper getLocalServiceCacheHelper(Class arg0);

	ServiceCacheHelper getLocalServiceCacheHelperByName(String arg0);

	Map<String, ServiceCacheHelper> getHelperMap();

	void clearCache(Class arg0, String arg1, Object... arg2);

	void clearCacheByName(String arg0, String arg1, Object... arg2);

	void startClear(String arg0);
}