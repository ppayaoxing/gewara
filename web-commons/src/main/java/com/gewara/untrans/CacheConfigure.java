/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import java.util.Map;

public interface CacheConfigure {
	Map<String, String> getRegionVersion();

	Map<String, String> getServiceCachePre();
}