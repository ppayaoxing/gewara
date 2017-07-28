/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.goods;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class GoodsVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;
	private Long id;
	private Long describeid;
	private String itemtype;
	private Long itemid;
	private String goodstype;
	private String tag;
	private Long relatedid;
	private String goodsname;
	private String highlight;
	private Integer oriprice;
	private Integer unitprice;
	private Integer costprice;
	private Integer maxprice;
	private Integer minprice;
	private Integer limitnum;
	private Integer allowaddnum;
	private Integer quantity;
	private Integer maxbuy;
	private Integer sales;
	private Integer minpoint;
	private Integer maxpoint;
	private Integer goodssort;
	private String deliver;
	private String spflag;
	private String partners;
	private Long clerkid;
	private String manager;
	private String shortname;
	private String printcontent;
	private String ordermsg;
	private String notifymsg;
	private String status;
	private String otherinfo;
	private String citycode;
	private String summary;
	private String description;
	private String logo;
	private String biglogo;
	private String banklogo;
	private Timestamp releasetime;
	private Timestamp fromtime;
	private Timestamp totime;
	private Timestamp addtime;
	private Timestamp fromvalidtime;
	private Timestamp tovalidtime;
	private String elecard;
	private String expressid;
	private String period;
	private Integer msgMinute;
	private String barcode;
	private String feetype;
	private String servicetype;
	private String seotitle;
	private String seodescription;
	private Integer clickedtimes;
	private String preType;
	private String category;
	private String smalltype;
	private Long smallid;
	private Long settleid;
	private String measurement;
	private String colour;
	private String takemethod;
	private String rateinfo;
	private Long spcounterid;
	private String sellOutMark;

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getExpressid() {
		return this.expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public final Serializable realId() {
		return this.id;
	}

	public Timestamp getFromvalidtime() {
		return this.fromvalidtime;
	}

	public void setFromvalidtime(Timestamp fromvalidtime) {
		this.fromvalidtime = fromvalidtime;
	}

	public Timestamp getTovalidtime() {
		return this.tovalidtime;
	}

	public void setTovalidtime(Timestamp tovalidtime) {
		this.tovalidtime = tovalidtime;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPrintcontent() {
		return this.printcontent;
	}

	public void setPrintcontent(String printcontent) {
		this.printcontent = printcontent;
	}

	public Integer getOriprice() {
		return this.oriprice;
	}

	public void setOriprice(Integer oriprice) {
		this.oriprice = oriprice;
	}

	public String getBiglogo() {
		return this.biglogo;
	}

	public void setBiglogo(String biglogo) {
		this.biglogo = biglogo;
	}

	public String getOrdermsg() {
		return this.ordermsg;
	}

	public Timestamp getReleasetime() {
		return this.releasetime;
	}

	public void setReleasetime(Timestamp releasetime) {
		this.releasetime = releasetime;
	}

	public void setOrdermsg(String ordermsg) {
		this.ordermsg = ordermsg;
	}

	public String getNotifymsg() {
		return this.notifymsg;
	}

	public void setNotifymsg(String notifymsg) {
		this.notifymsg = notifymsg;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Long getClerkid() {
		return this.clerkid;
	}

	public void setClerkid(Long clerkid) {
		this.clerkid = clerkid;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getLogo() {
		return this.logo;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_head.png" : this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(Integer minpoint) {
		this.minpoint = minpoint;
	}

	public Integer getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(Integer maxpoint) {
		this.maxpoint = maxpoint;
	}

	public Timestamp getFromtime() {
		return this.fromtime;
	}

	public void setFromtime(Timestamp fromtime) {
		this.fromtime = fromtime;
	}

	public Timestamp getTotime() {
		return this.totime;
	}

	public void setTotime(Timestamp totime) {
		this.totime = totime;
	}

	public Integer getGoodssort() {
		return this.goodssort;
	}

	public void setGoodssort(Integer goodssort) {
		this.goodssort = goodssort;
	}

	public Integer getLimitnum() {
		return this.limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public boolean isStart() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.before(this.fromtime);
	}

	public boolean isEnd() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.after(this.totime);
	}

	public boolean isNeedDeliver() {
		return "entity".equals(this.deliver);
	}

	public Integer getRealpoint() {
		return Integer.valueOf(this.unitprice.intValue() * 100);
	}

	public String getReallogo() {
		return StringUtils.isBlank(this.logo) ? "img/default_head.png" : this.logo;
	}

	public String getDeliver() {
		return this.deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public boolean isPointType() {
		return "point".equals(this.tag);
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getSpflag() {
		return this.spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public String getTipMsg() {
		String result = "";
		if (StringUtils.isNotBlank(this.ordermsg)) {
			result = this.ordermsg.replaceAll("quantity", "X").replaceAll("password", "******");
		}

		return result;
	}

	public List getSummaryList() {
		return StringUtils.isNotBlank(this.summary) ? Arrays.asList(StringUtils.split(this.summary, ",")) : null;
	}

	public boolean isOpenPointPay() {
		return this.maxpoint != null && this.maxpoint.intValue() > 0;
	}

	public boolean isOpenCardPay() {
		return StringUtils.containsAny(this.elecard, "ABD");
	}

	public String getElecard() {
		return this.elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public Integer getAllowaddnum() {
		return this.allowaddnum;
	}

	public void setAllowaddnum(Integer allowaddnum) {
		this.allowaddnum = allowaddnum;
	}

	public Integer getMaxbuy() {
		return this.maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public String getPartners() {
		return this.partners;
	}

	public void setPartners(String partners) {
		this.partners = partners;
	}

	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public boolean hasStatus(String stats) {
		return StringUtils.equals(this.status, stats);
	}

	public boolean hasExpired() {
		return this.tovalidtime.before(DateUtil.getCurFullTimestamp());
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public boolean hasPeriod() {
		return StringUtils.isBlank(this.period) ? false : StringUtils.equals(this.period, "Y");
	}

	public Integer getMsgMinute() {
		return this.msgMinute;
	}

	public void setMsgMinute(Integer msgMinute) {
		this.msgMinute = msgMinute;
	}

	public boolean isOpenBarcode() {
		return StringUtils.equals(this.barcode, "Y");
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String gainBriefname() {
		return StringUtils.isNotBlank(this.shortname) ? this.shortname : this.goodsname;
	}

	public String getSeotitle() {
		return this.seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getSeodescription() {
		return this.seodescription;
	}

	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}

	public Integer getMaxprice() {
		return this.maxprice;
	}

	public void setMaxprice(Integer maxprice) {
		this.maxprice = maxprice;
	}

	public Integer getMinprice() {
		return this.minprice;
	}

	public void setMinprice(Integer minprice) {
		this.minprice = minprice;
	}

	public String getFeetype() {
		return this.feetype;
	}

	public String getGoodstype() {
		return this.goodstype;
	}

	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	public String getName() {
		return this.goodsname;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public String getServicetype() {
		return this.servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public Long getDescribeid() {
		return this.describeid;
	}

	public void setDescribeid(Long describeid) {
		this.describeid = describeid;
	}

	public String getSmalltype() {
		return this.smalltype;
	}

	public void setSmalltype(String smalltype) {
		this.smalltype = smalltype;
	}

	public Long getSmallid() {
		return this.smallid;
	}

	public void setSmallid(Long smallid) {
		this.smallid = smallid;
	}

	public Long getSettleid() {
		return this.settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getMeasurement() {
		return this.measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public boolean hasBooking() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.after(this.fromtime) && cur.before(this.totime) && StringUtils.equals(this.status, "Y");
	}

	public String getPreType() {
		return this.preType;
	}

	public void setPreType(String preType) {
		this.preType = preType;
	}

	public String getBanklogo() {
		return this.banklogo;
	}

	public void setBanklogo(String banklogo) {
		this.banklogo = banklogo;
	}

	public String getRateinfo() {
		return this.rateinfo;
	}

	public void setRateinfo(String rateinfo) {
		this.rateinfo = rateinfo;
	}

	public String getHighlight() {
		return this.highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public Long getSpcounterid() {
		return this.spcounterid;
	}

	public void setSpcounterid(Long spcounterid) {
		this.spcounterid = spcounterid;
	}

	public String getSellOutMark() {
		return this.sellOutMark;
	}

	public void setSellOutMark(String sellOutMark) {
		this.sellOutMark = sellOutMark;
	}
}