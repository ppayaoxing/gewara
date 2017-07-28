/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerDramaOrderReqVo;

public class PartnerDramaOrderSeatReqVo extends PartnerDramaOrderReqVo {
	private static final long serialVersionUID = 4295247065590890899L;
	private String seatLabel;

	public PartnerDramaOrderSeatReqVo(String appkey, Long areaid, String seatLabel, String memberEncode) {
		this.appkey = appkey;
		this.areaid = areaid;
		this.seatLabel = seatLabel;
		this.memberEncode = memberEncode;
	}

	public String getSeatLabel() {
		return this.seatLabel;
	}

	public void setSeatLabel(String seatLabel) {
		this.seatLabel = seatLabel;
	}
}