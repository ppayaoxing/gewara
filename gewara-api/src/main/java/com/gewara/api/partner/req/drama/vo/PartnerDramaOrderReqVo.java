package com.gewara.api.partner.req.drama.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public abstract class PartnerDramaOrderReqVo extends PartnerBaseReqVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5456581803863691933L;
	protected Long dpid;
	protected Long areaid;
	protected String mobile;
	protected Long disid;
	protected Long addressid;
	protected String origin;
	protected String takemethod;
	// 用户ID
	protected String memberEncode;
	// 合作商用户标识
	protected String ukey;
	protected String idnumber;
	
	protected String greetings;
	
	protected String joinCrm;

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getDisid() {
		return disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMemberEncode() {
		return memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public String getUkey() {
		return ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public String getJoinCrm() {
		return joinCrm;
	}

	public void setJoinCrm(String joinCrm) {
		this.joinCrm = joinCrm;
	}

}
