/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.util.CachableCall;
import java.util.Map;

public interface ServiceCacheHelper {
	Map getStats();

	Map getAndResetStats();

	boolean isLocal();

	<T> T cacheCall(Integer arg0, CachableCall<T> arg1, String arg2, Object... arg3);

	<T> T cacheCallRefresh(Integer arg0, CachableCall<T> arg1, String arg2, boolean arg3, Object... arg4);

	void updateCache(Object arg0, Integer arg1, String arg2, Object... arg3);
}