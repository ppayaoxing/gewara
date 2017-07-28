/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.brand;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BrandStoreVo extends BaseVo {
	private static final long serialVersionUID = 4010577028328154103L;
	private static final double R = 6371229.0D;
	private Long id;
	private Long cinemaid;
	private Long brandid;
	private String storename;
	private String storeadd;
	private String tel;
	private Byte status;
	private String citycode;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String lat;
	private String lng;

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}

	public String getStorename() {
		return this.storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getStoreadd() {
		return this.storeadd;
	}

	public void setStoreadd(String storeadd) {
		this.storeadd = storeadd;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistance(String latx1, String laty1) {
		try {
			double e = Double.valueOf(latx1).doubleValue();
			double y1 = Double.valueOf(laty1).doubleValue();
			double x2 = Double.valueOf(this.lat).doubleValue();
			double y2 = Double.valueOf(this.lng).doubleValue();
			double x = (x2 - e) * 3.141592653589793D * 6371229.0D
					* Math.cos((y1 + y2) / 2.0D * 3.141592653589793D / 180.0D) / 180.0D;
			double y = (y2 - y1) * 3.141592653589793D * 6371229.0D / 180.0D;
			double distance = Math.hypot(x, y) / 1000.0D;
			return Math.round(distance) + "¹«Àï";
		} catch (Exception arg16) {
			return "";
		}
	}
}