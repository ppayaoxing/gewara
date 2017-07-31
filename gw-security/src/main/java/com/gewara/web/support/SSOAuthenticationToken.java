package com.gewara.web.support;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.gewara.model.acl.GewaraUser;

/**
 * @author acerge(acerge@163.com)
 * @since 5:06:03 PM Mar 7, 2011
 */
public class SSOAuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 8278827757022204477L;
	private GewaraUser user;
	private Long userid;
	private String systemid;
	private String identity;
	public SSOAuthenticationToken(GewaraUser user, String systemid, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.user = user;
		this.systemid = systemid;
		this.identity = "" + user.getId();
		this.userid = user.getId();
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return user;
	}
	public String getSystemid(){
		return systemid;
	}

	public String getIdentity() {
		return identity;
	}
	@Override
	public void eraseCredentials() {
	}

	public Long getUserid() {
		return userid;
	}
}
