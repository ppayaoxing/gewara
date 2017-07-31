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
	private Long describeid; 			// 物品ID
	private String itemtype; 			// 项目分类(movie,drama)
	private Long itemid; 				// 项目ID
	private String goodstype; 			// 物品类型
	private String tag; 					// 场馆类型（cinema,theatre)
	private Long relatedid; 			// 场馆ID
	private String goodsname; 			// 商品名称
	private String highlight;			//推荐说明

	private Integer oriprice; 			// 原价
	private Integer unitprice; 		// 单价
	private Integer costprice; 		// 成本价

	private Integer maxprice; 			// 最大价格
	private Integer minprice; 			// 最小价格

	private Integer limitnum; 			// 支付限购数量
	private Integer allowaddnum; 		// 下单数量限制，防止因同事下单人数过多，而导致库存不足

	private Integer quantity; 			// 原始的库存数量，不随订单的增加而减少
	private Integer maxbuy; 			// 每次最多购买的数量
	private Integer sales; 				// 卖出数量

	private Integer minpoint; 			// 使用积分下限
	private Integer maxpoint; 			// 使用积分上限

	private Integer goodssort; 		// 商品排序
	private String deliver; 			// 是否需要地址//N,Y
	private String spflag;				// 特价活动标识

	private String partners; 			// 该物品适用于合作商，如我们的android，ihphone，wap

	private Long clerkid; 				// 加入人
	private String manager; 			// 创建人类别

	private String shortname; 			// 商品简称[打票使用]
	private String printcontent; 		// 票纸打印内容
	private String ordermsg; 			// 订单短信
	private String notifymsg; 			// 3小时提醒短息

	private String status; 				// 状态
	private String otherinfo; 			// 其他设置 json格式， 存放支付配置信息等
	private String citycode; 			// 城市代码
	private String summary; 			// 描述摘要
	private String description; 		// 商品描述
	private String logo; 				// 图片
	private String biglogo; 			// 大图
	private String banklogo; 			// 银行logo

	private Timestamp releasetime;	// 展示时间
	private Timestamp fromtime;		// 开卖时间
	private Timestamp totime;			// 结束时间
	private Timestamp addtime; 		// 加入时间
	private Timestamp fromvalidtime; // 通票入场时间
	private Timestamp tovalidtime;	// 通票入场结束时间

	private String elecard;
	private String expressid;			// 配送方式id
	private String period;				// 是否有时段
	private Integer msgMinute;			// 短信提前发送时间(分钟)

	private String barcode; 			// 条形码
	private String feetype; 			// 业务模式
	private String servicetype; 		// 服务板块
	private String seotitle; 			// SEO关键字
	private String seodescription; 	// SEO描述
	private Integer clickedtimes;
	private String preType; 			// 预售类型
	private String category; 			// 衍生品分类
	private String smalltype; 			// 分类:如：爆米花，预售，衍生品,活动
	private Long smallid; 				// 预售（券批次），活动（ID）

	private Long settleid; 				// 结算ID
	private String measurement; 		// 分类，如，物品尺寸
	private String colour; 				// 分类，如，颜色
	private String takemethod;			// 取票方式
	
	private String rateinfo;			// 强制绑定的比例
	
	private Long spcounterid;			//使用数量控制器的ID
	private String sellOutMark;			//是否缺货登记

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
		if (StringUtils.isBlank(logo))
			return "img/default_head.png";
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
		if (StringUtils.isBlank(logo))
			return "img/default_head.png";
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
		if (StringUtils.isBlank(this.period))
			return false;
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
	 * 在预售期
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
