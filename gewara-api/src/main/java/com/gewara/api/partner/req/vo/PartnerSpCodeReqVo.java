/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public class PartnerSpCodeReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = -2653251556198892366L;
	private Long spid;
	private String memberEncode;
	private Long orderId;
	private String tradeNo;
	private Long discountId;
	private Integer from;
	private Integer maxnum;

	public PartnerSpCodeReqVo() {
	}

	public PartnerSpCodeReqVo(Long spid, String memberEncode, Integer from, Integer maxnum) {
		this.spid = spid;
		this.memberEncode = memberEncode;
		this.from = from;
		this.maxnum = maxnum;
	}

	public Long getSpid() {
		return this.spid;
	}

	public void setSpid(Long spid) {
		this.spid = spid;
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

	public String getMemberEncode() {
		return this.memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}
}