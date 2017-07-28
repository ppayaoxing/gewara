/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.model.acl.GewaraUser;
import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class SSOAuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 8278827757022204477L;
	private GewaraUser user;
	private Long userid;
	private String systemid;
	private String identity;

	public SSOAuthenticationToken(GewaraUser user, String systemid,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.user = user;
		this.systemid = systemid;
		this.identity = "" + user.getId();
		this.userid = user.getId();
	}

	public Object getCredentials() {
		return null;
	}

	public Object getPrincipal() {
		return this.user;
	}

	public String getSystemid() {
		return this.systemid;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void eraseCredentials() {
	}

	public Long getUserid() {
		return this.userid;
	}
}