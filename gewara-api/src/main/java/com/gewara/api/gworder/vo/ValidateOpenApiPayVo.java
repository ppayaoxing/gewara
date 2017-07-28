/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ValidateOpenApiPayVo extends BaseVo {
	private static final long serialVersionUID = -5641516643707695035L;
	private String tradeNo;
	private String result;
	private String briefname;
	private String partnerip;
	private String partnerkey;
	private String timeoutReturn;

	public Serializable realId() {
		return this.tradeNo;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPartnerip() {
		return this.partnerip;
	}

	public void setPartnerip(String partnerip) {
		this.partnerip = partnerip;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBriefname() {
		return this.briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}

	public String getPartnerkey() {
		return this.partnerkey;
	}

	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}

	public String getTimeoutReturn() {
		return this.timeoutReturn;
	}

	public void setTimeoutReturn(String timeoutReturn) {
		this.timeoutReturn = timeoutReturn;
	}
}