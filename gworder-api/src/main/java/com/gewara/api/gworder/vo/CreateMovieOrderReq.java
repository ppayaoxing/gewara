/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.gworder.vo.CreateOrderReq;
import com.gewara.api.gworder.vo.OrderMpiVo;
import org.apache.commons.lang.StringUtils;

public class CreateMovieOrderReq extends CreateOrderReq {
	private static final long serialVersionUID = 7886321040828404207L;
	public static String SOURCE_OPENAPI_PARTNER_SH = "openapi_partner_sh";
	public static String SOURCE_OPENAPI_MOBILE_SH = "openapi_mobile_sh";
	public static String SOURCE_PC_GEWA_SH = "pc_gewa_sh";
	public static String SOURCE_PC_PARTNER_SH = "pc_partner_sh";
	public static String SOURCE_H5_PARTNER_SH = "h5_partner_sh";
	public static String SOURCE_H5_GEWA_SH = "h5_gewa_sh";
	private String memberNickName;
	private String seatLabel;
	private String secid;
	private String mobile;
	private Long goodsid;
	private Integer quantity;
	private String spkey;
	private String origin;
	private String paymethod;
	private Long partnerId;
	private String partnerBriefname;
	private String partnerUkey;
	private String ignoreSeatPosValid = "N";
	private OrderMpiVo mpiVo;

	public CreateMovieOrderReq() {
	}

	public CreateMovieOrderReq(OrderMpiVo mpiVo, String mobile, String seatLabel, String remoteIp) {
		this.tag = "movie";
		this.mpiVo = mpiVo;
		this.relatedId = mpiVo.getMpid();
		this.mobile = mobile;
		this.seatLabel = seatLabel;
		this.remoteIp = remoteIp;
	}

	public String getMemberNickName() {
		return this.memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public String getSeatLabel() {
		return this.seatLabel;
	}

	public void setSeatLabel(String seatLabel) {
		this.seatLabel = seatLabel;
	}

	public String getSecid() {
		return this.secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSpkey() {
		return this.spkey;
	}

	public void setSpkey(String spkey) {
		this.spkey = spkey;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Long getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerBriefname() {
		return this.partnerBriefname;
	}

	public void setPartnerBriefname(String partnerBriefname) {
		this.partnerBriefname = partnerBriefname;
	}

	public String getPartnerUkey() {
		return this.partnerUkey;
	}

	public void setPartnerUkey(String partnerUkey) {
		this.partnerUkey = partnerUkey;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getIgnoreSeatPosValid() {
		return this.ignoreSeatPosValid;
	}

	public void setIgnoreSeatPosValid(String ignoreSeatPosValid) {
		this.ignoreSeatPosValid = ignoreSeatPosValid;
	}

	public boolean ignoreSeatPos() {
		return StringUtils.equals("Y", this.ignoreSeatPosValid);
	}

	public OrderMpiVo getMpiVo() {
		return this.mpiVo;
	}

	public void setMpiVo(OrderMpiVo mpiVo) {
		this.mpiVo = mpiVo;
	}
}