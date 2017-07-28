/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gmail.request;

import com.gewara.api.MsgRequest;
import java.sql.Timestamp;

public class SendMailByOutboxRequest extends MsgRequest {
	private static final long serialVersionUID = 1202208449828370482L;
	public static final String SENDER = "格瓦拉生活网";
	public static final String OUTBOX_SERVICE = "service";
	public static final String OUTBOX_OPERATION021 = "operation021";
	private String outbox;
	private String fromName;
	private String to;
	private String title;
	private String content;
	private String template;
	private Timestamp sendTime;
	private Timestamp validTime;
	private String sendType;

	public SendMailByOutboxRequest() {
	}

	public SendMailByOutboxRequest(String outbox, String to, String title, String content) {
		this(outbox, "格瓦拉生活网", to, title, content);
	}

	public SendMailByOutboxRequest(String outbox, String fromName, String to, String title, String content) {
		this.outbox = outbox;
		if (fromName != null && !fromName.trim().equals("")) {
			this.fromName = fromName;
		} else {
			this.fromName = "格瓦拉生活网";
		}

		this.to = to;
		this.title = title;
		this.content = content;
	}

	public SendMailByOutboxRequest(String outbox, String fromName, String to, String title, String content,
			String template) {
		this(outbox, fromName, to, title, content);
		this.template = template;
	}

	public SendMailByOutboxRequest(String outbox, String fromName, String to, String title, String content,
			String template, Timestamp sendTime) {
		this(outbox, fromName, to, title, content);
		this.template = template;
		this.sendTime = sendTime;
	}

	public SendMailByOutboxRequest(String outbox, String to, String title, String content, String template,
			Timestamp sendTime) {
		this(outbox, "格瓦拉生活网", to, title, content, template, sendTime);
	}

	public String getOutbox() {
		return this.outbox;
	}

	public void setOutbox(String outbox) {
		this.outbox = outbox;
	}

	public String getFromName() {
		return this.fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Timestamp getValidTime() {
		return this.validTime;
	}

	public void setValidTime(Timestamp validTime) {
		this.validTime = validTime;
	}

	public String getSendType() {
		return this.sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
}