package com.gewara.support.magent;

import org.apache.commons.lang.StringUtils;

public class CmdMessage {
	private String cmd;			//消息内容
	private String params;		//消息参数
	private String userFrom;	//发送人
	private Long timestamp;		//时间
	public CmdMessage(String cmd, String userFrom){
		this.timestamp = System.currentTimeMillis();
		this.userFrom = userFrom;
		int idx = StringUtils.indexOf(cmd, " ");
		if(idx<0){
			this.cmd = cmd;
		}else{
			this.cmd = StringUtils.substring(cmd, 0, idx);
			this.params = StringUtils.trim(StringUtils.substring(cmd, idx+1));
		}
	}
	public String getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
