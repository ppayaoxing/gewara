/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import java.io.Serializable;
import java.util.Map;

public class MessageSendState implements Serializable {
	private static final long serialVersionUID = -2838290126478956154L;
	private Long messageID;
	private Map<String, Boolean> sms;
	private Map<String, Boolean> push;
	private Map<String, Boolean> website;

	public MessageSendState() {
		this.messageID = null;

		this.sms = null;

		this.push = null;

		this.website = null;
	}

	public Long getMessageID() {
		return this.messageID;
	}

	public void setMessageID(Long messageID) {
		this.messageID = messageID;
	}

	public Map<String, Boolean> getSms() {
		return this.sms;
	}

	public void setSms(Map<String, Boolean> sms) {
		this.sms = sms;
	}

	public Map<String, Boolean> getPush() {
		return this.push;
	}

	public void setPush(Map<String, Boolean> push) {
		this.push = push;
	}

	public Map<String, Boolean> getWebsite() {
		return this.website;
	}

	public void setWebsite(Map<String, Boolean> website) {
		this.website = website;
	}
}