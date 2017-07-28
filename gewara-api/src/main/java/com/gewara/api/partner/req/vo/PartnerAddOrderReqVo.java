/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.vo;

import com.gewara.api.partner.req.vo.PartnerBaseReqVo;
import java.util.Map;
import org.apache.commons.codec.binary.StringUtils;

public class PartnerAddOrderReqVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = -9010424348846855963L;
	private String secid;
	private String memberEncode;
	private String ukey;
	private Long mpid;
	private String mobile;
	private String seatLable;
	private Long goodsId;
	private Integer quantity;
	private Long discountId;
	private String origin;
	private String paybank;
	private String paymethod;
	private String ignoreSeatPosValid = "N";
	private Map<String, String> otherinfoMap;

	public PartnerAddOrderReqVo() {
	}

	public PartnerAddOrderReqVo(String appkey, Long mpid, String mobile, String seatLabel, String secid, String ukey,
			String memberEncode) {
		this.appkey = appkey;
		this.mpid = mpid;
		this.mobile = mobile;
		this.seatLable = seatLabel;
		this.secid = secid;
		this.ukey = ukey;
		this.memberEncode = memberEncode;
	}

	public String getSecid() {
		return this.secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSeatLable() {
		return this.seatLable;
	}

	public void setSeatLable(String seatLable) {
		this.seatLable = seatLable;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPaybank() {
		return this.paybank;
	}

	public void setPaybank(String paybank) {
		this.paybank = paybank;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Long getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public String getUkey() {
		return this.ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getMemberEncode() {
		return this.memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public Map<String, String> getOtherinfoMap() {
		return this.otherinfoMap;
	}

	public void setOtherinfoMap(Map<String, String> otherinfoMap) {
		this.otherinfoMap = otherinfoMap;
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
}