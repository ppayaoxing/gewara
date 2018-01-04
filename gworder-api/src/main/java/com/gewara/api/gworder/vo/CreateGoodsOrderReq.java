package com.gewara.api.gworder.vo;

import java.sql.Timestamp;
import java.util.Map;

import com.gewara.api.vo.goods.GoodsVo;

public class CreateGoodsOrderReq extends CreateOrderReq{
	//一体机购买套餐
	public static String SOURCE_GOODS_MEAL4PARTNER = "meal4Partner";
	//手机app购买套餐
	public static String SOURCE_GOODS_MEAL4MOBILE = "meal4Mobile";
	//pc端购买套餐
	public static String SOURCE_GOODS_MEAL4PC = "meal4PC";
	//手机端拼团
	public static String SOURCE_GOODS_TEAM4MOBILE = "team4Mobile";
	//pc端积分兑换
	public static String SOURCE_GOODS_POINTCHANGE4PC = "pointChange4PC";
	//pc端预售
	public static String SOURCE_GOODS_PRE4PC = "pre4PC";
		
	//创建套餐订单：合作商
	public static String SOURCE_GOODS_PARTNER = "partner";
	
	//创建套餐订单：手机端
	public static String SOURCE_GOODS_MOBILE = "mobile";
	
	//CardDelay
	public static String SOURCE_GOODS_CARDDELAY = "CardDelay";
	
	//preSales
	public static String SOURCE_GOODS_PRESALES = "preSales";
	
	//activity
	public static String SOURCE_GOODS_ACTIVITY = "activity";	
	
	
	private static final long serialVersionUID = -6058984623011729279L;
	private GoodsVo goods;
	private String mobile;
	private Integer quantity;
	private Long placeid;		//设置场馆ID
	private Long itemid;				//设置项目ID
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
	public CreateGoodsOrderReq(){
		
	}
	public CreateGoodsOrderReq(String contextKey, String asyncQueueKey, String remoteIp, GoodsVo goods,
			Long memberid, String mobile, Integer quantity, String category, String pricategory){
		super(TAG_GOODS, contextKey, asyncQueueKey, remoteIp, memberid, goods.getId());
		this.goods = goods;
		this.quantity = quantity;
		this.mobile = mobile;
		this.category = category;
		this.pricategory = pricategory;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getPlaceid() {
		return placeid;
	}
	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPricategory() {
		return pricategory;
	}
	public void setPricategory(String pricategory) {
		this.pricategory = pricategory;
	}
	public String getUkey() {
		return ukey;
	}
	public void setUkey(String ukey) {
		this.ukey = ukey;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Timestamp getValidtime() {
		return validtime;
	}
	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Map<String, String> getDescMap() {
		return descMap;
	}
	public void setDescMap(Map<String, String> descMap) {
		this.descMap = descMap;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getOrdertitle() {
		return ordertitle;
	}
	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public Long getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}
	public GoodsVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
	
}
