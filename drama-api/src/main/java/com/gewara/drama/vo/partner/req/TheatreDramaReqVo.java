/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerDramaReqVo;

public class TheatreDramaReqVo extends PartnerDramaReqVo {
	private static final long serialVersionUID = 7276826866180688064L;
	private Long theatreid;

	public TheatreDramaReqVo(Long theatreid, String appkey, String citycode) {
		this.theatreid = theatreid;
		this.appkey = appkey;
		this.citycode = citycode;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}
}