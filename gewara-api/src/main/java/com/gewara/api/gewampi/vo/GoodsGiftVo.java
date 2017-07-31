package com.gewara.api.gewampi.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class GoodsGiftVo extends BaseVo{
	private static final long serialVersionUID = -6365244088215093692L;
	private Long id;
	private Long goodsid;
	private Integer unitprice;
	private String partners;
	private String pageDisplayFlag;
	private Long cinemaid;
	private Long movieid;
	private Long mpid;			
	private String rateinfo;	//比率
	private String week;			
	private String mpidlist;	//场次列表
	private Timestamp fromtime;
	private Timestamp totime;
	private Integer everydayLimit;//每天限量
	private String startTime;//下单开始时段
	private String endTime;//下单结束时段
	private String timescope;	//场次时段
	private String movieids;	// 影片编号列表，用英文逗号隔开
	private String opiTimeFlg;
	
	public GoodsGiftVo(){
		
	}
	
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	public Long getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
	public Long getMovieid() {
		return movieid;
	}
	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}
	public Long getMpid() {
		return mpid;
	}
	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}
	public String getRateinfo() {
		return rateinfo;
	}
	public void setRateinfo(String rateinfo) {
		this.rateinfo = rateinfo;
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

	public Map<String, Integer> gainRateMap(){
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
	public Integer gainRatenum(Integer q){
		String key = q+"";
		Integer num = gainRateMap().get(key);
		if(num!=null) return num;
		return 0;
	}
	public boolean isGainGift(Integer q){
		return gainRatenum(q)>0;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getMpidlist() {
		return mpidlist;
	}
	public void setMpidlist(String mpidlist) {
		this.mpidlist = mpidlist;
	}
	public Integer getEverydayLimit() {
		return everydayLimit;
	}
	public void setEverydayLimit(Integer everydayLimit) {
		this.everydayLimit = everydayLimit;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getTimescope() {
		return timescope;
	}
	public void setTimescope(String timescope) {
		this.timescope = timescope;
	}
	public String getMovieids() {
		return movieids;
	}
	public void setMovieids(String movieids) {
		this.movieids = movieids;
	}
	public String getOpiTimeFlg() {
		return opiTimeFlg;
	}
	public void setOpiTimeFlg(String opiTimeFlg) {
		this.opiTimeFlg = opiTimeFlg;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public String getPartners() {
		return partners;
	}

	public void setPartners(String partners) {
		this.partners = partners;
	}

	public String getPageDisplayFlag() {
		return pageDisplayFlag;
	}

	public void setPageDisplayFlag(String pageDisplayFlag) {
		this.pageDisplayFlag = pageDisplayFlag;
	}
}
