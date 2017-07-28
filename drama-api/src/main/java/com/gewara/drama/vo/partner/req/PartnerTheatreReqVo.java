/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerPageReqVo;

public class PartnerTheatreReqVo extends PartnerPageReqVo {
	private static final long serialVersionUID = 3061884031267148555L;
	private Long dramaid;

	public PartnerTheatreReqVo(String appkey, String citycode) {
		this.appkey = appkey;
		this.citycode = citycode;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}
}