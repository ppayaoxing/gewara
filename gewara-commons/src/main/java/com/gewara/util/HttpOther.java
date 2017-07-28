/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.HttpMethod;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class HttpOther extends HttpEntityEnclosingRequestBase {
	private String method;

	public HttpOther(HttpMethod method) {
		this.method = method.name();
	}

	public String getMethod() {
		return this.method;
	}
}