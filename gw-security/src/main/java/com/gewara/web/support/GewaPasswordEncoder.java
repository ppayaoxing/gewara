/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.util.StringUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GewaPasswordEncoder implements PasswordEncoder {
	public String encode(CharSequence rawPassword) {
		return StringUtil.md5(StringUtil.md5(rawPassword.toString()) + "xxyyzz@@22");
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return StringUtil.md5(StringUtil.md5(rawPassword.toString()) + "xxyyzz@@22").equals(encodedPassword);
	}
}