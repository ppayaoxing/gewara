package com.gewara.api.merchant.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class GoodsSummaryReportVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8891835892123821785L;
	private Long cinemaId;
	private String cinemaName;
	private String citycode;
	private int orderCount;//订单数
	private int quantity; //票数 、份数
	private int totalcost;//金额
	
	public GoodsSummaryReportVo(){}
	
	public GoodsSummaryReportVo(long cinemaId,String cinemaName,String citycode){
		this.cinemaId = cinemaId;
		this.cinemaName = cinemaName;
		this.citycode = citycode;
	}
	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
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

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	@Override
	public Serializable realId() {
		return cinemaId;
	}

}
