package com.gewara.drama.vo.partner.req;


public class ReserveOrderReqVo extends PartnerBaseReqVo {

	private static final long serialVersionUID = 2153601322126376599L;
	private Long matcherid;
	private Long memberid;
	private String remark;
	private Integer quantity;
	private String memberEncode;

	public Long getMatcherid() {
		return matcherid;
	}
	
	public void setMatcherid(Long matcherid) {
		this.matcherid = matcherid;
	}
	
	public Long getMemberid() {
		return memberid;
	}
	
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMemberEncode() {
		return memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

}
