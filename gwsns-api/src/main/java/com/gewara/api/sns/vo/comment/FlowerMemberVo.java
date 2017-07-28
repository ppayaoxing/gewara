/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class FlowerMemberVo extends BaseVo {
	private static final long serialVersionUID = 1L;
	private String ckey;
	private Long memberid;
	private String type;
	private Long relatedid;
	private Timestamp addtime;
	private String source;
	private Long parentid;
	private String parenttype;

	public Serializable realId() {
		return this.ckey;
	}

	public String getCkey() {
		return this.ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getParentid() {
		return this.parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getParenttype() {
		return this.parenttype;
	}

	public void setParenttype(String parenttype) {
		this.parenttype = parenttype;
	}
}