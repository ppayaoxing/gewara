/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.model.acl.GewaraUser;
import com.gewara.support.ErrorCode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SSOClientService {
	String getLoginUrl(HttpServletRequest arg0);

	ErrorCode<GewaraUser> getGewaraUser(HttpServletRequest arg0, HttpServletResponse arg1, String arg2);

	void setTargetUrlParameter(String arg0);
}