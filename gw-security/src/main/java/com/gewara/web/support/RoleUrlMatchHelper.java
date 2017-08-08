package com.gewara.web.support;

import com.gewara.model.acl.WebModule;
import com.google.common.collect.Maps;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class RoleUrlMatchHelper {
	private Map<RequestMatcher, String/*roles*/> compiledUrlMap = Maps.newLinkedHashMap();
	//TODO:对存在的地址匹配做缓存
	private Map<String/*url*/, String/*roles*/> cacheMatcher = Maps.newConcurrentMap();
	public RoleUrlMatchHelper(List<WebModule> moduleList){
		for(WebModule module: moduleList) {
			if(StringUtils.isNotBlank(module.getModuleurl())) {
				compiledUrlMap.put(new AntPathRequestMatcher(module.getModuleurl()), module.getRolenames());
			}
		}
	}
	public final String getFirstMatchUrlRoles(HttpServletRequest request){
		for(Map.Entry<RequestMatcher, String>entry: compiledUrlMap.entrySet()) {
			boolean matched = entry.getKey().matches(request);
			if (matched) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	public boolean hasRights(String userRoles, HttpServletRequest request) {
		String urlRoles = getFirstMatchUrlRoles(request);
		if(StringUtils.isBlank(urlRoles)) {
			return true;
		}
		if (StringUtils.isNotBlank(userRoles)) {
			String[] roleList = StringUtils.split(userRoles, ",");
			for (String role : urlRoles.split(",")) {
				if (ArrayUtils.contains(roleList, role)) {
					return true;
				}
			}
		}
		//未匹配角色无权限
		return false;
	}
}
