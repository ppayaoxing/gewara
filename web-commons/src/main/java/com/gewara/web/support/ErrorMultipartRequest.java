/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

public class ErrorMultipartRequest extends AbstractMultipartHttpServletRequest implements MultipartHttpServletRequest {
	private String errorMsg;

	public ErrorMultipartRequest(HttpServletRequest request, String errorMsg) {
		super(request);
		this.setMultipartFiles(new LinkedMultiValueMap());
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpHeaders getMultipartHeaders(String paramOrFileName) {
		return null;
	}

	public String getMultipartContentType(String paramOrFileName) {
		return null;
	}
}