package com.gewara.drama.vo.partner.req;

import java.util.Map;

public class PartnerOrderInfoReqVo extends PartnerBaseReqVo{
	private static final long serialVersionUID = -8611527357724405278L;
	private String memberEncode;
	private String ukey;
	private Long orderId;
	private String tradeNo;
	private String payMethod;
	private Long discountId;
	private String payPass;
	
	private String cardno;
	private String cardpass;
	private Long spid;
	
	private Map<String, String> otherinfoMap;
	
	public Long getSpid() {
		return spid;
	}
	public void setSpid(Long spid) {
		this.spid = spid;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCardpass() {
		return cardpass;
	}
	public void setCardpass(String cardpass) {
		this.cardpass = cardpass;
	}
	public PartnerOrderInfoReqVo(){
		
	}
	public PartnerOrderInfoReqVo(String appkey, String tradeNo, String remoteIp){
		this.appkey = appkey;
		this.tradeNo = tradeNo;
		this.remoteIp = remoteIp;
	}
	public String getPayPass() {
		return payPass;
	}

	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public String getMemberEncode() {
		return memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public String getUkey() {
		return ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public Map<String, String> getOtherinfoMap() {
		return otherinfoMap;
	}
	public void setOtherinfoMap(Map<String, String> otherinfoMap) {
		this.otherinfoMap = otherinfoMap;
	}

}
