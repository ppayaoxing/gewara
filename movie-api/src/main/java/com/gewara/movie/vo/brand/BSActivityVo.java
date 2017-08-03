package com.gewara.movie.vo.brand;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.movie.constant.BsActivityConstant;

/**
 * @author zhoufy
 * @since 2015-8-4
 */
public class BSActivityVo  extends BaseVo{
	
	private static final long serialVersionUID = -763330768091727133L;
	
	private Long id;			//ID
	private String name;		//活动名称
	private Timestamp fromtime;	//开卖时间
	private Timestamp totime;	//结束时间
	private Timestamp addtime;	//创建时间
	private Integer allnum;		//活动显示总量
	private String shopid;		//商品ID
	private String citycode;	//城市列表
	
	private String relatedMovieId;	//关联影片ID
	private String movieIdEnable;	// Y：可用  ；N：不可用  MOVIEIDENABLE
	private String relatedCinemaId;	//关联影院ID
	private String cinemaIdEnable;	// Y：可用  ；N：不可用 CINEMAIDENABLE
	private String relatedMpId;		//关联场次
	private String mpIdEnable;		// Y：可用  ；N：不可用 MPIDENABLE
	private String edition;			// 版本
	
	private String mpiTimePeriod;	//场次时间段
	private String time1;			// 场次时段
	private String time2;			// 场次时段
	private String week;			//场次星期
	private String addtime1;		// 下单时段
	private String addtime2;		// 下单时段
	private String addweek;			// 下单星期
	
	private Integer price1;			// 卖价
	private Integer price2;			// 卖价
	private Integer costprice1;		// 成本价
	private Integer costprice2;		// 成本价
	private Integer payUnitPrice1;	// 支付单价
	private Integer payUnitPrice2;	// 支付单价
	
	private Integer mustBuyNum;		//必购票张数
	private String exchangeWay;		//兑换方式
	private String remark;			//活动备注
	private String otherinfo;		//其他设置 json格式， 存放支付配置信息等
	private Integer sortnum;		//排序
	private String logo;			//图片
	private String animationImg;	//动画图片
	private String actType;			// 活动类型
	private String smsContent;		// 营销短信
	private String printPaper;		// 是否打印票纸， Y：是； N：否
	private String rateinfo;		// 比率
	
	
	/**构造子函数**/
	public BSActivityVo() {}

	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Integer getAllnum() {
		return allnum;
	}
	public void setAllnum(Integer allnum) {
		this.allnum = allnum;
	}
	public Integer getSortnum() {
		return sortnum;
	}
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getMpiTimePeriod() {
		return mpiTimePeriod;
	}
	public void setMpiTimePeriod(String mpiTimePeriod) {
		this.mpiTimePeriod = mpiTimePeriod;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public Integer getMustBuyNum() {
		return mustBuyNum;
	}
	public void setMustBuyNum(Integer mustBuyNum) {
		this.mustBuyNum = mustBuyNum;
	}
	public String getExchangeWay() {
		return exchangeWay;
	}
	public void setExchangeWay(String exchangeWay) {
		this.exchangeWay = exchangeWay;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public String getRelatedMovieId() {
		return relatedMovieId;
	}
	public void setRelatedMovieId(String relatedMovieId) {
		this.relatedMovieId = relatedMovieId;
	}
	public String getRelatedCinemaId() {
		return relatedCinemaId;
	}
	public void setRelatedCinemaId(String relatedCinemaId) {
		this.relatedCinemaId = relatedCinemaId;
	}
	public String getRelatedMpId() {
		return relatedMpId;
	}
	public void setRelatedMpId(String relatedMpId) {
		this.relatedMpId = relatedMpId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAnimationImg() {
		return animationImg;
	}
	public void setAnimationImg(String animationImg) {
		this.animationImg = animationImg;
	}

	public String getMovieIdEnable() {
		return StringUtils.isEmpty(movieIdEnable) ? BsActivityConstant.ENABLE : movieIdEnable;
	}

	public void setMovieIdEnable(String movieIdEnable) {
		this.movieIdEnable = movieIdEnable;
	}

	public String getCinemaIdEnable() {
		return StringUtils.isEmpty(cinemaIdEnable) ? BsActivityConstant.ENABLE : cinemaIdEnable;
	}

	public void setCinemaIdEnable(String cinemaIdEnable) {
		this.cinemaIdEnable = cinemaIdEnable;
	}

	public String getMpIdEnable() {
		return StringUtils.isEmpty(mpIdEnable) ? BsActivityConstant.ENABLE : mpIdEnable;
	}

	public void setMpIdEnable(String mpIdEnable) {
		this.mpIdEnable = mpIdEnable;
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
	
	public Integer getPayUnitPrice1() {
		return payUnitPrice1;
	}

	public void setPayUnitPrice1(Integer payUnitPrice1) {
		this.payUnitPrice1 = payUnitPrice1;
	}

	public Integer getPayUnitPrice2() {
		return payUnitPrice2;
	}

	public void setPayUnitPrice2(Integer payUnitPrice2) {
		this.payUnitPrice2 = payUnitPrice2;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getPrintPaper() {
		return printPaper;
	}

	public void setPrintPaper(String printPaper) {
		this.printPaper = printPaper;
	}

	public String getRateinfo() {
		return rateinfo;
	}

	public void setRateinfo(String rateinfo) {
		this.rateinfo = rateinfo;
	}
	public Map<String, Integer> getRateMap(){
		Map<String, Integer> m = new HashMap<String, Integer>();
		String info = this.rateinfo;
		if(StringUtils.isNotBlank(info)){
			String[] args = info.split(",");
			if(args!=null && args.length>0){
				for(String arg : args){
					String[] tmp = arg.split(":");
					if(tmp!=null && tmp.length>1) m.put(tmp[0], Integer.valueOf(tmp[1]));
				}
			}
		}
		return m;
	}
	public Integer getRatenum(Integer q){
		String key = q+"";
		Integer num = getRateMap().get(key);
		if(num!=null) return num;
		return 0;
	}
	public boolean isGainCard(Integer q){
		return getRatenum(q)>0;
	}
	
}

