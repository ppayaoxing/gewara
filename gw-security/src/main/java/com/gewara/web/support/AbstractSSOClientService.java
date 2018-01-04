package com.gewara.web.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;

public abstract class AbstractSSOClientService implements SSOClientService{
	protected final transient GewaLogger dbLogger = LoggerUtils.getLogger(getClass());
	protected String targetUrlParameter;//瑕佷笌GewaLoginUrlAuthenticationEntryPoint.targetUrlParameter淇濇寔涓�鍒拌嚧
	protected AclService aclService;
	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}
	@Override
	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
	@Autowired@Qualifier("config")
	protected Config config;
}
