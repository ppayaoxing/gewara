/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class GoodsSummaryReportVo extends BaseVo {
	private static final long serialVersionUID = -8891835892123821785L;
	private Long cinemaId;
	private String cinemaName;
	private String citycode;
	private int orderCount;
	private int quantity;
	private int totalcost;

	public GoodsSummaryReportVo() {
	}

	public GoodsSummaryReportVo(long cinemaId, String cinemaName, String citycode) {
		this.cinemaId = Long.valueOf(cinemaId);
		this.cinemaName = cinemaName;
		this.citycode = citycode;
	}

	public Long getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
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

	public int getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public Serializable realId() {
		return this.cinemaId;
	}
}