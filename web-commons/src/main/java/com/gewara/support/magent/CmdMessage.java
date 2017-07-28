/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import org.apache.commons.lang.StringUtils;

public class CmdMessage {
	private String cmd;
	private String params;
	private String userFrom;
	private Long timestamp = Long.valueOf(System.currentTimeMillis());

	public CmdMessage(String cmd, String userFrom) {
		this.userFrom = userFrom;
		int idx = StringUtils.indexOf(cmd, " ");
		if (idx < 0) {
			this.cmd = cmd;
		} else {
			this.cmd = StringUtils.substring(cmd, 0, idx);
			this.params = StringUtils.trim(StringUtils.substring(cmd, idx + 1));
		}

	}

	public String getUserFrom() {
		return this.userFrom;
	}

	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

	public String getCmd() {
		return this.cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}