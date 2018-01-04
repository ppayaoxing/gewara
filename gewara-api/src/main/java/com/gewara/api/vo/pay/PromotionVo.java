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

	/***锟斤拷锟斤拷锟斤拷息----------------------------------------------------------------------------------------------*/
	
	private String extraInfo;			//锟斤拷展锟斤拷息
	private String flag;				//锟斤拷锟斤拷锟绞�
	private String tag;					//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷PayConstant.APPLY_TAG*
	private Integer sortnum;			//锟斤拷锟斤拷锟斤拷锟斤拷
	private String opentype;			//锟斤拷锟斤拷锟斤拷锟斤拷   
	private String ptnids;				//支锟斤拷锟斤拷锟斤拷id锟斤拷锟斤拷 锟教硷拷ID
	private Integer discount;			//锟脚惠斤拷锟� 锟桔扣斤拷锟�
	private String distype;				//锟脚惠凤拷式
	private String refundEnable;		// 锟角凤拷支锟斤拷锟斤拷票锟斤拷Y锟斤拷锟斤拷锟剿ｏ拷N锟斤拷锟斤拷锟斤拷锟斤拷
	private String spType; 				//锟筋动锟斤拷锟斤拷锟斤拷
	private String expression;			//锟斤拷锟斤拷锟斤拷式
	private String specialrule;			//锟斤拷锟斤拷锟斤拷锟斤拷锟绞�
	private Integer limitperiod;		//锟斤拷锟斤拷锟睫癸拷锟斤拷锟节ｏ拷锟斤拷锟接ｏ拷
	private Integer limitnum;			//锟斤拷锟斤拷锟睫癸拷锟斤拷锟斤拷
	private Integer minbuy;				//每锟斤拷锟睫癸拷锟斤拷:锟斤拷锟斤拷锟斤拷锟斤拷
	private Integer buynum;				//每锟斤拷锟睫癸拷锟斤拷:锟斤拷锟斤拷锟斤拷锟�
	private String periodtype;			//锟睫癸拷锟斤拷锟斤拷锟斤拷锟斤拷
	private String uniqueby;			//使锟斤拷什么锟斤拷锟斤拷唯一锟斤拷 唯一锟斤拷识
	private String description;			//锟斤拷要说锟斤拷
	private Timestamp timefrom;			//锟脚惠匡拷始时锟斤拷
	private Timestamp timeto;			//锟脚惠斤拷锟斤拷时锟斤拷	
	
	private Timestamp orderTimeFrom;	// 锟铰碉拷锟斤拷始锟斤拷锟斤拷
	private Timestamp orderTimeTo;		// 锟铰碉拷锟斤拷锟斤拷锟斤拷锟斤拷	
	private String addtime1;			//锟铰碉拷时锟斤拷锟睫讹拷1锟斤拷0000
	private String addtime2;			//锟铰碉拷时锟斤拷锟睫讹拷2锟斤拷2400
	private String addweek;				//锟铰碉拷锟杰硷拷
	
	private String remark;				//锟斤拷锟斤拷锟斤拷时说锟斤拷 锟斤拷锟斤拷锟矫憋拷锟斤拷
	private String enableRemark;		//锟斤拷锟斤拷时锟斤拷说锟斤拷 锟斤拷锟矫憋拷锟斤拷
	private String adcontent;			//锟斤拷锟斤拷锟斤拷锟� 锟斤拷细说锟斤拷
	private String recommendRemark;		//锟狡硷拷时锟斤拷说锟斤拷
	private String configMessage;   	// 锟斤拷示锟斤拷息
	private String banner;				//锟斤拷锟斤拷banner图片
	private String loginfrom;			//锟斤拷录锟斤拷源
	private String citycode;			//锟斤拷锟斤拷锟叫憋拷
	private Integer fullTotalfee;		//锟斤拷锟斤拷锟劫才诧拷锟斤拷锟脚惠ｏ拷锟斤拷锟斤拷锟斤拷
	private String otherinfo;			//锟斤拷锟斤拷锟斤拷息:
	//锟斤拷锟斤拷锟斤拷bin校锟斤拷 ;;;
	//sType锟斤拷sText锟斤拷mpiIsShow锟斤拷exp_minnum锟斤拷式锟斤拷小锟斤拷锟斤拷锟斤拷锟斤拷exp_maxnum锟斤拷式锟斤拷锟斤拷锟斤拷锟斤拷锟絬nCheckCardnum锟斤拷mpiIndex锟斤拷
	
	/***业锟斤拷锟斤拷息----------------------------------------------------------------------------------------------*/
		
	
	/***支锟斤拷锟斤拷息----------------------------------------------------------------------------------------------*/
	private String paymethod;			//锟斤拷锟斤拷支锟斤拷锟斤拷式
	private String logo;				//锟斤拷锟斤拷Logo
	private String cardbinUkey;  	 	//锟斤拷锟斤拷锟斤拷证锟斤拷识
	private String validateUrl;			//锟斤拷证锟斤拷转URL
	private String validBackUrl;		//支锟斤拷通知URL锟斤拷证
	private String cardUkey;			//锟斤拷锟斤拷证唯一锟斤拷识 锟斤拷锟斤拷证锟斤拷
	private String cardNumUnique;  		//锟角凤拷锟斤拷锟叫匡拷锟斤拷锟斤拷锟斤拷证 锟斤拷锟斤拷锟斤拷锟斤拷
	private Integer cardNumPeriodIntvel; //锟斤拷锟叫匡拷每锟斤拷使锟斤拷锟睫癸拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟�
	private Integer cardNumPeriodSpan;	//锟斤拷锟叫匡拷锟斤拷锟斤拷锟斤拷锟� 锟睫癸拷锟斤拷锟斤拷
	private Integer cardNumLimitnum; 	//锟斤拷锟叫匡拷锟睫癸拷锟斤拷锟斤拷 锟睫癸拷锟斤拷锟斤拷
	
	/***锟斤拷锟斤拷锟斤拷息----------------------------------------------------------------------------------------------*/
	private String bankname;			//锟斤拷锟斤拷锟斤拷锟斤拷
	private Integer extdiscount;		//锟解部锟脚惠斤拷锟�
	private String channel;				//锟斤拷锟酵ｏ拷锟筋动锟脚伙拷/锟斤拷锟斤拷锟斤拷锟斤拷锟脚伙拷
	private String bindmobile;			//锟斤拷锟街伙拷
	//锟斤拷锟侥成憋拷锟桔ｏ拷锟斤拷券锟斤拷锟竭硷拷一锟斤拷
	private String costtype;		//锟缴憋拷锟斤拷锟斤拷锟酵ｏ拷影片锟斤拷准奂锟絰元锟斤拷锟斤拷锟斤拷奂锟絰元  锟斤拷锟侥成憋拷锟斤拷
	private Integer costnum;		//锟缴憋拷锟斤拷锟斤拷锟斤拷  锟缴憋拷锟斤拷锟斤拷锟斤拷
	private String verifyType;		//锟斤拷态锟斤拷锟斤拷证锟斤拷锟酵ｏ拷锟睫ｏ拷锟斤拷锟截革拷使锟矫ｏ拷锟斤拷锟斤拷锟斤拷使锟矫ｏ拷锟斤拷锟斤拷锟斤拷锟截革拷使锟斤拷 VERIFYTYPE_ONLYONE  锟斤拷锟斤拷锟斤拷锟斤拷锟�
	private String showCoupon;	//	锟角凤拷锟斤拷前台展示锟斤拷为锟剿硷拷锟斤拷锟较碉拷默锟斤拷为Y锟斤拷锟斤拷锟斤拷为Y锟斤拷锟斤拷锟斤拷锟斤拷为N锟斤拷
	private String excludeSpid;		//锟脚筹拷锟斤拷锟斤拷锟截价活动 锟斤拷锟斤拷锟斤拷锟斤拷锟截价活动
	private Integer rebates;			//每锟绞讹拷锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷
	private Integer rebatesmax;			//前锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷
	private String rebatestype;			//锟斤拷锟斤拷锟斤拷锟酵ｏ拷锟斤拷值锟斤拷锟酵匡拷 
	private Long drawactivity;  		//锟矫伙拷锟斤拷锟斤拷票锟襟返伙拷券锟斤拷锟矫抽奖锟斤拷式锟斤拷锟斤拷锟矫伙拷 锟介奖锟筋动id
	private Integer drawperiod;			//锟斤拷票锟缴癸拷锟斤拷取锟斤拷券锟斤拷锟斤拷 锟斤拷取锟斤拷锟斤拷
	private Integer bindDrawCardNum;	//锟斤拷锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷取锟斤拷锟斤拷
	private Long bindgoods;				//锟斤拷锟斤拷锟阶诧拷 锟斤拷锟阶诧拷
	private Integer bindnum;			//锟阶餐癸拷票锟斤拷锟斤拷 使锟斤拷锟斤拷锟斤拷
	private Integer ipLimitedOrderCount;//锟斤拷ip锟斤拷锟斤拷锟铰碉拷锟斤拷锟斤拷	
	private Long spcounterid;			//使锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷ID
	
	/***业锟斤拷锟斤拷息----------------------------------------------------------------------------------------------*/
	private Timestamp playTimeFrom;		// 锟斤拷锟轿匡拷始锟斤拷锟斤拷
	private Timestamp playTimeTo;		// 锟斤拷锟轿斤拷锟斤拷锟斤拷锟斤拷	
	private String excludeOpiFlg;		// 锟脚筹拷锟斤拷锟解场锟斤拷Y锟斤拷锟脚筹拷锟斤拷N锟斤拷锟斤拷锟脚筹拷	
	private String time1;				//锟斤拷映时锟斤拷锟睫讹拷1锟斤拷0000 锟斤拷锟斤拷时锟斤拷
	private String time2;				//锟斤拷映时锟斤拷锟睫讹拷2锟斤拷2400 锟斤拷锟斤拷时锟斤拷
	private String weektype;			//锟斤拷锟斤拷锟杰硷拷 锟斤拷锟斤拷锟斤拷锟斤拷
	
	private String relatedid;			//锟斤拷锟斤拷锟斤拷斜锟�  锟斤拷锟斤拷ID
	private String relatedidEnable;	    // 锟斤拷锟斤拷ID锟角凤拷锟斤拷茫锟轿拷思锟斤拷锟斤拷系锟侥拷锟轿猋锟斤拷锟斤拷锟斤拷为Y锟斤拷锟斤拷锟斤拷锟斤拷为N
	private String categoryid;			//小锟斤拷锟斤拷锟叫憋拷 锟斤拷目ID
	private String categoryidEnable;	//	锟斤拷目ID锟角凤拷锟斤拷茫锟轿拷思锟斤拷锟斤拷系锟侥拷锟轿猋锟斤拷锟斤拷锟斤拷为Y锟斤拷锟斤拷锟斤拷锟斤拷为N
	private String itemid;				//锟斤拷细锟斤拷锟斤拷锟叫憋拷 锟斤拷锟斤拷ID
	private String itemidEnable;		//	锟斤拷锟斤拷ID锟角凤拷锟斤拷茫锟轿拷思锟斤拷锟斤拷系锟侥拷锟轿猋锟斤拷锟斤拷锟斤拷Y锟斤拷锟斤拷锟斤拷锟斤拷为N
	private String roomId;				// 影锟斤拷ID
	private String roomIdEnable;		// 影锟斤拷ID锟角凤拷锟斤拷锟�
	private String goodsid;				//锟斤拷锟截凤拷锟斤拷锟叫憋拷 锟斤拷品ID
	//锟斤拷锟斤拷 rateinfo gainGoodsBindMovieQuantity
	private String seatType;			//锟斤拷位锟斤拷锟斤拷 支锟斤拷锟斤拷位
	private String edition;				//锟芥本锟斤拷锟斤拷 锟芥本
	private Integer price1;				//锟斤拷锟桔凤拷围1
	private Integer price2;				//锟斤拷锟桔凤拷围2
	private Integer pricegap;			//gewa锟斤拷锟斤拷锟斤拷杀锟斤拷锟� 锟斤拷鄯锟轿�
	private Integer costprice1;			//锟缴憋拷锟桔凤拷围1
	private Integer costprice2;			//锟缴憋拷锟桔凤拷围2
	private String fieldid;				//锟斤拷锟截凤拷锟斤拷锟叫憋拷 锟斤拷锟斤拷ID
	private Integer daynum;			// 锟斤拷效锟斤拷锟斤拷 
	
	private BaseObject relate;

	private Timestamp createtime;		//锟斤拷锟斤拷时锟斤拷
	private Timestamp updatetime;		//锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷
		
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
		if(StringUtils.isBlank(this.paymethod)) {
            return true;
        }
		String[] pmList = StringUtils.split(this.paymethod, ",");
		for(String pm: pmList){
			if(StringUtils.equals(pm, spaymethod)) {
                return true;
            }
			String[] pair = StringUtils.split(pm, ":");
			if(StringUtils.equals(pair[0], spaymethod)){
				if(pair.length==1 || pair.length>1 && StringUtils.equals(pair[1], paybank)) {
                    return true;
                }
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
		String result = (day > 0?day+"锟斤拷":"") + (hour>0? hour+"小时":"") + (min>0?min+"锟斤拷":"");
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
			tmp = "锟斤拷锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "锟斤拷锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "锟桔匡拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = tmp + "锟斤拷1锟斤拷1";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "锟斤拷" + this.discount;
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "锟筋动";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				tmp = "锟斤拷锟斤拷";
			}else{
				tmp = "锟脚伙拷";
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
			tmp = "锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = "锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "锟斤拷";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				tmp = "锟斤拷";
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
			tmp = "discount锟斤拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = "锟斤拷一锟斤拷一";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "discount元";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "锟斤拷锟斤拷";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				if(hasRebatestype("Y")) {
                    tmp += "rebates元";
                }
				if(hasRebatestype("P")) {
                    tmp += "rebates锟斤拷锟斤拷";
                }
				if(hasRebatestype("A") || hasRebatestype("D")) {
                    tmp += "rebates元券";
                }
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
				tmp = tmp + "每锟绞讹拷锟斤拷锟斤拷锟斤拷discount元";
			}
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			if(this.discount != null && this.discount > 0){
				tmp = tmp + "每锟斤拷票锟斤拷锟斤拷discount元";
			}
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = tmp + "每锟绞讹拷锟斤拷discount锟斤拷锟脚伙拷";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = tmp + "锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷一";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = tmp + "每锟斤拷票锟斤拷锟斤拷discount元";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = tmp + this.description;
		}
		tmp = StringUtils.replace(tmp, "bankname", bankText);
		tmp = StringUtils.replace(tmp, "discount", discountText);
		if(this.rebates>0){
			if((hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET) || hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)) && !(this.discount != null && this.discount > 0)){
				tmp += "锟斤拷锟斤拷rebates";
			}else{
				tmp += ", 锟斤拷锟斤拷rebates";
			}
			if(hasRebatestype("Y")) {
                tmp += "元";
            }
			if(hasRebatestype("P")) {
                tmp += "锟斤拷锟斤拷";
            }
			if(hasRebatestype("A") || hasRebatestype("D")) {
                tmp += "元券";
            }
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
			if(tmp !=0 && (100-tmp)%10>0) {
                tmpPattern = "0.0";
            }
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
	//锟斤拷锟斤拷潜锟斤拷式锟侥活动锟斤拷锟斤拷锟叫癸拷式锟斤拷锟斤拷锟斤拷锟狡的ｏ拷锟津按癸拷式锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟界：1-2锟脚帮拷锟桔扣价格，筹拷锟斤拷2锟脚的帮拷原锟斤拷
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
