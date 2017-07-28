/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import java.io.Serializable;

public class MovieSellerVo implements Serializable {
	private static final long serialVersionUID = -5176331916102057829L;
	private Long cinemaid;
	private String cinemaName;
	private String citycode;
	private Long totalquantity;
	private Long totalcost;
	private Long mpicount;
	private Long totalcount;

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getTotalquantity() {
		return this.totalquantity;
	}

	public void setTotalquantity(Long totalquantity) {
		this.totalquantity = totalquantity;
	}

	public Long getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}

	public Long getMpicount() {
		return this.mpicount;
	}

	public void setMpicount(Long mpicount) {
		this.mpicount = mpicount;
	}

	public Long getTotalcount() {
		return this.totalcount;
	}

	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}

	public String getCinemaName() {
		return this.cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}