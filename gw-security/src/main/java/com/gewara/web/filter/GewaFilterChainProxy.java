package com.gewara.web.filter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.web.FilterChainProxy;
public class GewaFilterChainProxy extends FilterChainProxy {
	Map<String, String> filterUrlMap = new HashMap<String, String>();
	//TODO:remove or cache MatchResult
	public void setFilterUrlMap(Map<String, String> filterUrlMap) {
		this.filterUrlMap = filterUrlMap;
	}
}
