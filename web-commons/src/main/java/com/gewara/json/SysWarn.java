/**
 * 
 */
package com.gewara.json;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.util.DateUtil;

public class SysWarn implements Serializable{
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
	private String vuser;		//view锟介看锟斤拷锟斤拷锟斤拷
	private String auser;		//accept锟斤拷锟杰达拷锟斤拷锟斤拷锟斤拷锟�
	private String fuser;		//fixed锟斤拷纱锟斤拷锟斤拷锟斤拷锟斤拷
	private String otherinfo;
	
	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getVuser() {
		return vuser;
	}

	public void setVuser(String vuser) {
		this.vuser = vuser;
	}

	public String getAuser() {
		return auser;
	}

	public void setAuser(String auser) {
		this.auser = auser;
	}

	public String getFuser() {
		return fuser;
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

	public SysWarn(String title, String tag, Long relatedid, String content,
			String role) {
		this();
		this.title = title;
		this.tag = tag;
		this.relatedid = relatedid;
		this.content = content;
		this.role = role;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Serializable getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Serializable relatedid) {
		this.relatedid = relatedid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void addView(String user) {
		if(StringUtils.isBlank(vuser)) {
            vuser = user;
        } else {
            vuser += user;
        }
	}
	public boolean isViewed(String user) {
		return StringUtils.contains(vuser, user);
	}
	public void addAccept(String user) {
		if(StringUtils.isBlank(auser)) {
            auser = user;
        } else {
            auser += user;
        }
	}
	public void addFixed(String user) {
		if(StringUtils.isBlank(fuser)) {
            fuser = user;
        } else {
            fuser += user;
        }
	}
	public void addOtherInfo(String other){
		if(StringUtils.isBlank(otherinfo)) {
            otherinfo = other;
        } else {
            otherinfo += other;
        }
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
