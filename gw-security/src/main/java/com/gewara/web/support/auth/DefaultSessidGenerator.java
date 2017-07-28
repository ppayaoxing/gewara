/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support.auth;

import com.gewara.util.StringUtil;
import com.gewara.web.support.auth.SessidGenerator;
import org.springframework.security.core.Authentication;

public class DefaultSessidGenerator implements SessidGenerator {
	public String generateSessid(Authentication auth) {
		String key = StringUtil.getRandomString(24);
		String ukey = key + StringUtil.md5(key + "testKeyMemberLogon", 8);
		return ukey;
	}
}