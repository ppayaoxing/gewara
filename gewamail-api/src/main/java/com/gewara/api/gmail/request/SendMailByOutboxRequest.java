package com.gewara.api.gmail.request;

import java.sql.Timestamp;

import com.gewara.api.MsgRequest;

public class SendMailByOutboxRequest extends MsgRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202208449828370482L;

	public static final String SENDER = "������������";
	
	/**������service@gewara.com���ʼ�*/
	public static final String OUTBOX_SERVICE = "service";
	/**������operation021@gewara.com���ʼ�*/
	public static final String OUTBOX_OPERATION021 = "operation021";

	/**
	 * ����
	 * ָ�������䣬Ŀǰֻ֧��������service��operation021
	 * ������� : OUTBOX_*
	 * 
	 */
	private String outbox;
	private String fromName; // ���������ƣ���Ҫ˵����
	/**����*/
	private String to; // �ռ���  ֧��;�ָ�
	/**����*/
	private String title; // ����
	/**����*/
	private String content; // ����
	private String template;//ģ��
	private Timestamp sendTime; // ����ʱ��
	private Timestamp validTime;// ��ʱʱ��
	private String sendType;// ��������

	public SendMailByOutboxRequest() {
	}
	
	public SendMailByOutboxRequest(String outbox,String to, String title, String content) {
		this(outbox,SENDER, to, title, content);
	}
	
	public SendMailByOutboxRequest(String outbox,String fromName, String to, String title, String content) {
		this.outbox = outbox;
		if(fromName == null || "".equals(fromName.trim())){
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
