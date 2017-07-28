/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.gworder.vo.CreateOrderReq;
import com.gewara.api.vo.goods.GoodsVo;
import java.sql.Timestamp;
import java.util.Map;

public class CreateGoodsOrderReq extends CreateOrderReq {
	public static String SOURCE_GOODS_MEAL4PARTNER = "meal4Partner";
	public static String SOURCE_GOODS_MEAL4MOBILE = "meal4Mobile";
	public static String SOURCE_GOODS_MEAL4PC = "meal4PC";
	public static String SOURCE_GOODS_TEAM4MOBILE = "team4Mobile";
	public static String SOURCE_GOODS_POINTCHANGE4PC = "pointChange4PC";
	public static String SOURCE_GOODS_PRE4PC = "pre4PC";
	public static String SOURCE_GOODS_PARTNER = "partner";
	public static String SOURCE_GOODS_MOBILE = "mobile";
	public static String SOURCE_GOODS_CARDDELAY = "CardDelay";
	public static String SOURCE_GOODS_PRESALES = "preSales";
	public static String SOURCE_GOODS_ACTIVITY = "activity";
	private static final long serialVersionUID = -6058984623011729279L;
	private GoodsVo goods;
	private String mobile;
	private Integer quantity;
	private Long placeid;
	private Long itemid;
	private Long partnerid;
	private String category;
	private String pricategory;
	private String ukey;
	private String origin;
	private String citycode;
	private Timestamp validtime;
	private String membername;
	private String ordertitle;
	private String otherinfo;
	private String paymethod;
	private String remark;
	private Map<String, String> descMap;

	public CreateGoodsOrderReq() {
	}

	public CreateGoodsOrderReq(String contextKey, String asyncQueueKey, String remoteIp, GoodsVo goods, Long memberid,
			String mobile, Integer quantity, String category, String pricategory) {
		super("goods", contextKey, asyncQueueKey, remoteIp, memberid, goods.getId());
		this.goods = goods;
		this.quantity = quantity;
		this.mobile = mobile;
		this.category = category;
		this.pricategory = pricategory;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPricategory() {
		return this.pricategory;
	}

	public void setPricategory(String pricategory) {
		this.pricategory = pricategory;
	}

	public String getUkey() {
		return this.ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<String, String> getDescMap() {
		return this.descMap;
	}

	public void setDescMap(Map<String, String> descMap) {
		this.descMap = descMap;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getOrdertitle() {
		return this.ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public GoodsVo getGoods() {
		return this.goods;
	}

	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
}