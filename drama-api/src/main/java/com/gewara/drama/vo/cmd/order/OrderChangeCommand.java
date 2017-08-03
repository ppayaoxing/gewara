package com.gewara.drama.vo.cmd.order;

import java.io.Serializable;

public class OrderChangeCommand implements Serializable {

	private static final long serialVersionUID = 2098061738490151024L;

	private String tradeno;
	private Long memberid;
	private String mobile;
	private String status;
	
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
