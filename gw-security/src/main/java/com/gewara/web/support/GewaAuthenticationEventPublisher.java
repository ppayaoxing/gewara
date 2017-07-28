/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.model.acl.GewaraUser;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class GewaAuthenticationEventPublisher implements AuthenticationEventPublisher {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		this.dbLogger.warn("用户登录失败：" + authentication.getName() + "失败原因:" + exception.getMessage());
	}

	public void publishAuthenticationSuccess(Authentication authentication) {
		GewaraUser user = (GewaraUser) authentication.getPrincipal();
		this.dbLogger.warn("用户登录成功：" + user.getId() + ":" + user.getRealname());
	}
}