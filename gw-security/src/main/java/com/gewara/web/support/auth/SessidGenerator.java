package com.gewara.web.support.auth;

import org.springframework.security.core.Authentication;

public interface SessidGenerator {

	/**
	 * 鐢熸垚sessid
	 * @param auth
	 * @return
	 */
	String generateSessid(Authentication auth);
	
}
