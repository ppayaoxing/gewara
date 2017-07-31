package com.gewara.api.gworder.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ValidateOpenApiPayVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5641516643707695035L;

	private String tradeNo;
	
	/**
	 * 返回success,表示成功，否则是错误信息
	 */
	private String result;

	private String briefname;		//简称
	private String partnerip;		//合作伙伴IP
	private String partnerkey;		//验证身份key
	private String timeoutReturn;

	@Override
	public Serializable realId() {
		return tradeNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPartnerip() {
		return partnerip;
	}

	public void setPartnerip(String partnerip) {
		this.partnerip = partnerip;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBriefname() {
		return briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}

	public String getPartnerkey() {
		return partnerkey;
	}

	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}

	public String getTimeoutReturn() {
		return timeoutReturn;
	}

	public void setTimeoutReturn(String timeoutReturn) {
		this.timeoutReturn = timeoutReturn;
	}

}
