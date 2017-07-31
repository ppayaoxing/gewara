package com.gewara.web.support;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class MemberEncodeNamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken{
	private static final long serialVersionUID = 443064783478396531L;
	private String memberEncode;
	
	public MemberEncodeNamePasswordAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}
	public MemberEncodeNamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
	
	public String getMemberEncode() {
		return memberEncode;
	}
	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}
}
