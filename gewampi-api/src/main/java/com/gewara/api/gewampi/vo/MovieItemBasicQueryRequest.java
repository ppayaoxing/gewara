/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.vo;

import com.gewara.api.gewampi.util.RequestParamsMap;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class MovieItemBasicQueryRequest implements Serializable {
	private static final long serialVersionUID = -1363532714670489706L;
	private String citycode;
	private String countycode;
	private Long cinemaid;
	private Long movieid;
	private Date playdate;
	private String opentype;
	private String seqNo;
	private Long batch;
	private String openStatus;
	private String mpitype;
	private Long openid;
	private String status;
	private String partner;
	private String characteristic;
	private Timestamp playtimeGte;
	private Timestamp playtimeLt;
	private String showtimeGte;
	private String showtimeLt;
	private Integer from;
	private Integer maxnum;
	private String propertyName;

	public Map<String, Object> gainParamsMap() {
		RequestParamsMap params = new RequestParamsMap();
		params.put("citycode", this.citycode);
		params.put("countycode", this.countycode);
		params.put("cinemaid", this.cinemaid);
		params.put("movieid", this.movieid);
		params.put("playdate", this.playdate);
		params.put("opentype", this.opentype);
		params.put("seqNo", this.seqNo);
		params.put("batch", this.batch);
		params.put("openStatus", this.openStatus);
		params.put("mpitype", this.mpitype);
		params.put("openid", this.openid);
		params.put("status", this.status);
		params.put("partner", this.partner);
		params.put("characteristic", this.characteristic);
		return params;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Date getPlaydate() {
		return this.playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Long getBatch() {
		return this.batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getOpenStatus() {
		return this.openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public String getMpitype() {
		return this.mpitype;
	}

	public void setMpitype(String mpitype) {
		this.mpitype = mpitype;
	}

	public Long getOpenid() {
		return this.openid;
	}

	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getFrom() {
		return this.from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getCharacteristic() {
		return this.characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getShowtimeGte() {
		return this.showtimeGte;
	}

	public void setShowtimeGte(String showtimeGte) {
		this.showtimeGte = showtimeGte;
	}

	public String getShowtimeLt() {
		return this.showtimeLt;
	}

	public void setShowtimeLt(String showtimeLt) {
		this.showtimeLt = showtimeLt;
	}

	public Timestamp getPlaytimeGte() {
		return this.playtimeGte;
	}

	public void setPlaytimeGte(Timestamp playtimeGte) {
		this.playtimeGte = playtimeGte;
	}

	public Timestamp getPlaytimeLt() {
		return this.playtimeLt;
	}

	public void setPlaytimeLt(Timestamp playtimeLt) {
		this.playtimeLt = playtimeLt;
	}
}