/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.component;

import com.gewara.model.acl.GewaraUser;
import com.gewara.support.ErrorCode;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

public interface LoginService {
	ErrorCode<Map> autoLogin(HttpServletRequest arg0, HttpServletResponse arg1, String arg2, String arg3);

	GewaraUser getLogonGewaraUserBySessid(String arg0, String arg1);

	Authentication loadAuthentication(String arg0, String arg1);

	boolean isGewaraUserLogon(HttpServletRequest arg0, String arg1);

	ErrorCode<Map> ssoAutoLogin(HttpServletRequest arg0, HttpServletResponse arg1, String arg2);

	void removeInvalidSessid(String arg0);
}