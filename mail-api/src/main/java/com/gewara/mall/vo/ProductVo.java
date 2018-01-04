package com.gewara.mall.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.JsonUtils;

public class ProductVo extends BaseVo {
	private static final long serialVersionUID = 3124980986021558566L;
	private Long id;
	private Integer version;					//更新版本
	private String name;						//名称
	private String fullName;					//全称
	private String logo;						//图片
	private String introduction;				//介绍
	private String productCode;				//商品货号
	private String note;						//注意事项
	private String source;					//作品来源
	private Long categoryId;					//商品分类
	private String categoryPath;				//分类路径
	private Long attributeId1;				//售卖属性1
	private Long attributeId2;				//售卖属性2
	private Integer skuCount;					//sku个数
	private Integer stock;					//库存
	private Integer sold;						//已销售
	private Integer price;					//价格
	private Long brandId;						//品牌
	private String status;					//状态
	private String parameter;					//商品参数 json格式数据：{"板型":"修身","袖长","短袖"}
	
	private String people;					//人物   钢铁侠、绿巨人
	private String crowd;						//人群   同事、闺蜜、对象
	
	//关联现有格瓦拉数据
	private String tag;						//movie,drama
	private Long relatedId;					//电影id,演出id
	private String otherInfo;					//其他信息
	private String keywords;					//关键字
	
	private String sevenDayRefund;			//7天退货
	private String packageList;				//包装清单
	private String afterSaleService;			//售后服务
	private Long shippingTemplateId;			//运费模板ID
	private Long vendorId;					//供应商id
	private Long shipperId;					//发货商ID
	private String elecard;					//1)可用的抵用券类型D，2) M表示参与商家特殊优惠活动
	private Long boughtMovieId;				//购买过某个电影的，才可以购买
	private Integer limitBuyQty;				//最大可购买数量
	
	private String saleModel;					//销售模式
	private Timestamp onSaleTime;				//定时上架时间
	private Timestamp offSaleTime;			//定时下架时间
	private String sellType;				//现金、现金+积分、积分
	private Integer point;					//积分
	
	public ProductVo(){}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryPath() {
		return categoryPath;
	}
	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}
	public Long getAttributeId1() {
		return attributeId1;
	}
	public void setAttributeId1(Long attributeId1) {
		this.attributeId1 = attributeId1;
	}
	public Long getAttributeId2() {
		return attributeId2;
	}
	public void setAttributeId2(Long attributeId2) {
		this.attributeId2 = attributeId2;
	}
	public Integer getSkuCount() {
		return skuCount;
	}
	public void setSkuCount(Integer skuCount) {
		this.skuCount = skuCount;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedId() {
		return relatedId;
	}
	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSevenDayRefund() {
		return sevenDayRefund;
	}
	public void setSevenDayRefund(String sevenDayRefund) {
		this.sevenDayRefund = sevenDayRefund;
	}
	public String getPackageList() {
		return packageList;
	}
	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}
	public String getAfterSaleService() {
		return afterSaleService;
	}
	public void setAfterSaleService(String afterSaleService) {
		this.afterSaleService = afterSaleService;
	}
	//--------------------------------------
	public Map<String, String> gainParameter(){
		return JsonUtils.readJsonToMap(parameter);
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Long getShippingTemplateId() {
		return shippingTemplateId;
	}
	public void setShippingTemplateId(Long shippingTemplateId) {
		this.shippingTemplateId = shippingTemplateId;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getElecard() {
		return elecard;
	}
	public void setElecard(String elecard) {
		this.elecard = elecard;
	}
	public Long getBoughtMovieId() {
		return boughtMovieId;
	}
	public void setBoughtMovieId(Long boughtMovieId) {
		this.boughtMovieId = boughtMovieId;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getCrowd() {
		return crowd;
	}
	public void setCrowd(String crowd) {
		this.crowd = crowd;
	}
	public Integer getLimitBuyQty() {
		return limitBuyQty;
	}
	public void setLimitBuyQty(Integer limitBuyQty) {
		this.limitBuyQty = limitBuyQty;
	}
	public void addSold(int qty){
		this.sold = this.sold + qty;
	}
	public void addStock(int qty){
		this.stock = this.stock + qty;
	}
	public Long getShipperId() {
		return shipperId;
	}
	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}
	public String getSaleModel() {
		return saleModel;
	}
	public void setSaleModel(String saleModel) {
		this.saleModel = saleModel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getOnSaleTime() {
		return onSaleTime;
	}
	public void setOnSaleTime(Timestamp onSaleTime) {
		this.onSaleTime = onSaleTime;
	}
	public Timestamp getOffSaleTime() {
		return offSaleTime;
	}
	public void setOffSaleTime(Timestamp offSaleTime) {
		this.offSaleTime = offSaleTime;
	}
	public String getSellType() {
		return sellType;
	}
	public void setSellType(String sellType) {
		this.sellType = sellType;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public boolean canUseCard(){
		return StringUtils.contains(this.elecard, "D");
	}
}
