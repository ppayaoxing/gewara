/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.drama.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public class PartnerDramaOrderMultiPriceReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = -7626218681370487250L;
	private String mobile;
	private String pricelist;
	private Long addressid;
	private String takemethod;
	private String origin;
	private String memberEncode;
	private String ukey;
	private String idnumber;
	private String greetings;

	public PartnerDramaOrderMultiPriceReqVo(String appkey, String pricelist, String mobile, String memberEncode) {
		this.appkey = appkey;
		this.pricelist = pricelist;
		this.mobile = mobile;
		this.memberEncode = memberEncode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPricelist() {
		return this.pricelist;
	}

	public void setPricelist(String pricelist) {
		this.pricelist = pricelist;
	}

	public Long getAddressid() {
		return this.addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
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
}