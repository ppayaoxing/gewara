/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

public class DubboApiAuth {
	private String reqUri;
	private String systemid;
	private Long userid;
	private String username;
	private String sessionid;
	private String remoteIp;

	public DubboApiAuth(String reqUri, String systemid, Long userid, String username, String sessionid,
			String remoteIp) {
		this.reqUri = reqUri;
		this.systemid = systemid;
		this.userid = userid;
		this.username = username;
		this.sessionid = sessionid;
		this.remoteIp = remoteIp;
	}

	public String getReqUri() {
		return this.reqUri;
	}

	public String getSystemid() {
		return this.systemid;
	}

	public Long getUserid() {
		return this.userid;
	}

	public String getUsername() {
		return this.username;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public String getRemoteIp() {
		return this.remoteIp;
	}
}