/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.gewara.web.support.AclService;
import com.gewara.web.support.SSOClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractSSOClientService implements SSOClientService {
	protected final transient GewaLogger dbLogger = LoggerUtils.getLogger(this.getClass());
	protected String targetUrlParameter;
	protected AclService aclService;
	@Autowired
	@Qualifier("config")
	protected Config config;

	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}

	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
}