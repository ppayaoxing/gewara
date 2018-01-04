/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gewara.web.support;

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

import com.gewara.model.acl.GewaraUser;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * @author acerge(acerge@163.com)
 * @since 1:59:07 PM Mar 21, 2011
 */
public class SSOAuthenticationProvider implements AuthenticationProvider, InitializingBean, ApplicationContextAware{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private UserDetailsChecker preAuthenticationChecks = new DefaultPreAuthenticationChecks();
	private UserDetailsChecker postAuthenticationChecks = new DefaultPostAuthenticationChecks();
	private AclService aclService;
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		aclService = applicationContext.getBean(AclService.class);
		Assert.notNull(aclService, "必须提供aclService实现！");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Assert.isInstanceOf(SSOAuthenticationToken.class, authentication,
				"SSOAuthenticationProvider only supports SSOAuthenticationToken");
		SSOAuthenticationToken auth = (SSOAuthenticationToken) authentication;
		//auth.setAuthenticated(true);
		//TODO:暂时写死
		//GewaraUser user = aclService.getGewaraUser(auth.getUserid(), "user");
		GewaraUser user=(GewaraUser)auth.getPrincipal();
		Assert.notNull(user, "用户不能空");
		preAuthenticationChecks.check(user);
		postAuthenticationChecks.check(user);
		return createSuccessAuthentication(auth, user);
	}

	protected Authentication createSuccessAuthentication(SSOAuthenticationToken auth, GewaraUser user) {
	   	SSOAuthenticationToken result = new SSOAuthenticationToken(user, auth.getSystemid(), user.getAuthorities());
	   	result.setAuthenticated(true);
	   	return result;
   }

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (SSOAuthenticationToken.class.isAssignableFrom(authentication));
	}

	private class DefaultPreAuthenticationChecks implements UserDetailsChecker {
		@Override
		public void check(UserDetails user) {
			if (!user.isAccountNonLocked()) {
				dbLogger.warn("User account is locked");
				throw new LockedException("User account is locked");
			}

			if (!user.isEnabled()) {
				dbLogger.warn("User account is locked");
				throw new DisabledException("User is disabled");
			}

			if (!user.isAccountNonExpired()) {
				dbLogger.warn("User account is expired");
				throw new AccountExpiredException("User account has expired");
			}
		}
	}

	private class DefaultPostAuthenticationChecks implements UserDetailsChecker {
		@Override
		public void check(UserDetails user) {
			if (!user.isCredentialsNonExpired()) {
				dbLogger.warn("User account credentials have expired");
				throw new CredentialsExpiredException("User credentials have expired");
			}
		}
	}

}
