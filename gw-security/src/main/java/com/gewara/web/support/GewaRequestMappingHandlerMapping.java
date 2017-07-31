package com.gewara.web.support;

import java.util.HashSet;
import java.util.Set;

public class GewaRequestMappingHandlerMapping extends UriSetRequestMappingHandlerMapping{
	protected void initUriMapping(String contextPath, Set<String> uris){
		try{
			DBFilterInvocationSecurityMetadataSource source = this.getApplicationContext().getBean(DBFilterInvocationSecurityMetadataSource.class);
			source.initUrlMapping(contextPath, new HashSet<String>(uriSet));
		}catch(Throwable e){
		}
	}
}
