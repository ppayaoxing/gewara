package com.gewara.web.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class PrefixUriRequestMatcher implements RequestMatcher{
	private List<String> prefixList = new ArrayList<String>();
	@Override
	public boolean matches(HttpServletRequest request) {
		if(prefixList.isEmpty()) {
            return true;
        }
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		if(StringUtils.isNotEmpty(ctxPath)){
			uri = uri.substring(ctxPath.length());
		}
		if(!uri.startsWith("/")){
			uri = "/" + uri;
		}
		
		for(String prefix: prefixList){
			if(uri.startsWith(prefix)) {
                return true;
            }
		}
		return false;
	}
	public void setPrefixUris(String prefixUris){
		if(StringUtils.isNotBlank(prefixUris)){
			prefixList = Arrays.asList(StringUtils.split(prefixUris, ","));
		}
	}
}
