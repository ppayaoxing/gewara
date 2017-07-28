/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public class PartnerOrderRefundInfoReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = -8611527357724405278L;
	private String memberEncode;
	private String ukey;
	private String tradeNo;
	private String retback;
	private String reasoninfo;
	private String clienttype;
	private String authcode;

	public PartnerOrderRefundInfoReqVo() {
	}

	public PartnerOrderRefundInfoReqVo(String appkey, String tradeNo, String remoteIp) {
		this.appkey = appkey;
		this.tradeNo = tradeNo;
		this.remoteIp = remoteIp;
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

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getRetback() {
		return this.retback;
	}

	public void setRetback(String retback) {
		this.retback = retback;
	}

	public String getReasoninfo() {
		return this.reasoninfo;
	}

	public void setReasoninfo(String reasoninfo) {
		this.reasoninfo = reasoninfo;
	}

	public String getClienttype() {
		return this.clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

	public String getAuthcode() {
		return this.authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
}