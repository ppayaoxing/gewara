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
	private String name;		//锟筋动锟斤拷锟斤拷
	private Timestamp fromtime;	//锟斤拷锟斤拷时锟斤拷
	private Timestamp totime;	//锟斤拷锟斤拷时锟斤拷
	private Timestamp addtime;	//锟斤拷锟斤拷时锟斤拷
	private Integer allnum;		//锟筋动锟斤拷示锟斤拷锟斤拷
	private String shopid;		//锟斤拷品ID
	private String citycode;	//锟斤拷锟斤拷锟叫憋拷
	
	private String relatedMovieId;	//锟斤拷锟斤拷影片ID
	private String movieIdEnable;	// Y锟斤拷锟斤拷锟斤拷  锟斤拷N锟斤拷锟斤拷锟斤拷锟斤拷  MOVIEIDENABLE
	private String relatedCinemaId;	//锟斤拷锟斤拷影院ID
	private String cinemaIdEnable;	// Y锟斤拷锟斤拷锟斤拷  锟斤拷N锟斤拷锟斤拷锟斤拷锟斤拷 CINEMAIDENABLE
	private String relatedMpId;		//锟斤拷锟斤拷锟斤拷锟斤拷
	private String mpIdEnable;		// Y锟斤拷锟斤拷锟斤拷  锟斤拷N锟斤拷锟斤拷锟斤拷锟斤拷 MPIDENABLE
	private String edition;			// 锟芥本
	
	private String mpiTimePeriod;	//锟斤拷锟斤拷时锟斤拷锟�
	private String time1;			// 锟斤拷锟斤拷时锟斤拷
	private String time2;			// 锟斤拷锟斤拷时锟斤拷
	private String week;			//锟斤拷锟斤拷锟斤拷锟斤拷
	private String addtime1;		// 锟铰碉拷时锟斤拷
	private String addtime2;		// 锟铰碉拷时锟斤拷
	private String addweek;			// 锟铰碉拷锟斤拷锟斤拷
	
	private Integer price1;			// 锟斤拷锟斤拷
	private Integer price2;			// 锟斤拷锟斤拷
	private Integer costprice1;		// 锟缴憋拷锟斤拷
	private Integer costprice2;		// 锟缴憋拷锟斤拷
	private Integer payUnitPrice1;	// 支锟斤拷锟斤拷锟斤拷
	private Integer payUnitPrice2;	// 支锟斤拷锟斤拷锟斤拷
	
	private Integer mustBuyNum;		//锟截癸拷票锟斤拷锟斤拷
	private String exchangeWay;		//锟揭伙拷锟斤拷式
	private String remark;			//锟筋动锟斤拷注
	private String otherinfo;		//锟斤拷锟斤拷锟斤拷锟斤拷 json锟斤拷式锟斤拷 锟斤拷锟街э拷锟斤拷锟斤拷锟斤拷锟较拷锟�
	private Integer sortnum;		//锟斤拷锟斤拷
	private String logo;			//图片
	private String animationImg;	//锟斤拷锟斤拷图片
	private String actType;			// 锟筋动锟斤拷锟斤拷
	private String smsContent;		// 营锟斤拷锟斤拷锟斤拷
	private String printPaper;		// 锟角凤拷锟接∑敝斤拷锟� Y锟斤拷锟角ｏ拷 N锟斤拷锟斤拷
	private String rateinfo;		// 锟斤拷锟斤拷
	
	
	/**锟斤拷锟斤拷锟接猴拷锟斤拷**/
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
					if(tmp!=null && tmp.length>1) {
                        m.put(tmp[0], Integer.valueOf(tmp[1]));
                    }
				}
			}
		}
		return m;
	}
	public Integer getRatenum(Integer q){
		String key = q+"";
		Integer num = getRateMap().get(key);
		if(num!=null) {
            return num;
        }
		return 0;
	}
	public boolean isGainCard(Integer q){
		return getRatenum(q)>0;
	}
	
}

