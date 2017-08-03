package com.gewara.drama.vo.partner.req;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class PartnerOrderQueryReqVo extends BaseVo{
	private static final long serialVersionUID = 5479555700521303430L;
	private String memberEncode;
	private String orderType;
	private Integer from;
	private Integer maxnum;
	public PartnerOrderQueryReqVo(){
		
	}
	public PartnerOrderQueryReqVo(String memberEncode, String orderType, Integer from, Integer maxnum){
		this.memberEncode = memberEncode;
		this.orderType = orderType;
		this.from = from;
		this.maxnum = maxnum;
	}
	@Override
	public Serializable realId() {
		return memberEncode;
	}
	public String getMemberEncode() {
		return memberEncode;
	}
	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
