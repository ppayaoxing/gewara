/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

public class GewaSecurityContext extends SecurityContextImpl {
	private static final long serialVersionUID = -9043460064031898610L;
	private long TIMEOUT_INCREAMENT = 1200000L;
	private long timeoutMill;
	private String ip;

	public Authentication getAuthentication() {
		return System.currentTimeMillis() > this.timeoutMill ? null : super.getAuthentication();
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public boolean isTimeout() {
		return System.currentTimeMillis() > this.timeoutMill;
	}

	public void addTimeout() {
		this.timeoutMill = System.currentTimeMillis() + this.TIMEOUT_INCREAMENT;
	}
}