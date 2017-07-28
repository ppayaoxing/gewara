/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.drama.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public abstract class PartnerDramaOrderReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = 5456581803863691933L;
	protected Long dpid;
	protected Long areaid;
	protected String mobile;
	protected Long disid;
	protected Long addressid;
	protected String origin;
	protected String takemethod;
	protected String memberEncode;
	protected String ukey;
	protected String idnumber;
	protected String greetings;
	protected String joinCrm;

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getDisid() {
		return this.disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public Long getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMemberEncode() {
		return this.memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public String getUkey() {
		return this.ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getGreetings() {
		return this.greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public String getJoinCrm() {
		return this.joinCrm;
	}

	public void setJoinCrm(String joinCrm) {
		this.joinCrm = joinCrm;
	}
}