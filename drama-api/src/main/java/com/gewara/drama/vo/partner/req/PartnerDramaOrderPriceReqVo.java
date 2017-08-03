package com.gewara.drama.vo.partner.req;

public class PartnerDramaOrderPriceReqVo extends PartnerDramaOrderReqVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3611218051278952630L;
	private Long priceid;
	private Integer quantity;

	public PartnerDramaOrderPriceReqVo(String appkey, Long priceid, Integer quantity, String memberEncode){
		this.appkey = appkey;
		this.priceid = priceid;
		this.quantity = quantity;
		this.memberEncode = memberEncode;
	}
	
	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
