/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerPageReqVo;

public class QueryReserveOrderReqVo extends PartnerPageReqVo {
	private static final long serialVersionUID = -1216750059918334410L;
	private Long memberid;

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
}