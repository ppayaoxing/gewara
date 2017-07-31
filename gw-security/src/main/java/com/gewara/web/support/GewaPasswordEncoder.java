package com.gewara.web.support;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gewara.util.StringUtil;

public class GewaPasswordEncoder implements PasswordEncoder{
	@Override
	public String encode(CharSequence rawPassword) {
		return StringUtil.md5(StringUtil.md5(rawPassword.toString()) + "xxyyzz@@22");
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return StringUtil.md5(StringUtil.md5(rawPassword.toString()) + "xxyyzz@@22").equals(encodedPassword);
	}
}
