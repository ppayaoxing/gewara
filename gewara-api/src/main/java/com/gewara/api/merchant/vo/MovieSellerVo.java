package com.gewara.api.merchant.vo;

import java.io.Serializable;

public class MovieSellerVo implements Serializable{
	private static final long serialVersionUID = -5176331916102057829L;
	private Long cinemaid;
	private String cinemaName;
	private String citycode;
	private Long totalquantity;//影票数
	private Long totalcost;//总金额
	private Long mpicount;//总场次数 
	private Long totalcount;//总订单数
	
	public Long getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
	public Long getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(Long totalquantity) {
		this.totalquantity = totalquantity;
	}
	public Long getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}
	public Long getMpicount() {
		return mpicount;
	}
	public void setMpicount(Long mpicount) {
		this.mpicount = mpicount;
	}
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}
