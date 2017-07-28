/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.json;

import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class SysWarn implements Serializable {
	private static final long serialVersionUID = -6022767342336750391L;
	private String title;
	private String tag;
	private String level;
	private Serializable relatedid;
	private String content;
	private String status;
	private String role;
	private String adddate;
	private String addtime;
	private String vuser;
	private String auser;
	private String fuser;
	private String otherinfo;

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getVuser() {
		return this.vuser;
	}

	public void setVuser(String vuser) {
		this.vuser = vuser;
	}

	public String getAuser() {
		return this.auser;
	}

	public void setAuser(String auser) {
		this.auser = auser;
	}

	public String getFuser() {
		return this.fuser;
	}

	public void setFuser(String fuser) {
		this.fuser = fuser;
	}

	public SysWarn() {
		this.status = "N";
		this.adddate = DateUtil.formatDate(new Date());
		this.addtime = DateUtil.formatTimestamp(new Date());
	}

	public SysWarn(String title, String content, String role) {
		this();
		this.title = title;
		this.content = content;
		this.role = role;
	}

	public SysWarn(String title, String tag, Long relatedid, String content, String role) {
		this();
		this.title = title;
		this.tag = tag;
		this.relatedid = relatedid;
		this.content = content;
		this.role = role;
	}

	public String getAdddate() {
		return this.adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Serializable getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Serializable relatedid) {
		this.relatedid = relatedid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void addView(String user) {
		if (StringUtils.isBlank(this.vuser)) {
			this.vuser = user;
		} else {
			this.vuser = this.vuser + user;
		}

	}

	public boolean isViewed(String user) {
		return StringUtils.contains(this.vuser, user);
	}

	public void addAccept(String user) {
		if (StringUtils.isBlank(this.auser)) {
			this.auser = user;
		} else {
			this.auser = this.auser + user;
		}

	}

	public void addFixed(String user) {
		if (StringUtils.isBlank(this.fuser)) {
			this.fuser = user;
		} else {
			this.fuser = this.fuser + user;
		}

	}

	public void addOtherInfo(String other) {
		if (StringUtils.isBlank(this.otherinfo)) {
			this.otherinfo = other;
		} else {
			this.otherinfo = this.otherinfo + other;
		}

	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}