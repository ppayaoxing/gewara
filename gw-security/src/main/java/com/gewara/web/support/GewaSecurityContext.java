package com.gewara.web.support;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;

import com.gewara.util.DateUtil;

public class GewaSecurityContext extends SecurityContextImpl{
	private static final long serialVersionUID = -9043460064031898610L;
	private long TIMEOUT_INCREAMENT = DateUtil.m_minute*20;
	private long timeoutMill;
	private String ip;
	@Override
	public Authentication getAuthentication() {
		if(System.currentTimeMillis() > timeoutMill) {
            return null;
        }
		return super.getAuthentication();
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}
	public boolean isTimeout(){
		return System.currentTimeMillis() > timeoutMill;
	}
	public void addTimeout(){
		timeoutMill = System.currentTimeMillis() + TIMEOUT_INCREAMENT;
	}
}
