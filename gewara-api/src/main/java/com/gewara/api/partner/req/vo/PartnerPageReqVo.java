/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;

public class PartnerPageReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = 7490043716132851414L;
	private Integer from;
	private Integer maxnum;

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
}