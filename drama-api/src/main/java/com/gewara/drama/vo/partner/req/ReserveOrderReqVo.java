/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerBaseReqVo;

public class ReserveOrderReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = 2153601322126376599L;
	private Long matcherid;
	private Long memberid;
	private String remark;
	private Integer quantity;
	private String memberEncode;

	public Long getMatcherid() {
		return this.matcherid;
	}

	public void setMatcherid(Long matcherid) {
		this.matcherid = matcherid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMemberEncode() {
		return this.memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}
}