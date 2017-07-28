/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.req;

import java.io.Serializable;

public abstract class AbstractCheckDramaRollCallReq implements Serializable {
	private static final long serialVersionUID = 4069305758115359219L;
	protected String siteSource;
	protected Long dramaid;
	protected Long theatreid;
	protected Long memberid;
	protected String mobile;
	protected String idcard;

	public String getSiteSource() {
		return this.siteSource;
	}

	public void setSiteSource(String siteSource) {
		this.siteSource = siteSource;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
}