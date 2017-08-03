package com.gewara.drama.vo.partner.req;

import java.util.Date;

public class CheckReserveOrderReqVo extends PartnerBaseReqVo {

	private static final long serialVersionUID = 5878041220842824485L;
	private Long dramaid;
	private Long memberid;
	private Date reservedate;
	private String memberEncode;
	public Long getDramaid() {
		return dramaid;
	}
	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Date getReservedate() {
		return reservedate;
	}
	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}
	public String getMemberEncode() {
		return memberEncode;
	}
	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}
	
	
}
