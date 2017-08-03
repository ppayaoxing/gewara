package com.gewara.api.gmail.request;

import java.sql.Timestamp;

import com.gewara.api.MsgRequest;

public class SendMailByOutboxRequest extends MsgRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202208449828370482L;

	public static final String SENDER = "格瓦拉生活网";
	
	/**以邮箱service@gewara.com发邮件*/
	public static final String OUTBOX_SERVICE = "service";
	/**以邮箱operation021@gewara.com发邮件*/
	public static final String OUTBOX_OPERATION021 = "operation021";

	/**
	 * 必须
	 * 指定发件箱，目前只支持两个：service，operation021
	 * 详见常量 : OUTBOX_*
	 * 
	 */
	private String outbox;
	private String fromName; // 发送者名称（简要说明）
	/**必须*/
	private String to; // 收件人  支持;分割
	/**必须*/
	private String title; // 标题
	/**必须*/
	private String content; // 内容
	private String template;//模板
	private Timestamp sendTime; // 发送时间
	private Timestamp validTime;// 超时时间
	private String sendType;// 发送类型

	public SendMailByOutboxRequest() {
	}
	
	public SendMailByOutboxRequest(String outbox,String to, String title, String content) {
		this(outbox,SENDER, to, title, content);
	}
	
	public SendMailByOutboxRequest(String outbox,String fromName, String to, String title, String content) {
		this.outbox = outbox;
		if(fromName == null || fromName.trim().equals("")){
			this.fromName = SENDER;
		}else{
			this.fromName = fromName;
		}		
		this.to = to;
		this.title = title;
		this.content = content;
	}
	
	public SendMailByOutboxRequest(String outbox,String fromName, String to, String title, String content, String template) {
		this(outbox,fromName, to, title, content);
		this.template = template;
	}
	
	public SendMailByOutboxRequest(String outbox,String fromName, String to, String title, String content, String template, Timestamp sendTime) {
		this(outbox,fromName, to, title, content);
		this.template = template;
		this.sendTime = sendTime;
	}
	

	public SendMailByOutboxRequest(String outbox,String to, String title, String content, String template, Timestamp sendTime) {
		this(outbox,SENDER, to, title, content, template, sendTime);
	}


	public String getOutbox() {
		return outbox;
	}


	public void setOutbox(String outbox) {
		this.outbox = outbox;
	}


	public String getFromName() {
		return fromName;
	}


	public void setFromName(String fromName) {
		this.fromName = fromName;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTemplate() {
		return template;
	}


	public void setTemplate(String template) {
		this.template = template;
	}


	public Timestamp getSendTime() {
		return sendTime;
	}


	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}


	public Timestamp getValidTime() {
		return validTime;
	}


	public void setValidTime(Timestamp validTime) {
		this.validTime = validTime;
	}


	public String getSendType() {
		return sendType;
	}


	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

}
