package com.gewara.api.vo.goods;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.GoodsConstant;
import com.gewara.cons.Status;
import com.gewara.util.DateUtil;

public class GoodsVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;

	private Long id; 						// ID
	private Long describeid; 			// 锟斤拷品ID
	private String itemtype; 			// 锟斤拷目锟斤拷锟斤拷(movie,drama)
	private Long itemid; 				// 锟斤拷目ID
	private String goodstype; 			// 锟斤拷品锟斤拷锟斤拷
	private String tag; 					// 锟斤拷锟斤拷锟斤拷锟酵ｏ拷cinema,theatre)
	private Long relatedid; 			// 锟斤拷锟斤拷ID
	private String goodsname; 			// 锟斤拷品锟斤拷锟斤拷
	private String highlight;			//锟狡硷拷说锟斤拷

	private Integer oriprice; 			// 原锟斤拷
	private Integer unitprice; 		// 锟斤拷锟斤拷
	private Integer costprice; 		// 锟缴憋拷锟斤拷

	private Integer maxprice; 			// 锟斤拷锟桔革拷
	private Integer minprice; 			// 锟斤拷小锟桔革拷

	private Integer limitnum; 			// 支锟斤拷锟睫癸拷锟斤拷锟斤拷
	private Integer allowaddnum; 		// 锟铰碉拷锟斤拷锟斤拷锟斤拷锟狡ｏ拷锟斤拷止锟斤拷同锟斤拷锟铰碉拷锟斤拷锟斤拷锟斤拷锟洁，锟斤拷锟斤拷锟铰匡拷娌伙拷锟�

	private Integer quantity; 			// 原始锟侥匡拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷娑╋拷锟斤拷锟斤拷锟斤拷佣锟斤拷锟斤拷锟�
	private Integer maxbuy; 			// 每锟斤拷锟斤拷喙猴拷锟斤拷锟斤拷锟斤拷
	private Integer sales; 				// 锟斤拷锟斤拷锟斤拷锟斤拷

	private Integer minpoint; 			// 使锟矫伙拷锟斤拷锟斤拷锟斤拷
	private Integer maxpoint; 			// 使锟矫伙拷锟斤拷锟斤拷锟斤拷

	private Integer goodssort; 		// 锟斤拷品锟斤拷锟斤拷
	private String deliver; 			// 锟角凤拷锟斤拷要锟斤拷址//N,Y
	private String spflag;				// 锟截价活动锟斤拷识

	private String partners; 			// 锟斤拷锟斤拷品锟斤拷锟斤拷锟节猴拷锟斤拷锟教ｏ拷锟斤拷锟斤拷锟角碉拷android锟斤拷ihphone锟斤拷wap

	private Long clerkid; 				// 锟斤拷锟斤拷锟斤拷
	private String manager; 			// 锟斤拷锟斤拷锟斤拷锟斤拷锟�

	private String shortname; 			// 锟斤拷品锟斤拷锟絒锟斤拷票使锟斤拷]
	private String printcontent; 		// 票纸锟斤拷印锟斤拷锟斤拷
	private String ordermsg; 			// 锟斤拷锟斤拷锟斤拷锟斤拷
	private String notifymsg; 			// 3小时锟斤拷锟窖讹拷息

	private String status; 				// 状态
	private String otherinfo; 			// 锟斤拷锟斤拷锟斤拷锟斤拷 json锟斤拷式锟斤拷 锟斤拷锟街э拷锟斤拷锟斤拷锟斤拷锟较拷锟�
	private String citycode; 			// 锟斤拷锟叫达拷锟斤拷
	private String summary; 			// 锟斤拷锟斤拷摘要
	private String description; 		// 锟斤拷品锟斤拷锟斤拷
	private String logo; 				// 图片
	private String biglogo; 			// 锟斤拷图
	private String banklogo; 			// 锟斤拷锟斤拷logo

	private Timestamp releasetime;	// 展示时锟斤拷
	private Timestamp fromtime;		// 锟斤拷锟斤拷时锟斤拷
	private Timestamp totime;			// 锟斤拷锟斤拷时锟斤拷
	private Timestamp addtime; 		// 锟斤拷锟斤拷时锟斤拷
	private Timestamp fromvalidtime; // 通票锟诫场时锟斤拷
	private Timestamp tovalidtime;	// 通票锟诫场锟斤拷锟斤拷时锟斤拷

	private String elecard;
	private String expressid;			// 锟斤拷锟酵凤拷式id
	private String period;				// 锟角凤拷锟斤拷时锟斤拷
	private Integer msgMinute;			// 锟斤拷锟斤拷锟斤拷前锟斤拷锟斤拷时锟斤拷(锟斤拷锟斤拷)

	private String barcode; 			// 锟斤拷锟斤拷锟斤拷
	private String feetype; 			// 业锟斤拷模式
	private String servicetype; 		// 锟斤拷锟斤拷锟斤拷
	private String seotitle; 			// SEO锟截硷拷锟斤拷
	private String seodescription; 	// SEO锟斤拷锟斤拷
	private Integer clickedtimes;
	private String preType; 			// 预锟斤拷锟斤拷锟斤拷
	private String category; 			// 锟斤拷锟斤拷品锟斤拷锟斤拷
	private String smalltype; 			// 锟斤拷锟斤拷:锟界：锟斤拷锟阶伙拷锟斤拷预锟桔ｏ拷锟斤拷锟斤拷品,锟筋动
	private Long smallid; 				// 预锟桔ｏ拷券锟斤拷锟轿ｏ拷锟斤拷锟筋动锟斤拷ID锟斤拷

	private Long settleid; 				// 锟斤拷锟斤拷ID
	private String measurement; 		// 锟斤拷锟洁，锟界，锟斤拷品锟竭达拷
	private String colour; 				// 锟斤拷锟洁，锟界，锟斤拷色
	private String takemethod;			// 取票锟斤拷式
	
	private String rateinfo;			// 强锟狡绑定的憋拷锟斤拷
	
	private Long spcounterid;			//使锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷ID
	private String sellOutMark;			//锟角凤拷缺锟斤拷锟角硷拷

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getExpressid() {
		return expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	@Override
	public final Serializable realId() {
		return id;
	}

	public Timestamp getFromvalidtime() {
		return fromvalidtime;
	}

	public void setFromvalidtime(Timestamp fromvalidtime) {
		this.fromvalidtime = fromvalidtime;
	}

	public Timestamp getTovalidtime() {
		return tovalidtime;
	}

	public void setTovalidtime(Timestamp tovalidtime) {
		this.tovalidtime = tovalidtime;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPrintcontent() {
		return printcontent;
	}

	public void setPrintcontent(String printcontent) {
		this.printcontent = printcontent;
	}

	public Integer getOriprice() {
		return oriprice;
	}

	public void setOriprice(Integer oriprice) {
		this.oriprice = oriprice;
	}

	public String getBiglogo() {
		return biglogo;
	}

	public void setBiglogo(String biglogo) {
		this.biglogo = biglogo;
	}

	public String getOrdermsg() {
		return ordermsg;
	}

	public Timestamp getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(Timestamp releasetime) {
		this.releasetime = releasetime;
	}

	public void setOrdermsg(String ordermsg) {
		this.ordermsg = ordermsg;
	}

	public String getNotifymsg() {
		return notifymsg;
	}

	public void setNotifymsg(String notifymsg) {
		this.notifymsg = notifymsg;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Long getClerkid() {
		return clerkid;
	}

	public void setClerkid(Long clerkid) {
		this.clerkid = clerkid;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getLogo() {
		return logo;
	}

	public String getLimg() {
		if (StringUtils.isBlank(logo)) {
            return "img/default_head.png";
        }
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getMinpoint() {
		return minpoint;
	}

	public void setMinpoint(Integer minpoint) {
		this.minpoint = minpoint;
	}

	public Integer getMaxpoint() {
		return maxpoint;
	}

	public void setMaxpoint(Integer maxpoint) {
		this.maxpoint = maxpoint;
	}

	public Timestamp getFromtime() {
		return fromtime;
	}

	public void setFromtime(Timestamp fromtime) {
		this.fromtime = fromtime;
	}

	public Timestamp getTotime() {
		return totime;
	}

	public void setTotime(Timestamp totime) {
		this.totime = totime;
	}

	public Integer getGoodssort() {
		return goodssort;
	}

	public void setGoodssort(Integer goodssort) {
		this.goodssort = goodssort;
	}

	public Integer getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public boolean isStart() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.before(fromtime);
	}

	public boolean isEnd() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.after(totime);
	}

	public boolean isNeedDeliver() {
		return GoodsConstant.DELIVER_ENTITY.equals(deliver);
	}

	public Integer getRealpoint() {
		return this.unitprice * 100;
	}

	public String getReallogo() {
		if (StringUtils.isBlank(logo)) {
            return "img/default_head.png";
        }
		return logo;
	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public boolean isPointType() {
		return GoodsConstant.GOODS_TAG_POINT.equals(tag);
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getSpflag() {
		return spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public String getTipMsg() {
		String result = "";
		if (StringUtils.isNotBlank(ordermsg)) {
			result = ordermsg.replaceAll("quantity", "X").replaceAll("password", "******");
		}
		return result;
	}

	public List getSummaryList() {
		if (StringUtils.isNotBlank(this.summary)) {
			return Arrays.asList(StringUtils.split(this.summary, ","));
		}
		return null;
	}

	public boolean isOpenPointPay() {
		return maxpoint != null && maxpoint > 0;
	}

	public boolean isOpenCardPay() {
		return StringUtils.containsAny(elecard, "ABD");
	}

	public String getElecard() {
		return elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public Integer getAllowaddnum() {
		return allowaddnum;
	}

	public void setAllowaddnum(Integer allowaddnum) {
		this.allowaddnum = allowaddnum;
	}

	public Integer getMaxbuy() {
		return maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public String getPartners() {
		return partners;
	}

	public void setPartners(String partners) {
		this.partners = partners;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public boolean hasStatus(String stats) {
		return StringUtils.equals(this.status, stats);
	}

	public boolean hasExpired() {
		return tovalidtime.before(DateUtil.getCurFullTimestamp());
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public boolean hasPeriod() {
		if (StringUtils.isBlank(this.period)) {
            return false;
        }
		return StringUtils.equals(this.period, GoodsConstant.PERIOD_Y);
	}

	public Integer getMsgMinute() {
		return msgMinute;
	}

	public void setMsgMinute(Integer msgMinute) {
		this.msgMinute = msgMinute;
	}

	public boolean isOpenBarcode() {
		return StringUtils.equals(barcode, Status.Y);
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String gainBriefname() {
		return StringUtils.isNotBlank(this.shortname) ? this.shortname : this.goodsname;
	}

	public String getSeotitle() {
		return seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getSeodescription() {
		return seodescription;
	}

	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}

	public Integer getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(Integer maxprice) {
		this.maxprice = maxprice;
	}

	public Integer getMinprice() {
		return minprice;
	}

	public void setMinprice(Integer minprice) {
		this.minprice = minprice;
	}

	public String getFeetype() {
		return feetype;
	}

	public String getGoodstype() {
		return goodstype;
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
		return clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public Long getDescribeid() {
		return describeid;
	}

	public void setDescribeid(Long describeid) {
		this.describeid = describeid;
	}

	public String getSmalltype() {
		return smalltype;
	}

	public void setSmalltype(String smalltype) {
		this.smalltype = smalltype;
	}

	public Long getSmallid() {
		return smallid;
	}

	public void setSmallid(Long smallid) {
		this.smallid = smallid;
	}

	public Long getSettleid() {
		return settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getTakemethod() {
		return takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	/**
	 * 锟斤拷预锟斤拷锟斤拷
	 */
	public boolean hasBooking() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return cur.after(fromtime) && cur.before(totime) && StringUtils.equals(this.status, Status.Y);
	}

	public String getPreType() {
		return preType;
	}

	public void setPreType(String preType) {
		this.preType = preType;
	}

	public String getBanklogo() {
		return banklogo;
	}

	public void setBanklogo(String banklogo) {
		this.banklogo = banklogo;
	}

	public String getRateinfo() {
		return rateinfo;
	}

	public void setRateinfo(String rateinfo) {
		this.rateinfo = rateinfo;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	
	public Long getSpcounterid() {
		return spcounterid;
	}

	public void setSpcounterid(Long spcounterid) {
		this.spcounterid = spcounterid;
	}

	public String getSellOutMark() {
		return sellOutMark;
	}

	public void setSellOutMark(String sellOutMark) {
		this.sellOutMark = sellOutMark;
	}
	
}
