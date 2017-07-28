/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.filter;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.web.FilterChainProxy;

public class GewaFilterChainProxy extends FilterChainProxy {
	Map<String, String> filterUrlMap = new HashMap();

	public void setFilterUrlMap(Map<String, String> filterUrlMap) {
		this.filterUrlMap = filterUrlMap;
	}
}