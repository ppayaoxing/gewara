/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.req.common;

import com.gewara.drama.vo.req.common.AbstractPageReqVo;

public class ZeroGrabReqVo extends AbstractPageReqVo {
	private static final long serialVersionUID = 2501271421373456325L;
	private Long priceid;
	private String mobile;
	private String tradeno;
	private String processLevel;

	public ZeroGrabReqVo() {
		this.from = 0;
		this.maxnum = 25;
	}

	public ZeroGrabReqVo(Long priceid, String mobile, String tradeno, String processLevel, int from, int maxnum) {
		this.from = from;
		this.maxnum = maxnum;
		this.priceid = priceid;
		this.mobile = mobile;
		this.tradeno = tradeno;
		this.processLevel = processLevel;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getProcessLevel() {
		return this.processLevel;
	}

	public void setProcessLevel(String processLevel) {
		this.processLevel = processLevel;
	}
}