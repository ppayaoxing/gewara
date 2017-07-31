package com.gewara.api.partner.req.drama.vo;

public class PartnerDramaOrderSeatReqVo extends PartnerDramaOrderReqVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4295247065590890899L;
	private String seatLabel;

	public PartnerDramaOrderSeatReqVo(String appkey, Long areaid, String seatLabel, String memberEncode){
		this.appkey = appkey;
		this.areaid = areaid;
		this.seatLabel = seatLabel;
		this.memberEncode = memberEncode;
	}
	
	public String getSeatLabel() {
		return seatLabel;
	}

	public void setSeatLabel(String seatLabel) {
		this.seatLabel = seatLabel;
	}

}
