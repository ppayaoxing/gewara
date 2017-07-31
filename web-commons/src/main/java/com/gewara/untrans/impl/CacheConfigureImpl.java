package com.gewara.untrans.impl;

import java.util.Collections;
import java.util.Map;

import com.gewara.untrans.CacheConfigure;

public class CacheConfigureImpl implements CacheConfigure {

	@Override
	public Map<String, String> getRegionVersion() {
		return Collections.EMPTY_MAP;
	}

	@Override
	public Map<String, String> getServiceCachePre() {
		return Collections.EMPTY_MAP;
	}

}
