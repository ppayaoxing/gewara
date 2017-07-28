/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerDramaOrderReqVo;

public class PartnerDramaOrderPriceReqVo extends PartnerDramaOrderReqVo {
	private static final long serialVersionUID = -3611218051278952630L;
	private Long priceid;
	private Integer quantity;

	public PartnerDramaOrderPriceReqVo(String appkey, Long priceid, Integer quantity, String memberEncode) {
		this.appkey = appkey;
		this.priceid = priceid;
		this.quantity = quantity;
		this.memberEncode = memberEncode;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}