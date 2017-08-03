package com.gewara.api.gewampi.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.gewara.api.gewampi.util.RequestParamsMap;


public class MovieItemBasicQueryRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1363532714670489706L;
	private String citycode;	//城市
	private String countycode;  //区域
	private Long cinemaid;		//影院ID
	private Long movieid;		//影片ID
	private Date playdate;		//放映日期	
	private String opentype;	//开放类型
	private String seqNo;		//外部关联ID
	private Long batch;				//批次标识
	private String openStatus;		//开放状态：init：初始状态，open：已开放，close：以后也不开放
	private String mpitype;			//场次类型 filmfest 电影节场次
	
	//以下为opi属性
	private Long openid;			//					------>原opi里的id
	private String status;			//状态：可预订，不可预定等 Y[可预订]N[不可预订]D[删除]
	private String partner;			//合作伙伴开放状态：Y对外开放,N不对外开放
	private String characteristic;
	
	//不在Map中的查询条件
	private Timestamp playtimeGte; //放映时间大于等于该时间
	private Timestamp playtimeLt; //放映时间小于该时间	
	private String showtimeGte; //大于等于该时间，该值只有在playdate不为空时，才有效
	private String showtimeLt;  //小于该时间，该值只有在playdate不为空时，才有效
	
	//其它参数	
	private Integer from;
	private Integer maxnum;
	
	private String propertyName;	//DistinctProperty时需要
	
	/**
	 * gteShowtime，不包括在内
	 * 若查询方法使用缓存，请注意该值加入key中
	 * @return
	 * @author leo
	 * @addTime 2015年6月30日下午2:20:18
	 */
	public Map<String, Object> gainParamsMap(){
		Map<String, Object> params = new RequestParamsMap<String, Object>();
		params.put("citycode", citycode);
		params.put("countycode", countycode);
		params.put("cinemaid", cinemaid);
		params.put("movieid", movieid);
		params.put("playdate", playdate);
		params.put("opentype", opentype);
		params.put("seqNo", seqNo);
		params.put("batch", batch);
		params.put("openStatus", openStatus);
		params.put("mpitype", mpitype);
		params.put("openid", openid);
		params.put("status", status);
		params.put("partner", partner);
		params.put("characteristic", characteristic);
		return params;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Date getPlaydate() {
		return playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getOpentype() {
		return opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Long getBatch() {
		return batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getMpitype() {
		return mpitype;
	}

	public void setMpitype(String mpitype) {
		this.mpitype = mpitype;
	}

	public Long getOpenid() {
		return openid;
	}

	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCountycode() {
		return countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getShowtimeGte() {
		return showtimeGte;
	}

	public void setShowtimeGte(String showtimeGte) {
		this.showtimeGte = showtimeGte;
	}

	public String getShowtimeLt() {
		return showtimeLt;
	}

	public void setShowtimeLt(String showtimeLt) {
		this.showtimeLt = showtimeLt;
	}

	public Timestamp getPlaytimeGte() {
		return playtimeGte;
	}

	public void setPlaytimeGte(Timestamp playtimeGte) {
		this.playtimeGte = playtimeGte;
	}

	public Timestamp getPlaytimeLt() {
		return playtimeLt;
	}

	public void setPlaytimeLt(Timestamp playtimeLt) {
		this.playtimeLt = playtimeLt;
	}
}
