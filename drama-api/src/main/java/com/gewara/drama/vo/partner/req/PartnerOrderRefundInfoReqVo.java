package com.gewara.drama.vo.partner.req;

public class PartnerOrderRefundInfoReqVo extends PartnerBaseReqVo{
	private static final long serialVersionUID = -8611527357724405278L;
	private String memberEncode;
	private String ukey;
	private String tradeNo;
	private String retback;
	private String reasoninfo;
	private String clienttype;
	private String authcode;
	
	public PartnerOrderRefundInfoReqVo(){
		
	}
	public PartnerOrderRefundInfoReqVo(String appkey, String tradeNo, String remoteIp){
		this.appkey = appkey;
		this.tradeNo = tradeNo;
		this.remoteIp = remoteIp;
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
	public String getRetback() {
		return retback;
	}
	public void setRetback(String retback) {
		this.retback = retback;
	}
	public String getReasoninfo() {
		return reasoninfo;
	}
	public void setReasoninfo(String reasoninfo) {
		this.reasoninfo = reasoninfo;
	}
	public String getClienttype() {
		return clienttype;
	}
	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}
	public String getAuthcode() {
		return authcode;
	}
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	
	
}
