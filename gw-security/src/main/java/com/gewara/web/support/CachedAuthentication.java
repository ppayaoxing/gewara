/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import java.io.Serializable;
import org.springframework.security.core.Authentication;

public class CachedAuthentication implements Serializable {
	private static final long serialVersionUID = -3059550493892424507L;
	private Long timeout;
	private Authentication authentication;
	private String ip;

	public Authentication getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getTimeout() {
		return this.timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
}