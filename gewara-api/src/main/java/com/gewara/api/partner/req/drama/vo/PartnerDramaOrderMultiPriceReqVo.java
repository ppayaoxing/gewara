package com.gewara.api.partner.req.drama.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public class PartnerDramaOrderMultiPriceReqVo extends PartnerBaseReqVo {

	private static final long serialVersionUID = -7626218681370487250L;
	private String mobile;
	private String pricelist;
	private Long addressid;
	private String takemethod;
	private String origin;
	// 用户ID
	private String memberEncode;
	// 合作商用户标识
	private String ukey;
	private String idnumber;
	
	private String greetings;

	public PartnerDramaOrderMultiPriceReqVo(String appkey, String pricelist, String mobile, String memberEncode){
		this.appkey = appkey;
		this.pricelist = pricelist;
		this.mobile = mobile;
		this.memberEncode = memberEncode;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPricelist() {
		return pricelist;
	}

	public void setPricelist(String pricelist) {
		this.pricelist = pricelist;
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
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

}
