/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gmail.service.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class EmailRecordVO implements Serializable {
	private static final long serialVersionUID = -6346809268260336714L;
	public static final String SENDER = "格瓦拉生活网";
	private String sender;
	private String title;
	private String content;
	private String otherinfo;
	private List<Map<String, Object>> attachments;
	private String email;
	private String mailtype;
	private Timestamp sendtime;
	private Timestamp validtime;
	private Timestamp addtime;
	private String template;

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public EmailRecordVO() {
		this.mailtype = "html";
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public EmailRecordVO(String sender) {
		this();
		this.sender = sender;
	}

	public EmailRecordVO(String title, String content, String email, Timestamp sendtime) {
		this(title, content, email, (String) null, sendtime, "格瓦拉生活网");
	}

	public EmailRecordVO(String title, String content, String email, String template, Timestamp sendtime) {
		this(title, content, email, template, sendtime, "格瓦拉生活网");
	}

	public EmailRecordVO(String title, String content, String email, String template, Timestamp sendtime,
			String sender) {
		this(sender);
		this.title = title;
		this.content = content;
		this.email = email;
		this.template = template;
		this.sendtime = sendtime;
	}

	public EmailRecordVO(String title, String content, String email) {
		this(title, content, email, (String) null, new Timestamp(System.currentTimeMillis()), "格瓦拉生活网");
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getMailtype() {
		return this.mailtype;
	}

	public void setMailtype(String mailtype) {
		this.mailtype = mailtype;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public List<Map<String, Object>> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Map<String, Object>> attachments) {
		this.attachments = attachments;
	}
}