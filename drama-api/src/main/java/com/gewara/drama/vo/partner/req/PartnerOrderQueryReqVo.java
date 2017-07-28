/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class PartnerOrderQueryReqVo extends BaseVo {
	private static final long serialVersionUID = 5479555700521303430L;
	private String memberEncode;
	private String orderType;
	private Integer from;
	private Integer maxnum;

	public PartnerOrderQueryReqVo() {
	}

	public PartnerOrderQueryReqVo(String memberEncode, String orderType, Integer from, Integer maxnum) {
		this.memberEncode = memberEncode;
		this.orderType = orderType;
		this.from = from;
		this.maxnum = maxnum;
	}

	public Serializable realId() {
		return this.memberEncode;
	}

	public String getMemberEncode() {
		return this.memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public Integer getFrom() {
		return this.from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}