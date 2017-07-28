/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class GoodsGiftVo extends BaseVo {
	private static final long serialVersionUID = -6365244088215093692L;
	private Long id;
	private Long goodsid;
	private Integer unitprice;
	private String partners;
	private String pageDisplayFlag;
	private Long cinemaid;
	private Long movieid;
	private Long mpid;
	private String rateinfo;
	private String week;
	private String mpidlist;
	private Timestamp fromtime;
	private Timestamp totime;
	private Integer everydayLimit;
	private String startTime;
	private String endTime;
	private String timescope;
	private String movieids;
	private String opiTimeFlg;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public String getRateinfo() {
		return this.rateinfo;
	}

	public void setRateinfo(String rateinfo) {
		this.rateinfo = rateinfo;
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

	public Map<String, Integer> gainRateMap() {
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

	public Integer gainRatenum(Integer q) {
		String key = q + "";
		Integer num = (Integer) this.gainRateMap().get(key);
		return num != null ? num : Integer.valueOf(0);
	}

	public boolean isGainGift(Integer q) {
		return this.gainRatenum(q).intValue() > 0;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getMpidlist() {
		return this.mpidlist;
	}

	public void setMpidlist(String mpidlist) {
		this.mpidlist = mpidlist;
	}

	public Integer getEverydayLimit() {
		return this.everydayLimit;
	}

	public void setEverydayLimit(Integer everydayLimit) {
		this.everydayLimit = everydayLimit;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTimescope() {
		return this.timescope;
	}

	public void setTimescope(String timescope) {
		this.timescope = timescope;
	}

	public String getMovieids() {
		return this.movieids;
	}

	public void setMovieids(String movieids) {
		this.movieids = movieids;
	}

	public String getOpiTimeFlg() {
		return this.opiTimeFlg;
	}

	public void setOpiTimeFlg(String opiTimeFlg) {
		this.opiTimeFlg = opiTimeFlg;
	}

	public Integer getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public String getPartners() {
		return this.partners;
	}

	public void setPartners(String partners) {
		this.partners = partners;
	}

	public String getPageDisplayFlag() {
		return this.pageDisplayFlag;
	}

	public void setPageDisplayFlag(String pageDisplayFlag) {
		this.pageDisplayFlag = pageDisplayFlag;
	}
}