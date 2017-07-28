/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.JsonUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class ProductVo extends BaseVo {
	private static final long serialVersionUID = 3124980986021558566L;
	private Long id;
	private Integer version;
	private String name;
	private String fullName;
	private String logo;
	private String introduction;
	private String productCode;
	private String note;
	private String source;
	private Long categoryId;
	private String categoryPath;
	private Long attributeId1;
	private Long attributeId2;
	private Integer skuCount;
	private Integer stock;
	private Integer sold;
	private Integer price;
	private Long brandId;
	private String status;
	private String parameter;
	private String people;
	private String crowd;
	private String tag;
	private Long relatedId;
	private String otherInfo;
	private String keywords;
	private String sevenDayRefund;
	private String packageList;
	private String afterSaleService;
	private Long shippingTemplateId;
	private Long vendorId;
	private Long shipperId;
	private String elecard;
	private Long boughtMovieId;
	private Integer limitBuyQty;
	private String saleModel;
	private Timestamp onSaleTime;
	private Timestamp offSaleTime;
	private String sellType;
	private Integer point;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryPath() {
		return this.categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public Long getAttributeId1() {
		return this.attributeId1;
	}

	public void setAttributeId1(Long attributeId1) {
		this.attributeId1 = attributeId1;
	}

	public Long getAttributeId2() {
		return this.attributeId2;
	}

	public void setAttributeId2(Long attributeId2) {
		this.attributeId2 = attributeId2;
	}

	public Integer getSkuCount() {
		return this.skuCount;
	}

	public void setSkuCount(Integer skuCount) {
		this.skuCount = skuCount;
	}

	public Long getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedId() {
		return this.relatedId;
	}

	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSevenDayRefund() {
		return this.sevenDayRefund;
	}

	public void setSevenDayRefund(String sevenDayRefund) {
		this.sevenDayRefund = sevenDayRefund;
	}

	public String getPackageList() {
		return this.packageList;
	}

	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}

	public String getAfterSaleService() {
		return this.afterSaleService;
	}

	public void setAfterSaleService(String afterSaleService) {
		this.afterSaleService = afterSaleService;
	}

	public Map<String, String> gainParameter() {
		return JsonUtils.readJsonToMap(this.parameter);
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getShippingTemplateId() {
		return this.shippingTemplateId;
	}

	public void setShippingTemplateId(Long shippingTemplateId) {
		this.shippingTemplateId = shippingTemplateId;
	}

	public Long getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getElecard() {
		return this.elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public Long getBoughtMovieId() {
		return this.boughtMovieId;
	}

	public void setBoughtMovieId(Long boughtMovieId) {
		this.boughtMovieId = boughtMovieId;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSold() {
		return this.sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPeople() {
		return this.people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getCrowd() {
		return this.crowd;
	}

	public void setCrowd(String crowd) {
		this.crowd = crowd;
	}

	public Integer getLimitBuyQty() {
		return this.limitBuyQty;
	}

	public void setLimitBuyQty(Integer limitBuyQty) {
		this.limitBuyQty = limitBuyQty;
	}

	public void addSold(int qty) {
		this.sold = Integer.valueOf(this.sold.intValue() + qty);
	}

	public void addStock(int qty) {
		this.stock = Integer.valueOf(this.stock.intValue() + qty);
	}

	public Long getShipperId() {
		return this.shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public String getSaleModel() {
		return this.saleModel;
	}

	public void setSaleModel(String saleModel) {
		this.saleModel = saleModel;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getOnSaleTime() {
		return this.onSaleTime;
	}

	public void setOnSaleTime(Timestamp onSaleTime) {
		this.onSaleTime = onSaleTime;
	}

	public Timestamp getOffSaleTime() {
		return this.offSaleTime;
	}

	public void setOffSaleTime(Timestamp offSaleTime) {
		this.offSaleTime = offSaleTime;
	}

	public String getSellType() {
		return this.sellType;
	}

	public void setSellType(String sellType) {
		this.sellType = sellType;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Serializable realId() {
		return this.id;
	}

	public boolean canUseCard() {
		return StringUtils.contains(this.elecard, "D");
	}
}