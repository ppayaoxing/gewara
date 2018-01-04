package com.gewara.gmessage.external.entity;
import java.io.Serializable;
import java.util.Map;


/**
 * 消息发送状态
 * 本期不实现。占坑
 * @author user
 *
 */
public class MessageSendState implements Serializable{

	private static final long serialVersionUID = -2838290126478956154L;

	/**消息ID*/
	private Long messageID=null;
	
	/**用来表示sms每个用户的发送状态*/
	private Map<String,Boolean> sms=null;
	
	/**用来表示push每个用户的发送状态*/
	private Map<String,Boolean> push=null;
	
	/**用来表示站内信的每个用户的发送状态*/
	private Map<String,Boolean> website=null;

	public Long getMessageID() {
		return messageID;
	}

	public void setMessageID(Long messageID) {
		this.messageID = messageID;
	}

	public Map<String, Boolean> getSms() {
		return sms;
	}

	public void setSms(Map<String, Boolean> sms) {
		this.sms = sms;
	}

	public Map<String, Boolean> getPush() {
		return push;
	}

	public void setPush(Map<String, Boolean> push) {
		this.push = push;
	}

	public Map<String, Boolean> getWebsite() {
		return website;
	}

	public void setWebsite(Map<String, Boolean> website) {
		this.website = website;
	}
	
}
