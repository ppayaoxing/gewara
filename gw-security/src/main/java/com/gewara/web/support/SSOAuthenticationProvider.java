/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.model.acl.GewaraUser;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.AclService;
import com.gewara.web.support.SSOAuthenticationToken;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.util.Assert;

public class SSOAuthenticationProvider implements AuthenticationProvider, InitializingBean, ApplicationContextAware {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private UserDetailsChecker preAuthenticationChecks = new SSOAuthenticationProvider.DefaultPreAuthenticationChecks();
	private UserDetailsChecker postAuthenticationChecks = new SSOAuthenticationProvider.DefaultPostAuthenticationChecks();
	private AclService aclService;
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void afterPropertiesSet() throws Exception {
		this.aclService = (AclService) this.applicationContext.getBean(AclService.class);
		Assert.notNull(this.aclService, "必须提供aclService实现！");
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.isInstanceOf(SSOAuthenticationToken.class, authentication,
				"SSOAuthenticationProvider only supports SSOAuthenticationToken");
		SSOAuthenticationToken auth = (SSOAuthenticationToken) authentication;
		GewaraUser user = (GewaraUser) auth.getPrincipal();
		Assert.notNull(user, "用户不能空");
		this.preAuthenticationChecks.check(user);
		this.postAuthenticationChecks.check(user);
		return this.createSuccessAuthentication(auth, user);
	}

	protected Authentication createSuccessAuthentication(SSOAuthenticationToken auth, GewaraUser user) {
		SSOAuthenticationToken result = new SSOAuthenticationToken(user, auth.getSystemid(), user.getAuthorities());
		result.setAuthenticated(true);
		return result;
	}

	public boolean supports(Class<? extends Object> authentication) {
		return SSOAuthenticationToken.class.isAssignableFrom(authentication);
	}

	private class DefaultPostAuthenticationChecks implements UserDetailsChecker {
		private DefaultPostAuthenticationChecks() {
		}

		public void check(UserDetails user) {
			if (!user.isCredentialsNonExpired()) {
				SSOAuthenticationProvider.this.dbLogger.warn("User account credentials have expired");
				throw new CredentialsExpiredException("User credentials have expired");
			}
		}
	}

	private class DefaultPreAuthenticationChecks implements UserDetailsChecker {
		private DefaultPreAuthenticationChecks() {
		}

		public void check(UserDetails user) {
			if (!user.isAccountNonLocked()) {
				SSOAuthenticationProvider.this.dbLogger.warn("User account is locked");
				throw new LockedException("User account is locked");
			} else if (!user.isEnabled()) {
				SSOAuthenticationProvider.this.dbLogger.warn("User account is locked");
				throw new DisabledException("User is disabled");
			} else if (!user.isAccountNonExpired()) {
				SSOAuthenticationProvider.this.dbLogger.warn("User account is expired");
				throw new AccountExpiredException("User account has expired");
			}
		}
	}
}