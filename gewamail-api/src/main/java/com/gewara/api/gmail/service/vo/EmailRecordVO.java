package com.gewara.api.gmail.service.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 邮件对象
 * @author zhaorq
 *
 */
public class EmailRecordVO implements Serializable {

	private static final long serialVersionUID = -6346809268260336714L;
	public static final String SENDER = "格瓦拉生活网";
	
	private String sender; // 发送者
	private String title; // 标题
	private String content; // 内容
	private String otherinfo;//其他信息：如附件信息AttachmentInfos:[{"fileName":"","filePath":""},...]
	private List<Map<String, Object>> attachments;//附件内容
	private String email; // 地址   支持;分割
	private String mailtype="html"; // 邮件类型 两种：html 或者txt
	private Timestamp sendtime; // 发送时间
	private Timestamp validtime; // 超时时间
	private Timestamp addtime = new Timestamp(System.currentTimeMillis());
	
	private String template;
	
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}

	public EmailRecordVO() {
	}

	public EmailRecordVO(String sender) {
		this();
		this.sender = sender;
	}
	
	public EmailRecordVO(String title, String content, String email, Timestamp sendtime) {
		this(title, content, email, null, sendtime, SENDER);
	}

	public EmailRecordVO(String title, String content, String email, String template, Timestamp sendtime) {
		this(title, content, email, template, sendtime, SENDER);
	}

	public EmailRecordVO(String title, String content, String email, String template, Timestamp sendtime, String sender) {
		this(sender);
		this.title = title;
		this.content = content;
		this.email = email;
		this.template = template;
		this.sendtime = sendtime;
	}

	public EmailRecordVO(String title, String content, String email) {
		this(title, content, email, null, new Timestamp(System.currentTimeMillis()), SENDER);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getSendtime() {
		return sendtime;
	}

	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getMailtype() {
		return mailtype;
	}

	public void setMailtype(String mailtype) {
		this.mailtype = mailtype;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public List<Map<String, Object>> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Map<String, Object>> attachments) {
		this.attachments = attachments;
	}	
}
