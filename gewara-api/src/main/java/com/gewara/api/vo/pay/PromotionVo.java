package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.SalesPromotionConstant;
import com.gewara.model.BaseObject;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import com.gewara.util.VmBaseUtil;

public class PromotionVo extends BaseVo{
	private static final long serialVersionUID = 4201413246406397258L;

	private Long id;

	/***基础信息----------------------------------------------------------------------------------------------*/
	
	private String extraInfo;			//扩展信息
	private String flag;				//特殊标识
	private String tag;					//订单类型：见PayConstant.APPLY_TAG*
	private Integer sortnum;			//排序数字
	private String opentype;			//开放类型   
	private String ptnids;				//支付渠道id集合 商家ID
	private Integer discount;			//优惠金额 折扣金额
	private String distype;				//优惠方式
	private String refundEnable;		// 是否支持退票，Y：可退；N：不可退
	private String spType; 				//活动码类型
	private String expression;			//计算表达式
	private String specialrule;			//特殊规则表达式
	private Integer limitperiod;		//个人限够周期（分钟）
	private Integer limitnum;			//个人限够次数
	private Integer minbuy;				//每单限购数:最少数量
	private Integer buynum;				//每单限购数:最大数量
	private String periodtype;			//限够周期类型
	private String uniqueby;			//使用什么限制唯一性 唯一标识
	private String description;			//简要说明
	private Timestamp timefrom;			//优惠开始时间
	private Timestamp timeto;			//优惠结束时间	
	
	private Timestamp orderTimeFrom;	// 下单开始日期
	private Timestamp orderTimeTo;		// 下单结束日期	
	private String addtime1;			//下单时段限定1：0000
	private String addtime2;			//下单时段限定2：2400
	private String addweek;				//下单周几
	
	private String remark;				//不可用时说明 不可用标题
	private String enableRemark;		//可用时的说明 可用标题
	private String adcontent;			//广告内容 详细说明
	private String recommendRemark;		//推荐时的说明
	private String configMessage;   	// 提示信息
	private String banner;				//顶层banner图片
	private String loginfrom;			//登录来源
	private String citycode;			//城市列表
	private Integer fullTotalfee;		//满多少才参与优惠（包含）
	private String otherinfo;			//其他信息:
	//不做卡bin校验 ;;;
	//sType、sText、mpiIsShow、exp_minnum公式最小购买数、exp_maxnum公式最大购买数、unCheckCardnum、mpiIndex、
	
	/***业务信息----------------------------------------------------------------------------------------------*/
		
	
	/***支付信息----------------------------------------------------------------------------------------------*/
	private String paymethod;			//限制支付方式
	private String logo;				//银行Logo
	private String cardbinUkey;  	 	//卡号验证标识
	private String validateUrl;			//验证跳转URL
	private String validBackUrl;		//支付通知URL验证
	private String cardUkey;			//卡验证唯一标识 卡验证组
	private String cardNumUnique;  		//是否银行卡次数验证 卡号限制
	private Integer cardNumPeriodIntvel; //银行卡每次使用限购周期 间隔周期
	private Integer cardNumPeriodSpan;	//银行卡最大周期 限够周期
	private Integer cardNumLimitnum; 	//银行卡限够次数 限够次数
	
	/***其它信息----------------------------------------------------------------------------------------------*/
	private String bankname;			//银行名称
	private Integer extdiscount;		//外部优惠金额
	private String channel;				//类型：活动优惠/渠道合作优惠
	private String bindmobile;			//绑定手机
	//更改成本价，与券的逻辑一样
	private String costtype;		//成本价类型：影片最底价加x元，结算价加x元  更改成本价
	private Integer costnum;		//成本价增量  成本价设置
	private String verifyType;		//动态码验证类型：无，可重复使用（不记名使用），不可重复使用 VERIFYTYPE_ONLYONE  电子码参与
	private String showCoupon;	//	是否在前台展示，为了兼容老的默认为Y，可用为Y，不可用为N，
	private String excludeSpid;		//排除其他特价活动 互斥其他特价活动
	private Integer rebates;			//每笔订单返利 返利数
	private Integer rebatesmax;			//前多少名返利 返利名额
	private String rebatestype;			//返利类型：充值、送卡 
	private Long drawactivity;  		//用户购完票后返回券采用抽奖方式返到用户 抽奖活动id
	private Integer drawperiod;			//购票成功领取返券周期 领取周期
	private Integer bindDrawCardNum;	//周期内领取次数控制 领取次数
	private Long bindgoods;				//赠送套餐 绑定套餐
	private Integer bindnum;			//套餐购票数量 使用数量
	private Integer ipLimitedOrderCount;//单ip限制下单数量	
	private Long spcounterid;			//使用数量控制器的ID
	
	/***业务信息----------------------------------------------------------------------------------------------*/
	private Timestamp playTimeFrom;		// 场次开始日期
	private Timestamp playTimeTo;		// 场次结束日期	
	private String excludeOpiFlg;		// 排除特殊场次Y：排除，N：不排除	
	private String time1;				//放映时段限定1：0000 场次时段
	private String time2;				//放映时段限定2：2400 场次时段
	private String weektype;			//场次周几 场次星期
	
	private String relatedid;			//大分类列表  场馆ID
	private String relatedidEnable;	    // 场馆ID是否可用，为了兼容老的默认为Y，可用为Y，不可用为N
	private String categoryid;			//小分类列表 项目ID
	private String categoryidEnable;	//	项目ID是否可用，为了兼容老的默认为Y，可用为Y，不可用为N
	private String itemid;				//详细分类列表 场次ID
	private String itemidEnable;		//	场次ID是否可用，为了兼容老的默认为Y，可用Y，不可用为N
	private String roomId;				// 影厅ID
	private String roomIdEnable;		// 影厅ID是否可用
	private String goodsid;				//场地分类列表 物品ID
	//比率 rateinfo gainGoodsBindMovieQuantity
	private String seatType;			//座位类型 支持座位
	private String edition;				//版本数据 版本
	private Integer price1;				//卖价范围1
	private Integer price2;				//卖价范围2
	private Integer pricegap;			//gewa卖价与成本价 差价范围
	private Integer costprice1;			//成本价范围1
	private Integer costprice2;			//成本价范围2
	private String fieldid;				//场地分类列表 场地ID
	private Integer daynum;			// 有效天数 
	
	private BaseObject relate;

	private Timestamp createtime;		//创建时间
	private Timestamp updatetime;		//数量更新时间
		
	@Override
	public Serializable realId() {
		return id;
	}

	public Integer getBindDrawCardNum() {
		return bindDrawCardNum;
	}
	public void setBindDrawCardNum(Integer bindDrawCardNum) {
		this.bindDrawCardNum = bindDrawCardNum;
	}
	
	public Long getDrawactivity() {
		return drawactivity;
	}
	public void setDrawactivity(Long drawactivity) {
		this.drawactivity = drawactivity;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Timestamp getTimefrom() {
		return timefrom;
	}
	public void setTimefrom(Timestamp timefrom) {
		this.timefrom = timefrom;
	}
	public Timestamp getTimeto() {
		return timeto;
	}
	public void setTimeto(Timestamp timeto) {
		this.timeto = timeto;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public boolean isValidPaymethod(String spaymethod, String paybank){
		if(StringUtils.isBlank(this.paymethod)) return true;
		String[] pmList = StringUtils.split(this.paymethod, ",");
		for(String pm: pmList){
			if(StringUtils.equals(pm, spaymethod)) return true;
			String[] pair = StringUtils.split(pm, ":");
			if(StringUtils.equals(pair[0], spaymethod)){
				if(pair.length==1 || pair.length>1 && StringUtils.equals(pair[1], paybank)) return true;
			}
		}
		return false;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	public Integer getExtdiscount() {
		return extdiscount;
	}

	public void setExtdiscount(Integer extdiscount) {
		this.extdiscount = extdiscount;
	}

	public String getDistype() {
		return distype;
	}
	public void setDistype(String distype) {
		this.distype = distype;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getLimitnum() {
		return limitnum;
	}
	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}
	public Integer getLimitperiod() {
		return limitperiod;
	}
	public void setLimitperiod(Integer limitperiod) {
		this.limitperiod = limitperiod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Integer getPricegap() {
		return pricegap;
	}
	public void setPricegap(Integer pricegap) {
		this.pricegap = pricegap;
	}
	public Integer getPrice1() {
		return price1;
	}
	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}
	public Integer getPrice2() {
		return price2;
	}
	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getFieldid() {
		return fieldid;
	}
	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public String getWeektype() {
		return weektype;
	}
	public void setWeektype(String weektype) {
		this.weektype = weektype;
	}
	public String getAddtime1() {
		return addtime1;
	}
	public void setAddtime1(String addtime1) {
		this.addtime1 = addtime1;
	}
	public String getAddtime2() {
		return addtime2;
	}
	public void setAddtime2(String addtime2) {
		this.addtime2 = addtime2;
	}
	public String getAddweek() {
		return addweek;
	}
	public void setAddweek(String addweek) {
		this.addweek = addweek;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getAdcontent() {
		return adcontent;
	}
	public void setAdcontent(String adcontent) {
		this.adcontent = adcontent;
	}
	public Integer getBuynum() {
		return buynum;
	}
	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}
	public Integer getRebates() {
		return rebates;
	}
	public void setRebates(Integer rebates) {
		this.rebates = rebates;
	}
	public Integer getRebatesmax() {
		return rebatesmax;
	}
	public void setRebatesmax(Integer rebatesmax) {
		this.rebatesmax = rebatesmax;
	}
	public String getRebatestype() {
		return rebatestype;
	}
	public void setRebatestype(String rebatestype) {
		this.rebatestype = rebatestype;
	}
	public String getEnableRemark() {
		return enableRemark;
	}
	public void setEnableRemark(String enableRemark) {
		this.enableRemark = enableRemark;
	}
	public String getRecommendRemark() {
		return recommendRemark;
	}
	public void setRecommendRemark(String recommendRemark) {
		this.recommendRemark = recommendRemark;
	}
	public String gainFullEnableRemark(Integer amount, Integer sdiscount){
		int tmpDiscount = sdiscount == null ? 0: sdiscount.intValue();
		String res = StringUtils.replace(StringUtils.replace(enableRemark, "amount", amount - tmpDiscount+".00"), "discount", tmpDiscount + ".00");
		if(relate!=null){
			Object tmp = BeanUtil.get(relate, "shortname");
			if(tmp!=null){
				res = tmp + res;
			}
		}
		return res;
	}
	public String gainFullRecommendRemark(Integer amount, Integer sdiscount){
		int tmpDiscount = sdiscount == null ? 0: sdiscount.intValue();
		return StringUtils.replace(StringUtils.replace(recommendRemark, "amount", amount - tmpDiscount+".00"), "discount", tmpDiscount + ".00");
	}
	public Long getBindgoods() {
		return bindgoods;
	}
	public void setBindgoods(Long bindgoods) {
		this.bindgoods = bindgoods;
	}
	public Integer getBindnum() {
		return bindnum;
	}
	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setBindnum(Integer bindnum) {
		this.bindnum = bindnum;
	}
	public Integer getMinbuy() {
		return minbuy;
	}
	public void setMinbuy(Integer minbuy) {
		this.minbuy = minbuy;
	}
	public String getValidateUrl() {
		return validateUrl;
	}
	public void setValidateUrl(String validateUrl) {
		this.validateUrl = validateUrl;
	}
	public Integer getSortnum() {
		return sortnum;
	}
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUniqueby() {
		return uniqueby;
	}
	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}
	public String getValidBackUrl() {
		return validBackUrl;
	}
	public void setValidBackUrl(String validBackUrl) {
		this.validBackUrl = validBackUrl;
	}
	public String getLimitperiodStr() {
		int hour = limitperiod/60;
		int min = limitperiod%60;
		int day = 0;
		if(hour > 24){
			day = hour/24;
			hour = hour % 24;
		}
		String result = (day > 0?day+"天":"") + (hour>0? hour+"小时":"") + (min>0?min+"分":"");
		return result;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public String getLimg(){
		return this.logo;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getBindmobile() {
		return bindmobile;
	}
	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}
	public Long getSpcounterid() {
		return spcounterid;
	}
	public void setSpcounterid(Long spcounterid) {
		this.spcounterid = spcounterid;
	}
	public Integer getCostprice1() {
		return costprice1;
	}
	public void setCostprice1(Integer costprice1) {
		this.costprice1 = costprice1;
	}
	public Integer getCostprice2() {
		return costprice2;
	}
	public void setCostprice2(Integer costprice2) {
		this.costprice2 = costprice2;
	}

	public Integer getDrawperiod() {
		return drawperiod;
	}

	public void setDrawperiod(Integer drawperiod) {
		this.drawperiod = drawperiod;
	}
	
	public boolean hasDistype(String type){
		return StringUtils.equals(this.distype, type);
	}
	
	public boolean hasRebatestype(String retype){
		return StringUtils.equals(this.rebatestype, retype);
	}
	
	public String gainDiscountType(){
		String tmp = "";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			tmp = "立减";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "立减";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "折扣";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = tmp + "买1送1";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "￥" + this.discount;
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "活动";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				tmp = "立返";
			}else{
				tmp = "优惠";
			}
		}
		return tmp;
	}
	public Map<String,String> gainOtherinfoMap(){
		return JsonUtils.readJsonToMap(otherinfo);
	}
	
	public String gainSimpleDiscountType(){
		Map<String,String> otherinfoMap = gainOtherinfoMap();
		if(StringUtils.isNotBlank(otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TYPE))){
			return otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TYPE);
		}
		String tmp = "";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			tmp = "减";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "减";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "折";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = "送";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "惠";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "惠";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				tmp = "返";
			}
		}
		return tmp;
	}
	
	public String gainSimpleDiscountText(String discountText,String rebatesText){
		Map<String,String> otherinfoMap = gainOtherinfoMap();
		if(StringUtils.isNotBlank(otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TEXT))){
			return otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TEXT);
		}
		String tmp = "";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			tmp = "discount元";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "discount元";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "discount折";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = "买一送一";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "discount元";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "其他";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				if(hasRebatestype("Y")) tmp += "rebates元";
				if(hasRebatestype("P")) tmp += "rebates积分";
				if(hasRebatestype("A") || hasRebatestype("D")) tmp += "rebates元券";
				tmp = StringUtils.replace(tmp, "rebates", rebatesText);
			}
		}
		tmp = StringUtils.replace(tmp, "discount", discountText);
		return tmp;
	}
	
	public String getDiscountText(String bankText, String discountText, String rebatesText){
		String tmp = "bankname";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			if(this.discount != null && this.discount > 0){
				tmp = tmp + "每笔订单立减discount元";
			}
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			if(this.discount != null && this.discount > 0){
				tmp = tmp + "每张票立减discount元";
			}
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = tmp + "每笔订单discount折优惠";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = tmp + "可享受买一送一";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = tmp + "每张票仅需discount元";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = tmp + this.description;
		}
		tmp = StringUtils.replace(tmp, "bankname", bankText);
		tmp = StringUtils.replace(tmp, "discount", discountText);
		if(this.rebates>0){
			if((hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET) || hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)) && !(this.discount != null && this.discount > 0)){
				tmp += "立返rebates";
			}else{
				tmp += ", 立返rebates";
			}
			if(hasRebatestype("Y")) tmp += "元";
			if(hasRebatestype("P")) tmp += "积分";
			if(hasRebatestype("A") || hasRebatestype("D")) tmp += "元券";
			tmp = StringUtils.replace(tmp, "rebates", rebatesText);
		}
		return tmp;
	}
	
	public String gainDiscount(String noRebates){
		int tmp = this.discount;
		if(hasExtdicount()){
			tmp = this.extdiscount;
		}
		String tmpDiscount = String.valueOf(tmp);
		if(Boolean.parseBoolean(noRebates) && hasRebatestype("Y")){
			tmpDiscount = String.valueOf(tmp + this.rebates);
		}
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			String tmpPattern = "0";
			if(tmp !=0 && (100-tmp)%10>0) tmpPattern = "0.0";
			tmpDiscount = VmBaseUtil.formatPercent(100-tmp, 10, tmpPattern);
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmpDiscount = "X";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmpDiscount = "X元";
		}
		return tmpDiscount;
	}
	
	public boolean hasExtdicount(){
		return this.extdiscount != null && this.discount == 0 && this.extdiscount > 0;
	}

	public Integer getIpLimitedOrderCount() {
		return ipLimitedOrderCount;
	}

	public void setIpLimitedOrderCount(Integer ipLimitedOrderCount) {
		this.ipLimitedOrderCount = ipLimitedOrderCount;
	}

	public String getCardUkey() {
		return cardUkey;
	}

	public void setCardUkey(String cardUkey) {
		this.cardUkey = cardUkey;
	}

	public String getCardNumUnique() {
		return cardNumUnique;
	}

	public void setCardNumUnique(String cardNumUnique) {
		this.cardNumUnique = cardNumUnique;
	}

	public Integer getCardNumLimitnum() {
		return cardNumLimitnum;
	}

	public void setCardNumLimitnum(Integer cardNumLimitnum) {
		this.cardNumLimitnum = cardNumLimitnum;
	}

	public String getCardbinUkey() {
		return cardbinUkey;
	}

	public void setCardbinUkey(String cardbinUkey) {
		this.cardbinUkey = cardbinUkey;
	}

	public Integer getCardNumPeriodIntvel() {
		return cardNumPeriodIntvel;
	}

	public void setCardNumPeriodIntvel(Integer cardNumPeriodIntvel) {
		this.cardNumPeriodIntvel = cardNumPeriodIntvel;
	}

	public Integer getCardNumPeriodSpan() {
		return cardNumPeriodSpan;
	}

	public void setCardNumPeriodSpan(Integer cardNumPeriodSpan) {
		this.cardNumPeriodSpan = cardNumPeriodSpan;
	}
	
	public String getLoginfrom() {
		return loginfrom;
	}

	public void setLoginfrom(String loginfrom) {
		this.loginfrom = loginfrom;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getSpecialrule() {
		return specialrule;
	}

	public void setSpecialrule(String specialrule) {
		this.specialrule = specialrule;
	}

	public String getPeriodtype() {
		return periodtype;
	}

	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getPtnids() {
		return ptnids;
	}

	public void setPtnids(String ptnids) {
		this.ptnids = ptnids;
	}

	public String getCosttype() {
		return costtype;
	}

	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}

	public Integer getCostnum() {
		return costnum;
	}

	public void setCostnum(Integer costnum) {
		this.costnum = costnum;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getRelatedidEnable() {
		return StringUtils.isEmpty(relatedidEnable) ? SalesPromotionConstant.ENABLE : relatedidEnable;
	}

	public void setRelatedidEnable(String relatedidEnable) {
		this.relatedidEnable = relatedidEnable;
	}

	public String getCategoryidEnable() {
		return StringUtils.isEmpty(categoryidEnable) ? SalesPromotionConstant.ENABLE : categoryidEnable;
	}

	public void setCategoryidEnable(String categoryidEnable) {
		this.categoryidEnable = categoryidEnable;
	}

	public String getItemidEnable() {
		return StringUtils.isEmpty(itemidEnable) ? SalesPromotionConstant.ENABLE : itemidEnable;
	}

	public void setItemidEnable(String itemidEnable) {
		this.itemidEnable = itemidEnable;
	}

	public String getShowCoupon() {
		return StringUtils.isEmpty(showCoupon) ? SalesPromotionConstant.ENABLE : showCoupon;
	}

	public void setShowCoupon(String showCoupon) {
		this.showCoupon = showCoupon;
	}

	public String getExcludeSpid() {
		return excludeSpid;
	}

	public void setExcludeSpid(String excludeSpid) {
		this.excludeSpid = excludeSpid;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomIdEnable() {
		return StringUtils.isEmpty(roomIdEnable) ? SalesPromotionConstant.ENABLE : roomIdEnable;
	}

	public void setRoomIdEnable(String roomIdEnable) {
		this.roomIdEnable = roomIdEnable;
	}

	public Timestamp getPlayTimeFrom() {
		return playTimeFrom;
	}

	public void setPlayTimeFrom(Timestamp playTimeFrom) {
		this.playTimeFrom = playTimeFrom;
	}

	public Timestamp getOrderTimeFrom() {
		return orderTimeFrom;
	}

	public void setOrderTimeFrom(Timestamp orderTimeFrom) {
		this.orderTimeFrom = orderTimeFrom;
	}

	public Timestamp getPlayTimeTo() {
		return playTimeTo;
	}

	public void setPlayTimeTo(Timestamp playTimeTo) {
		this.playTimeTo = playTimeTo;
	}

	public Timestamp getOrderTimeTo() {
		return orderTimeTo;
	}

	public void setOrderTimeTo(Timestamp orderTimeTo) {
		this.orderTimeTo = orderTimeTo;
	}

	public String getRefundEnable() {
		return refundEnable;
	}

	public void setRefundEnable(String refundEnable) {
		this.refundEnable = refundEnable;
	}

	public String getConfigMessage() {
		return configMessage;
	}

	public void setConfigMessage(String configMessage) {
		this.configMessage = configMessage;
	}

	public String getExcludeOpiFlg() {
		return excludeOpiFlg;
	}

	public void setExcludeOpiFlg(String excludeOpiFlg) {
		this.excludeOpiFlg = excludeOpiFlg;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}
	//如果是表达式的活动并且有公式数量限制的，则按公式数量的来计算数量，如：1-2张按折扣价格，超出2张的按原价
	public Integer gainRealQuantity(int quantity){
		if(StringUtils.equals(distype, SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			Map<String, String> otherMap = JsonUtils.readJsonToMap(otherinfo);
			if(otherMap.containsKey(SalesPromotionConstant.EXP_MAXNUM)){
				int rq = Integer.valueOf(otherMap.get(SalesPromotionConstant.EXP_MAXNUM));
				if(quantity>rq){
					return rq;
				}
			}
		}
		return quantity;
	}
	public Integer gainGoodsBindMovieQuantity(int quantity){
		if(StringUtils.equals(tag, SalesPromotionConstant.APPLY_TAG_GOODSBINDMOBIE)){
			String rateinfo = JsonUtils.getJsonValueByKey(otherinfo, "rateinfo");
			if(StringUtils.isNotBlank(rateinfo)){
				Map<String, Integer> m = new HashMap<String, Integer>();
				String[] args = rateinfo.split(",");
				if(args!=null && args.length>0){
					for(String arg : args){
						String[] tmp = arg.split(":");
						if(tmp!=null && tmp.length>1) {
							m.put(tmp[0], Integer.valueOf(tmp[1]));
						}
					}
				}
				return m.get(quantity+"");
			}
		}
		return null;
	}
	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public BaseObject getRelate() {
		return relate;
	}

	public void setRelate(BaseObject relate) {
		this.relate = relate;
	}
	public String gainItemMaxSellNumKey(Long itemId){
		return SalesPromotionConstant.ITEM_MAX_SELLNUM + ":" + itemId;
	}
	public Integer gainItemMaxSellNum(){
		String key = JsonUtils.getJsonValueByKey(otherinfo, SalesPromotionConstant.ITEM_MAX_SELLNUM);
		if(StringUtils.isNotBlank(key)){
			return Integer.valueOf(key);
		}
		return null;
	}
	public Long gainDiffSecond(){
		return DateUtil.getDiffSecond(timeto, timefrom);
	}

	public Integer getFullTotalfee() {
		return fullTotalfee;
	}

	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}
	public boolean needRedirect(){
		if(StringUtils.isBlank(validateUrl)){
			return false;
		}
		if(!StringUtils.startsWithIgnoreCase(validateUrl, "http") || StringUtils.endsWithIgnoreCase(validateUrl, "Fast.xhtml")){
			return true;
		}
		return false;
	}

	public Integer getDaynum() {
		return daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}
	
}
