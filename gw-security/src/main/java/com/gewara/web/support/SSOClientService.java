package com.gewara.web.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gewara.model.acl.GewaraUser;
import com.gewara.support.ErrorCode;

public interface SSOClientService{
	String getLoginUrl(HttpServletRequest request);
	ErrorCode<GewaraUser> getGewaraUser(HttpServletRequest request, HttpServletResponse response, String sessid);
	void setTargetUrlParameter(String targetUrlParameter);
}
