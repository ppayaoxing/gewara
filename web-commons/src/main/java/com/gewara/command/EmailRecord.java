/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.command;

import java.io.Serializable;
import java.sql.Timestamp;

public class EmailRecord implements Serializable {
	private static final long serialVersionUID = -6346809268260336714L;
	public static final String SENDER_WARNING = "warning";
	public static final String SENDER_GEWARA = "格瓦拉生活网";
	public static final String SENDER_GEWA = "gewara";
	private Long id;
	private String sender;
	private String title;
	private String content;
	private String email;
	private String type;
	private String mailtype;
	private String tag;
	private Long relatedid;
	private Timestamp sendtime;
	private String status;
	private String template;
	private Integer sendnum;
	private Timestamp validtime;

	public Integer getSendnum() {
		return this.sendnum;
	}

	public void setSendnum(Integer sendnum) {
		this.sendnum = sendnum;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public EmailRecord() {
	}

	public EmailRecord(String sender) {
		this.status = "N";
		this.sender = sender;
		this.sendnum = Integer.valueOf(0);
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

	public EmailRecord(String sender, String title, String content, String email, Timestamp sendtime,
			Timestamp validtime) {
		this(sender, title, content, email, sendtime);
		this.validtime = validtime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (!(o instanceof EmailRecord)) {
			return false;
		} else {
			boolean arg9999;
			label34 : {
				EmailRecord temp = (EmailRecord) o;
				if (this.getId() != null) {
					if (this.getId().equals(temp.getId())) {
						break label34;
					}
				} else if (temp.getId() == null) {
					break label34;
				}

				arg9999 = false;
				return arg9999;
			}

			arg9999 = true;
			return arg9999;
		}
	}

	public int hashCode() {
		return this.getId() != null ? this.getId().hashCode() : 0;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void addSendnum() {
		if (this.sendnum == null) {
			this.sendnum = Integer.valueOf(0);
		}

		this.sendnum = Integer.valueOf(this.sendnum.intValue() + 1);
	}

	public String getMailtype() {
		return this.mailtype;
	}

	public void setMailtype(String mailtype) {
		this.mailtype = mailtype;
	}
}