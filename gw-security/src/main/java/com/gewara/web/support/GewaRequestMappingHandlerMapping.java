/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.web.support.DBFilterInvocationSecurityMetadataSource;
import com.gewara.web.support.UriSetRequestMappingHandlerMapping;
import java.util.HashSet;
import java.util.Set;

public class GewaRequestMappingHandlerMapping extends UriSetRequestMappingHandlerMapping {
	protected void initUriMapping(String contextPath, Set<String> uris) {
		try {
			DBFilterInvocationSecurityMetadataSource source = (DBFilterInvocationSecurityMetadataSource) this
					.getApplicationContext().getBean(DBFilterInvocationSecurityMetadataSource.class);
			source.initUrlMapping(contextPath, new HashSet(this.uriSet));
		} catch (Throwable arg3) {
			;
		}

	}
}