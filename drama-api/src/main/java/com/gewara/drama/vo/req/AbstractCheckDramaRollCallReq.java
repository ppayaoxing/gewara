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
		return siteSource;
	}

	public void setSiteSource(String siteSource) {
		this.siteSource = siteSource;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

}
