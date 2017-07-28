/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.model.BaseObject;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import com.gewara.util.VmBaseUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class PromotionVo extends BaseVo {
	private static final long serialVersionUID = 4201413246406397258L;
	private Long id;
	private String extraInfo;
	private String flag;
	private String tag;
	private Integer sortnum;
	private String opentype;
	private String ptnids;
	private Integer discount;
	private String distype;
	private String refundEnable;
	private String spType;
	private String expression;
	private String specialrule;
	private Integer limitperiod;
	private Integer limitnum;
	private Integer minbuy;
	private Integer buynum;
	private String periodtype;
	private String uniqueby;
	private String description;
	private Timestamp timefrom;
	private Timestamp timeto;
	private Timestamp orderTimeFrom;
	private Timestamp orderTimeTo;
	private String addtime1;
	private String addtime2;
	private String addweek;
	private String remark;
	private String enableRemark;
	private String adcontent;
	private String recommendRemark;
	private String configMessage;
	private String banner;
	private String loginfrom;
	private String citycode;
	private Integer fullTotalfee;
	private String otherinfo;
	private String paymethod;
	private String logo;
	private String cardbinUkey;
	private String validateUrl;
	private String validBackUrl;
	private String cardUkey;
	private String cardNumUnique;
	private Integer cardNumPeriodIntvel;
	private Integer cardNumPeriodSpan;
	private Integer cardNumLimitnum;
	private String bankname;
	private Integer extdiscount;
	private String channel;
	private String bindmobile;
	private String costtype;
	private Integer costnum;
	private String verifyType;
	private String showCoupon;
	private String excludeSpid;
	private Integer rebates;
	private Integer rebatesmax;
	private String rebatestype;
	private Long drawactivity;
	private Integer drawperiod;
	private Integer bindDrawCardNum;
	private Long bindgoods;
	private Integer bindnum;
	private Integer ipLimitedOrderCount;
	private Long spcounterid;
	private Timestamp playTimeFrom;
	private Timestamp playTimeTo;
	private String excludeOpiFlg;
	private String time1;
	private String time2;
	private String weektype;
	private String relatedid;
	private String relatedidEnable;
	private String categoryid;
	private String categoryidEnable;
	private String itemid;
	private String itemidEnable;
	private String roomId;
	private String roomIdEnable;
	private String goodsid;
	private String seatType;
	private String edition;
	private Integer price1;
	private Integer price2;
	private Integer pricegap;
	private Integer costprice1;
	private Integer costprice2;
	private String fieldid;
	private Integer daynum;
	private BaseObject relate;
	private Timestamp createtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public Integer getBindDrawCardNum() {
		return this.bindDrawCardNum;
	}

	public void setBindDrawCardNum(Integer bindDrawCardNum) {
		this.bindDrawCardNum = bindDrawCardNum;
	}

	public Long getDrawactivity() {
		return this.drawactivity;
	}

	public void setDrawactivity(Long drawactivity) {
		this.drawactivity = drawactivity;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Timestamp getTimefrom() {
		return this.timefrom;
	}

	public void setTimefrom(Timestamp timefrom) {
		this.timefrom = timefrom;
	}

	public Timestamp getTimeto() {
		return this.timeto;
	}

	public void setTimeto(Timestamp timeto) {
		this.timeto = timeto;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public boolean isValidPaymethod(String spaymethod, String paybank) {
		if (StringUtils.isBlank(this.paymethod)) {
			return true;
		} else {
			String[] pmList = StringUtils.split(this.paymethod, ",");
			String[] arg3 = pmList;
			int arg4 = pmList.length;

			for (int arg5 = 0; arg5 < arg4; ++arg5) {
				String pm = arg3[arg5];
				if (StringUtils.equals(pm, spaymethod)) {
					return true;
				}

				String[] pair = StringUtils.split(pm, ":");
				if (StringUtils.equals(pair[0], spaymethod)
						&& (pair.length == 1 || pair.length > 1 && StringUtils.equals(pair[1], paybank))) {
					return true;
				}
			}

			return false;
		}
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getExtdiscount() {
		return this.extdiscount;
	}

	public void setExtdiscount(Integer extdiscount) {
		this.extdiscount = extdiscount;
	}

	public String getDistype() {
		return this.distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getLimitnum() {
		return this.limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public Integer getLimitperiod() {
		return this.limitperiod;
	}

	public void setLimitperiod(Integer limitperiod) {
		this.limitperiod = limitperiod;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getTime1() {
		return this.time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return this.time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public Integer getPricegap() {
		return this.pricegap;
	}

	public void setPricegap(Integer pricegap) {
		this.pricegap = pricegap;
	}

	public Integer getPrice1() {
		return this.price1;
	}

	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}

	public Integer getPrice2() {
		return this.price2;
	}

	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}

	public String getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getSeatType() {
		return this.seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getWeektype() {
		return this.weektype;
	}

	public void setWeektype(String weektype) {
		this.weektype = weektype;
	}

	public String getAddtime1() {
		return this.addtime1;
	}

	public void setAddtime1(String addtime1) {
		this.addtime1 = addtime1;
	}

	public String getAddtime2() {
		return this.addtime2;
	}

	public void setAddtime2(String addtime2) {
		this.addtime2 = addtime2;
	}

	public String getAddweek() {
		return this.addweek;
	}

	public void setAddweek(String addweek) {
		this.addweek = addweek;
	}

	public String getBanner() {
		return this.banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getAdcontent() {
		return this.adcontent;
	}

	public void setAdcontent(String adcontent) {
		this.adcontent = adcontent;
	}

	public Integer getBuynum() {
		return this.buynum;
	}

	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}

	public Integer getRebates() {
		return this.rebates;
	}

	public void setRebates(Integer rebates) {
		this.rebates = rebates;
	}

	public Integer getRebatesmax() {
		return this.rebatesmax;
	}

	public void setRebatesmax(Integer rebatesmax) {
		this.rebatesmax = rebatesmax;
	}

	public String getRebatestype() {
		return this.rebatestype;
	}

	public void setRebatestype(String rebatestype) {
		this.rebatestype = rebatestype;
	}

	public String getEnableRemark() {
		return this.enableRemark;
	}

	public void setEnableRemark(String enableRemark) {
		this.enableRemark = enableRemark;
	}

	public String getRecommendRemark() {
		return this.recommendRemark;
	}

	public void setRecommendRemark(String recommendRemark) {
		this.recommendRemark = recommendRemark;
	}

	public String gainFullEnableRemark(Integer amount, Integer sdiscount) {
		int tmpDiscount = sdiscount == null ? 0 : sdiscount.intValue();
		String res = StringUtils.replace(
				StringUtils.replace(this.enableRemark, "amount", amount.intValue() - tmpDiscount + ".00"), "discount",
				tmpDiscount + ".00");
		if (this.relate != null) {
			Object tmp = BeanUtil.get(this.relate, "shortname");
			if (tmp != null) {
				res = tmp + res;
			}
		}

		return res;
	}

	public String gainFullRecommendRemark(Integer amount, Integer sdiscount) {
		int tmpDiscount = sdiscount == null ? 0 : sdiscount.intValue();
		return StringUtils.replace(
				StringUtils.replace(this.recommendRemark, "amount", amount.intValue() - tmpDiscount + ".00"),
				"discount", tmpDiscount + ".00");
	}

	public Long getBindgoods() {
		return this.bindgoods;
	}

	public void setBindgoods(Long bindgoods) {
		this.bindgoods = bindgoods;
	}

	public Integer getBindnum() {
		return this.bindnum;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setBindnum(Integer bindnum) {
		this.bindnum = bindnum;
	}

	public Integer getMinbuy() {
		return this.minbuy;
	}

	public void setMinbuy(Integer minbuy) {
		this.minbuy = minbuy;
	}

	public String getValidateUrl() {
		return this.validateUrl;
	}

	public void setValidateUrl(String validateUrl) {
		this.validateUrl = validateUrl;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUniqueby() {
		return this.uniqueby;
	}

	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}

	public String getValidBackUrl() {
		return this.validBackUrl;
	}

	public void setValidBackUrl(String validBackUrl) {
		this.validBackUrl = validBackUrl;
	}

	public String getLimitperiodStr() {
		int hour = this.limitperiod.intValue() / 60;
		int min = this.limitperiod.intValue() % 60;
		int day = 0;
		if (hour > 24) {
			day = hour / 24;
			hour %= 24;
		}

		String result = (day > 0 ? day + "天" : "") + (hour > 0 ? hour + "小时" : "") + (min > 0 ? min + "分" : "");
		return result;
	}

	public String getChannel() {
		return this.channel;
	}

	public String getLimg() {
		return this.logo;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getBindmobile() {
		return this.bindmobile;
	}

	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}

	public Long getSpcounterid() {
		return this.spcounterid;
	}

	public void setSpcounterid(Long spcounterid) {
		this.spcounterid = spcounterid;
	}

	public Integer getCostprice1() {
		return this.costprice1;
	}

	public void setCostprice1(Integer costprice1) {
		this.costprice1 = costprice1;
	}

	public Integer getCostprice2() {
		return this.costprice2;
	}

	public void setCostprice2(Integer costprice2) {
		this.costprice2 = costprice2;
	}

	public Integer getDrawperiod() {
		return this.drawperiod;
	}

	public void setDrawperiod(Integer drawperiod) {
		this.drawperiod = drawperiod;
	}

	public boolean hasDistype(String type) {
		return StringUtils.equals(this.distype, type);
	}

	public boolean hasRebatestype(String retype) {
		return StringUtils.equals(this.rebatestype, retype);
	}

	public String gainDiscountType() {
		String tmp = "";
		if (this.hasDistype("order")) {
			tmp = "立减";
		} else if (this.hasDistype("uprice")) {
			tmp = "立减";
		} else if (this.hasDistype("percent")) {
			tmp = "折扣";
		} else if (this.hasDistype("one2one")) {
			tmp = tmp + "买1送1";
		} else if (this.hasDistype("fprice")) {
			tmp = "￥" + this.discount;
		} else if (this.hasDistype("exp")) {
			tmp = "活动";
		}

		if (StringUtils.isBlank(tmp)) {
			if (this.rebates.intValue() > 0) {
				tmp = "立返";
			} else {
				tmp = "优惠";
			}
		}

		return tmp;
	}

	public Map<String, String> gainOtherinfoMap() {
		return JsonUtils.readJsonToMap(this.otherinfo);
	}

	public String gainSimpleDiscountType() {
		Map otherinfoMap = this.gainOtherinfoMap();
		if (StringUtils.isNotBlank((String) otherinfoMap.get("sType"))) {
			return (String) otherinfoMap.get("sType");
		} else {
			String tmp = "";
			if (this.hasDistype("order")) {
				tmp = "减";
			} else if (this.hasDistype("uprice")) {
				tmp = "减";
			} else if (this.hasDistype("percent")) {
				tmp = "折";
			} else if (this.hasDistype("one2one")) {
				tmp = "送";
			} else if (this.hasDistype("fprice")) {
				tmp = "惠";
			} else if (this.hasDistype("exp")) {
				tmp = "惠";
			}

			if (StringUtils.isBlank(tmp) && this.rebates.intValue() > 0) {
				tmp = "返";
			}

			return tmp;
		}
	}

	public String gainSimpleDiscountText(String discountText, String rebatesText) {
		Map otherinfoMap = this.gainOtherinfoMap();
		if (StringUtils.isNotBlank((String) otherinfoMap.get("sText"))) {
			return (String) otherinfoMap.get("sText");
		} else {
			String tmp = "";
			if (this.hasDistype("order")) {
				tmp = "discount元";
			} else if (this.hasDistype("uprice")) {
				tmp = "discount元";
			} else if (this.hasDistype("percent")) {
				tmp = "discount折";
			} else if (this.hasDistype("one2one")) {
				tmp = "买一送一";
			} else if (this.hasDistype("fprice")) {
				tmp = "discount元";
			} else if (this.hasDistype("exp")) {
				tmp = "其他";
			}

			if (StringUtils.isBlank(tmp) && this.rebates.intValue() > 0) {
				if (this.hasRebatestype("Y")) {
					tmp = tmp + "rebates元";
				}

				if (this.hasRebatestype("P")) {
					tmp = tmp + "rebates积分";
				}

				if (this.hasRebatestype("A") || this.hasRebatestype("D")) {
					tmp = tmp + "rebates元券";
				}

				tmp = StringUtils.replace(tmp, "rebates", rebatesText);
			}

			tmp = StringUtils.replace(tmp, "discount", discountText);
			return tmp;
		}
	}

	public String getDiscountText(String bankText, String discountText, String rebatesText) {
		String tmp = "bankname";
		if (this.hasDistype("order")) {
			if (this.discount != null && this.discount.intValue() > 0) {
				tmp = tmp + "每笔订单立减discount元";
			}
		} else if (this.hasDistype("uprice")) {
			if (this.discount != null && this.discount.intValue() > 0) {
				tmp = tmp + "每张票立减discount元";
			}
		} else if (this.hasDistype("percent")) {
			tmp = tmp + "每笔订单discount折优惠";
		} else if (this.hasDistype("one2one")) {
			tmp = tmp + "可享受买一送一";
		} else if (this.hasDistype("fprice")) {
			tmp = tmp + "每张票仅需discount元";
		} else if (this.hasDistype("exp")) {
			tmp = tmp + this.description;
		}

		tmp = StringUtils.replace(tmp, "bankname", bankText);
		tmp = StringUtils.replace(tmp, "discount", discountText);
		if (this.rebates.intValue() > 0) {
			if (!this.hasDistype("uprice") && !this.hasDistype("order")
					|| this.discount != null && this.discount.intValue() > 0) {
				tmp = tmp + ", 立返rebates";
			} else {
				tmp = tmp + "立返rebates";
			}

			if (this.hasRebatestype("Y")) {
				tmp = tmp + "元";
			}

			if (this.hasRebatestype("P")) {
				tmp = tmp + "积分";
			}

			if (this.hasRebatestype("A") || this.hasRebatestype("D")) {
				tmp = tmp + "元券";
			}

			tmp = StringUtils.replace(tmp, "rebates", rebatesText);
		}

		return tmp;
	}

	public String gainDiscount(String noRebates) {
		int tmp = this.discount.intValue();
		if (this.hasExtdicount()) {
			tmp = this.extdiscount.intValue();
		}

		String tmpDiscount = String.valueOf(tmp);
		if (Boolean.parseBoolean(noRebates) && this.hasRebatestype("Y")) {
			tmpDiscount = String.valueOf(tmp + this.rebates.intValue());
		}

		if (this.hasDistype("percent")) {
			String tmpPattern = "0";
			if (tmp != 0 && (100 - tmp) % 10 > 0) {
				tmpPattern = "0.0";
			}

			tmpDiscount = VmBaseUtil.formatPercent(Integer.valueOf(100 - tmp), Integer.valueOf(10), tmpPattern);
		} else if (this.hasDistype("one2one")) {
			tmpDiscount = "X";
		} else if (this.hasDistype("exp")) {
			tmpDiscount = "X元";
		}

		return tmpDiscount;
	}

	public boolean hasExtdicount() {
		return this.extdiscount != null && this.discount.intValue() == 0 && this.extdiscount.intValue() > 0;
	}

	public Integer getIpLimitedOrderCount() {
		return this.ipLimitedOrderCount;
	}

	public void setIpLimitedOrderCount(Integer ipLimitedOrderCount) {
		this.ipLimitedOrderCount = ipLimitedOrderCount;
	}

	public String getCardUkey() {
		return this.cardUkey;
	}

	public void setCardUkey(String cardUkey) {
		this.cardUkey = cardUkey;
	}

	public String getCardNumUnique() {
		return this.cardNumUnique;
	}

	public void setCardNumUnique(String cardNumUnique) {
		this.cardNumUnique = cardNumUnique;
	}

	public Integer getCardNumLimitnum() {
		return this.cardNumLimitnum;
	}

	public void setCardNumLimitnum(Integer cardNumLimitnum) {
		this.cardNumLimitnum = cardNumLimitnum;
	}

	public String getCardbinUkey() {
		return this.cardbinUkey;
	}

	public void setCardbinUkey(String cardbinUkey) {
		this.cardbinUkey = cardbinUkey;
	}

	public Integer getCardNumPeriodIntvel() {
		return this.cardNumPeriodIntvel;
	}

	public void setCardNumPeriodIntvel(Integer cardNumPeriodIntvel) {
		this.cardNumPeriodIntvel = cardNumPeriodIntvel;
	}

	public Integer getCardNumPeriodSpan() {
		return this.cardNumPeriodSpan;
	}

	public void setCardNumPeriodSpan(Integer cardNumPeriodSpan) {
		this.cardNumPeriodSpan = cardNumPeriodSpan;
	}

	public String getLoginfrom() {
		return this.loginfrom;
	}

	public void setLoginfrom(String loginfrom) {
		this.loginfrom = loginfrom;
	}

	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getSpecialrule() {
		return this.specialrule;
	}

	public void setSpecialrule(String specialrule) {
		this.specialrule = specialrule;
	}

	public String getPeriodtype() {
		return this.periodtype;
	}

	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	public String getExtraInfo() {
		return this.extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getPtnids() {
		return this.ptnids;
	}

	public void setPtnids(String ptnids) {
		this.ptnids = ptnids;
	}

	public String getCosttype() {
		return this.costtype;
	}

	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}

	public Integer getCostnum() {
		return this.costnum;
	}

	public void setCostnum(Integer costnum) {
		this.costnum = costnum;
	}

	public String getVerifyType() {
		return this.verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getRelatedidEnable() {
		return StringUtils.isEmpty(this.relatedidEnable) ? "Y" : this.relatedidEnable;
	}

	public void setRelatedidEnable(String relatedidEnable) {
		this.relatedidEnable = relatedidEnable;
	}

	public String getCategoryidEnable() {
		return StringUtils.isEmpty(this.categoryidEnable) ? "Y" : this.categoryidEnable;
	}

	public void setCategoryidEnable(String categoryidEnable) {
		this.categoryidEnable = categoryidEnable;
	}

	public String getItemidEnable() {
		return StringUtils.isEmpty(this.itemidEnable) ? "Y" : this.itemidEnable;
	}

	public void setItemidEnable(String itemidEnable) {
		this.itemidEnable = itemidEnable;
	}

	public String getShowCoupon() {
		return StringUtils.isEmpty(this.showCoupon) ? "Y" : this.showCoupon;
	}

	public void setShowCoupon(String showCoupon) {
		this.showCoupon = showCoupon;
	}

	public String getExcludeSpid() {
		return this.excludeSpid;
	}

	public void setExcludeSpid(String excludeSpid) {
		this.excludeSpid = excludeSpid;
	}

	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomIdEnable() {
		return StringUtils.isEmpty(this.roomIdEnable) ? "Y" : this.roomIdEnable;
	}

	public void setRoomIdEnable(String roomIdEnable) {
		this.roomIdEnable = roomIdEnable;
	}

	public Timestamp getPlayTimeFrom() {
		return this.playTimeFrom;
	}

	public void setPlayTimeFrom(Timestamp playTimeFrom) {
		this.playTimeFrom = playTimeFrom;
	}

	public Timestamp getOrderTimeFrom() {
		return this.orderTimeFrom;
	}

	public void setOrderTimeFrom(Timestamp orderTimeFrom) {
		this.orderTimeFrom = orderTimeFrom;
	}

	public Timestamp getPlayTimeTo() {
		return this.playTimeTo;
	}

	public void setPlayTimeTo(Timestamp playTimeTo) {
		this.playTimeTo = playTimeTo;
	}

	public Timestamp getOrderTimeTo() {
		return this.orderTimeTo;
	}

	public void setOrderTimeTo(Timestamp orderTimeTo) {
		this.orderTimeTo = orderTimeTo;
	}

	public String getRefundEnable() {
		return this.refundEnable;
	}

	public void setRefundEnable(String refundEnable) {
		this.refundEnable = refundEnable;
	}

	public String getConfigMessage() {
		return this.configMessage;
	}

	public void setConfigMessage(String configMessage) {
		this.configMessage = configMessage;
	}

	public String getExcludeOpiFlg() {
		return this.excludeOpiFlg;
	}

	public void setExcludeOpiFlg(String excludeOpiFlg) {
		this.excludeOpiFlg = excludeOpiFlg;
	}

	public String getSpType() {
		return this.spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public Integer gainRealQuantity(int quantity) {
		if (StringUtils.equals(this.distype, "exp")) {
			Map otherMap = JsonUtils.readJsonToMap(this.otherinfo);
			if (otherMap.containsKey("exp_maxnum")) {
				int rq = Integer.valueOf((String) otherMap.get("exp_maxnum")).intValue();
				if (quantity > rq) {
					return Integer.valueOf(rq);
				}
			}
		}

		return Integer.valueOf(quantity);
	}

	public Integer gainGoodsBindMovieQuantity(int quantity) {
		if (StringUtils.equals(this.tag, "goodsbindmovie")) {
			String rateinfo = JsonUtils.getJsonValueByKey(this.otherinfo, "rateinfo");
			if (StringUtils.isNotBlank(rateinfo)) {
				HashMap m = new HashMap();
				String[] args = rateinfo.split(",");
				if (args != null && args.length > 0) {
					String[] arg4 = args;
					int arg5 = args.length;

					for (int arg6 = 0; arg6 < arg5; ++arg6) {
						String arg = arg4[arg6];
						String[] tmp = arg.split(":");
						if (tmp != null && tmp.length > 1) {
							m.put(tmp[0], Integer.valueOf(tmp[1]));
						}
					}
				}

				return (Integer) m.get(quantity + "");
			}
		}

		return null;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public BaseObject getRelate() {
		return this.relate;
	}

	public void setRelate(BaseObject relate) {
		this.relate = relate;
	}

	public String gainItemMaxSellNumKey(Long itemId) {
		return "item_max_sellnum:" + itemId;
	}

	public Integer gainItemMaxSellNum() {
		String key = JsonUtils.getJsonValueByKey(this.otherinfo, "item_max_sellnum");
		return StringUtils.isNotBlank(key) ? Integer.valueOf(key) : null;
	}

	public Long gainDiffSecond() {
		return Long.valueOf(DateUtil.getDiffSecond(this.timeto, this.timefrom));
	}

	public Integer getFullTotalfee() {
		return this.fullTotalfee;
	}

	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}

	public boolean needRedirect() {
		return StringUtils.isBlank(this.validateUrl) ? false
				: !StringUtils.startsWithIgnoreCase(this.validateUrl, "http")
						|| StringUtils.endsWithIgnoreCase(this.validateUrl, "Fast.xhtml");
	}

	public Integer getDaynum() {
		return this.daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}
}