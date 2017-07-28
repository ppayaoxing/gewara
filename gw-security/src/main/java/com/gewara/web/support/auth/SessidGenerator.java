/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support.auth;

import org.springframework.security.core.Authentication;

public interface SessidGenerator {
	String generateSessid(Authentication arg0);
}