/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.gworder.drama.vo.UserAddressReqVo;
import com.gewara.api.gworder.vo.CreateOrderReq;
import org.apache.commons.lang.StringUtils;

public class CreateDramaOrderReq extends CreateOrderReq {
	private static final long serialVersionUID = 3742081079538472755L;
	public static String SOURCE_OPENAPI_PARTNER_SH = "openapi_partner_sh";
	public static String SOURCE_OPENAPI_MOBILE_SH = "openapi_mobile_sh";
	public static String SOURCE_PC_GEWA_SH = "pc_gewa_sh";
	public static String OPENTYPE_SEAT = "seat";
	public static String OPENTYPE_PRICE = "price";
	public static String OPENTYPE_AUTO = "auto";
	public static String OPENTYPE_MULTI_PRICE = "multiPrice";
	private Long areaid;
	private Long disid;
	private String seatLabel;
	private Long priceid;
	private Integer quantity;
	private String pricelist;
	private String openType;
	private Long partnerId;
	private String briefName;
	private String ukey;
	private String nickName;
	private String spkey;
	private String origin;
	private String mobile;
	private String idcard;
	private Integer orderPrice;
	private boolean checkIdcard = true;
	private String userType;
	private Long privilegeMemberid;
	private String greetings;
	private Integer percent;
	private String bindMobile;
	private String supperseller;
	private String include;
	private String takemethod;
	private Long userAddressid;
	private UserAddressReqVo addressReq;
	private boolean booking = true;
	private Long dpid;
	private Long configid;

	public CreateDramaOrderReq() {
	}

	public CreateDramaOrderReq(Long dpid, String mobile, String remoteIp, boolean booking) {
		this.tag = "drama";
		this.relatedId = dpid;
		this.mobile = mobile;
		this.remoteIp = remoteIp;
		this.booking = booking;
		this.dpid = dpid;
	}

	public Long getDisid() {
		return this.disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public String getSeatLabel() {
		return this.seatLabel;
	}

	public void setSeatLabel(String seatLabel) {
		this.seatLabel = seatLabel;
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

	public String getPricelist() {
		return this.pricelist;
	}

	public void setPricelist(String pricelist) {
		this.pricelist = pricelist;
	}

	public Long getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
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

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public boolean isCheckIdcard() {
		return this.checkIdcard;
	}

	public void setCheckIdcard(boolean checkIdcard) {
		this.checkIdcard = checkIdcard;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getOpenType() {
		return this.openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public boolean hasPUsertype() {
		return StringUtils.equals(this.userType, "P");
	}

	public String getUkey() {
		return this.ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getBriefName() {
		return this.briefName;
	}

	public void setBriefName(String briefName) {
		this.briefName = briefName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public String getGreetings() {
		return this.greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public Integer getPercent() {
		return this.percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	public String getSupperseller() {
		return this.supperseller;
	}

	public void setSupperseller(String supperseller) {
		this.supperseller = supperseller;
	}

	public String getBindMobile() {
		return this.bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public Long getUserAddressid() {
		return this.userAddressid;
	}

	public void setUserAddressid(Long userAddressid) {
		this.userAddressid = userAddressid;
	}

	public UserAddressReqVo getAddressReq() {
		return this.addressReq;
	}

	public void setAddressReq(UserAddressReqVo addressReq) {
		this.addressReq = addressReq;
	}

	public boolean isBooking() {
		return this.booking;
	}

	public void setBooking(boolean booking) {
		this.booking = booking;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getConfigid() {
		return this.configid;
	}

	public void setConfigid(Long configid) {
		this.configid = configid;
	}

	public Long getPrivilegeMemberid() {
		return this.privilegeMemberid;
	}

	public void setPrivilegeMemberid(Long privilegeMemberid) {
		this.privilegeMemberid = privilegeMemberid;
	}

	public String getInclude() {
		return this.include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public Integer getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}
}