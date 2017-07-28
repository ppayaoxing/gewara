/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.web.support.AclService;
import com.gewara.web.support.GewaAntPathRequestMatcher;
import com.gewara.web.support.SecurityModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

public class DBFilterInvocationSecurityMetadataSource
		implements FilterInvocationSecurityMetadataSource, InitializingBean, ApplicationContextAware {
	private ApplicationContext applicationContext;
	private List<String> rolenameList;
	private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;
	private AclService aclService;
	private Set<String> allMapping = null;
	private Map<String, Collection<ConfigAttribute>> cachedMatch = new HashMap();
	private String basePath = null;

	public void afterPropertiesSet() throws Exception {
		this.aclService = (AclService) this.applicationContext.getBean(AclService.class);
		Assert.notNull(this.aclService, "必须提供aclService实现！");
		this.init();
	}

	public void init() {
		List moduleList = this.aclService.getSecurityModuleList();
		LinkedHashMap tmp = new LinkedHashMap();
		Iterator arg2 = moduleList.iterator();

		while (arg2.hasNext()) {
			SecurityModule module = (SecurityModule) arg2.next();
			String url = module.getModuleurl();
			if (StringUtils.isNotBlank(url)) {
				int idx = module.getModuleurl().indexOf(63);
				if (idx > 0) {
					url = url.substring(0, idx);
				}

				if (StringUtils.isBlank(module.getRolenames())) {
					tmp.put(new GewaAntPathRequestMatcher(url), new ArrayList(0));
				} else {
					tmp.put(new GewaAntPathRequestMatcher(url),
							SecurityConfig.createList(StringUtils.split(module.getRolenames(), ",")));
				}
			}
		}

		this.requestMap = tmp;
		this.rolenameList = this.aclService.getRolenameList();
		this.initUrlMapping();
	}

	public Collection<ConfigAttribute> getAttributes(Object object) {
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		Collection cached = (Collection) this.cachedMatch.get(request.getRequestURI());
		if (cached != null) {
			return cached;
		} else {
			Iterator arg3 = this.requestMap.entrySet().iterator();

			Entry entry;
			do {
				if (!arg3.hasNext()) {
					return null;
				}

				entry = (Entry) arg3.next();
			} while (!((RequestMatcher) entry.getKey()).matches(request));

			return (Collection) entry.getValue();
		}
	}

	private Collection<ConfigAttribute> getAttributesByUri(String uri) {
		Iterator arg1 = this.requestMap.entrySet().iterator();

		Entry entry;
		do {
			if (!arg1.hasNext()) {
				return null;
			}

			entry = (Entry) arg1.next();
		} while (!((GewaAntPathRequestMatcher) entry.getKey()).getMatcher().matches(uri.toLowerCase()));

		return (Collection) entry.getValue();
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return SecurityConfig.createList((String[]) this.rolenameList.toArray(new String[this.rolenameList.size()]));
	}

	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void initUrlMapping(String contextPath, HashSet<String> mappings) {
		if (StringUtils.isBlank(contextPath)) {
			contextPath = "";
		}

		if (contextPath.endsWith("/")) {
			contextPath = contextPath.substring(0, contextPath.length() - 1);
		}

		this.basePath = contextPath;
		this.allMapping = mappings;
		this.initUrlMapping();
	}

	private void initUrlMapping() {
		if (this.allMapping != null) {
			HashMap tmp = new HashMap();

			String uri;
			Object atts;
			for (Iterator arg1 = this.allMapping.iterator(); arg1.hasNext(); tmp.put(uri, atts)) {
				String mapping = (String) arg1.next();
				uri = this.basePath + mapping;
				atts = this.getAttributesByUri(mapping);
				if (atts == null) {
					atts = new ArrayList();
				}
			}

			this.cachedMatch = tmp;
		}

	}
}