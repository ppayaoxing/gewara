package com.gewara.web.support;

import java.io.Serializable;

import org.springframework.security.core.Authentication;

public class CachedAuthentication implements Serializable{
	private static final long serialVersionUID = -3059550493892424507L;
	private Long timeout;
	private Authentication authentication;
	private String ip;
	public CachedAuthentication(){}
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getTimeout() {
		return timeout;
	}
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
}
