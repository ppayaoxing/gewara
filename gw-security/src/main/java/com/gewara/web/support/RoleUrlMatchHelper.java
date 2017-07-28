/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.model.acl.WebModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class RoleUrlMatchHelper {
	private Map<RequestMatcher, String> compiledUrlMap = new LinkedHashMap();

	public RoleUrlMatchHelper(List<WebModule> moduleList) {
		Iterator arg1 = moduleList.iterator();

		while (arg1.hasNext()) {
			WebModule module = (WebModule) arg1.next();
			if (StringUtils.isNotBlank(module.getModuleurl())) {
				this.compiledUrlMap.put(new AntPathRequestMatcher(module.getModuleurl()), module.getRolenames());
			}
		}

	}

	public final String getFirstMatchUrlRoles(HttpServletRequest request) {
		Iterator arg1 = this.compiledUrlMap.entrySet().iterator();

		Entry entry;
		boolean matched;
		do {
			if (!arg1.hasNext()) {
				return null;
			}

			entry = (Entry) arg1.next();
			matched = ((RequestMatcher) entry.getKey()).matches(request);
		} while (!matched);

		return (String) entry.getValue();
	}

	public boolean hasRights(String userRoles, HttpServletRequest request) {
		String urlRoles = this.getFirstMatchUrlRoles(request);
		if (StringUtils.isBlank(urlRoles)) {
			return true;
		} else {
			if (StringUtils.isNotBlank(userRoles)) {
				String[] roleList = StringUtils.split(userRoles, ",");
				String[] arg4 = urlRoles.split(",");
				int arg5 = arg4.length;

				for (int arg6 = 0; arg6 < arg5; ++arg6) {
					String role = arg4[arg6];
					if (ArrayUtils.contains(roleList, role)) {
						return true;
					}
				}
			}

			return false;
		}
	}
}