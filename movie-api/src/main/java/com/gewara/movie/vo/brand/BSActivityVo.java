/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.brand;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class BSActivityVo extends BaseVo {
	private static final long serialVersionUID = -763330768091727133L;
	private Long id;
	private String name;
	private Timestamp fromtime;
	private Timestamp totime;
	private Timestamp addtime;
	private Integer allnum;
	private String shopid;
	private String citycode;
	private String relatedMovieId;
	private String movieIdEnable;
	private String relatedCinemaId;
	private String cinemaIdEnable;
	private String relatedMpId;
	private String mpIdEnable;
	private String edition;
	private String mpiTimePeriod;
	private String time1;
	private String time2;
	private String week;
	private String addtime1;
	private String addtime2;
	private String addweek;
	private Integer price1;
	private Integer price2;
	private Integer costprice1;
	private Integer costprice2;
	private Integer payUnitPrice1;
	private Integer payUnitPrice2;
	private Integer mustBuyNum;
	private String exchangeWay;
	private String remark;
	private String otherinfo;
	private Integer sortnum;
	private String logo;
	private String animationImg;
	private String actType;
	private String smsContent;
	private String printPaper;
	private String rateinfo;

	public String getShopid() {
		return this.shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getAllnum() {
		return this.allnum;
	}

	public void setAllnum(Integer allnum) {
		this.allnum = allnum;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getMpiTimePeriod() {
		return this.mpiTimePeriod;
	}

	public void setMpiTimePeriod(String mpiTimePeriod) {
		this.mpiTimePeriod = mpiTimePeriod;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public Integer getMustBuyNum() {
		return this.mustBuyNum;
	}

	public void setMustBuyNum(Integer mustBuyNum) {
		this.mustBuyNum = mustBuyNum;
	}

	public String getExchangeWay() {
		return this.exchangeWay;
	}

	public void setExchangeWay(String exchangeWay) {
		this.exchangeWay = exchangeWay;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getRelatedMovieId() {
		return this.relatedMovieId;
	}

	public void setRelatedMovieId(String relatedMovieId) {
		this.relatedMovieId = relatedMovieId;
	}

	public String getRelatedCinemaId() {
		return this.relatedCinemaId;
	}

	public void setRelatedCinemaId(String relatedCinemaId) {
		this.relatedCinemaId = relatedCinemaId;
	}

	public String getRelatedMpId() {
		return this.relatedMpId;
	}

	public void setRelatedMpId(String relatedMpId) {
		this.relatedMpId = relatedMpId;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAnimationImg() {
		return this.animationImg;
	}

	public void setAnimationImg(String animationImg) {
		this.animationImg = animationImg;
	}

	public String getMovieIdEnable() {
		return StringUtils.isEmpty(this.movieIdEnable) ? "Y" : this.movieIdEnable;
	}

	public void setMovieIdEnable(String movieIdEnable) {
		this.movieIdEnable = movieIdEnable;
	}

	public String getCinemaIdEnable() {
		return StringUtils.isEmpty(this.cinemaIdEnable) ? "Y" : this.cinemaIdEnable;
	}

	public void setCinemaIdEnable(String cinemaIdEnable) {
		this.cinemaIdEnable = cinemaIdEnable;
	}

	public String getMpIdEnable() {
		return StringUtils.isEmpty(this.mpIdEnable) ? "Y" : this.mpIdEnable;
	}

	public void setMpIdEnable(String mpIdEnable) {
		this.mpIdEnable = mpIdEnable;
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

	public Integer getPayUnitPrice1() {
		return this.payUnitPrice1;
	}

	public void setPayUnitPrice1(Integer payUnitPrice1) {
		this.payUnitPrice1 = payUnitPrice1;
	}

	public Integer getPayUnitPrice2() {
		return this.payUnitPrice2;
	}

	public void setPayUnitPrice2(Integer payUnitPrice2) {
		this.payUnitPrice2 = payUnitPrice2;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getActType() {
		return this.actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getSmsContent() {
		return this.smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getPrintPaper() {
		return this.printPaper;
	}

	public void setPrintPaper(String printPaper) {
		this.printPaper = printPaper;
	}

	public String getRateinfo() {
		return this.rateinfo;
	}

	public void setRateinfo(String rateinfo) {
		this.rateinfo = rateinfo;
	}

	public Map<String, Integer> getRateMap() {
		HashMap m = new HashMap();
		String info = this.rateinfo;
		if (StringUtils.isNotBlank(info)) {
			String[] args = info.split(",");
			if (args != null && args.length > 0) {
				String[] arg3 = args;
				int arg4 = args.length;

				for (int arg5 = 0; arg5 < arg4; ++arg5) {
					String arg = arg3[arg5];
					String[] tmp = arg.split(":");
					if (tmp != null && tmp.length > 1) {
						m.put(tmp[0], Integer.valueOf(tmp[1]));
					}
				}
			}
		}

		return m;
	}

	public Integer getRatenum(Integer q) {
		String key = q + "";
		Integer num = (Integer) this.getRateMap().get(key);
		return num != null ? num : Integer.valueOf(0);
	}

	public boolean isGainCard(Integer q) {
		return this.getRatenum(q).intValue() > 0;
	}
}