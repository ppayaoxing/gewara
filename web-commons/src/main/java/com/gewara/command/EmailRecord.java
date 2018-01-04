package com.gewara.command;

import java.io.Serializable;
import java.sql.Timestamp;

public class EmailRecord implements Serializable{
	private static final long serialVersionUID = -6346809268260336714L;
	public static final String SENDER_WARNING 	= "warning";
	public static final String SENDER_GEWARA 	= "锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷";
	public static final String SENDER_GEWA 		= "gewara";

	private Long id;
	private String sender;			//锟斤拷锟斤拷锟斤拷
	private String title;			//锟斤拷锟斤拷
	private String content;			//锟斤拷锟斤拷
	private String email;			//锟斤拷址
	private String type;			//锟绞硷拷锟斤拷锟斤拷
	private String mailtype;		//锟绞硷拷锟斤拷锟斤拷
	private String tag;				//锟斤拷锟斤拷
	private Long relatedid;			//锟斤拷锟斤拷
	private Timestamp sendtime;	//锟斤拷锟斤拷时锟斤拷
	private String status;			//锟斤拷锟斤拷状态
	private String template;		//模锟斤拷
	private Integer sendnum;		//锟斤拷锟酵达拷锟斤拷
	private Timestamp validtime;	//锟斤拷效时锟斤拷
	
	public Integer getSendnum() {
		return sendnum;
	}

	public void setSendnum(Integer sendnum) {
		this.sendnum = sendnum;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public EmailRecord(){}
	
	public EmailRecord(String sender){
		this.status = "N";
		this.sender = sender;
		this.sendnum = 0;
	}
	
	public EmailRecord(String sender, String title, String content, String email) {
		this(sender, title, content, email, new Timestamp(System.currentTimeMillis()));
	}
	public EmailRecord(String sender, String title, String content, String email, Timestamp sendtime) {
		this(sender);
		this.title = title;
		this.content = content;
		this.email = email;
		this.sendtime = sendtime;
	}
	public EmailRecord(String sender, String title, String content, String email, Timestamp sendtime, Timestamp validtime) {
		this(sender, title, content, email, sendtime);
		this.validtime = validtime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
		if (!(o instanceof EmailRecord)) {
            return false;
        }
		final EmailRecord temp = (EmailRecord) o;
		return !(getId() != null ? !(getId().equals(temp.getId())) : (temp.getId() != null));
	}

	@Override
	public int hashCode() {
		return (getId() != null ? getId().hashCode() : 0);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	public void addSendnum(){
		if(sendnum==null) {
            this.sendnum = 0;
        }
		this.sendnum = this.sendnum + 1;
	}

	public String getMailtype() {
		return mailtype;
	}

	public void setMailtype(String mailtype) {
		this.mailtype = mailtype;
	}
}
