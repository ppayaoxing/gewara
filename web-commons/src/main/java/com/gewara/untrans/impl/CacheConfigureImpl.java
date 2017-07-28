/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.CacheConfigure;
import java.util.Collections;
import java.util.Map;

public class CacheConfigureImpl implements CacheConfigure {
	public Map<String, String> getRegionVersion() {
		return Collections.EMPTY_MAP;
	}

	public Map<String, String> getServiceCachePre() {
		return Collections.EMPTY_MAP;
	}
}