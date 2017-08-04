package com.gewara.api.merchant.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

//TODO  ´ý¶¨
public class MovieMpiSeatReportVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer allSeats;
	private Integer allSellSeats;
	private Integer gewaSellSeats;
	private Integer sumGewaprice;
	private Integer locknum;
	private Integer opiCount;
	private Integer gewaprice;
	private Integer gsellnum;
	private Integer csellnum;

	public Integer getSumGewaprice() {
		return sumGewaprice;
	}

	public void setSumGewaprice(Integer sumGewaprice) {
		this.sumGewaprice = sumGewaprice;
	}

	public Integer getAllSellSeats() {
		return allSellSeats;
	}

	public void setAllSellSeats(Integer allSellSeats) {
		this.allSellSeats = allSellSeats;
	}

	public Integer getGewaSellSeats() {
		return gewaSellSeats;
	}

	public void setGewaSellSeats(Integer gewaSellSeats) {
		this.gewaSellSeats = gewaSellSeats;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public Integer getOpiCount() {
		return opiCount;
	}

	public void setOpiCount(Integer opiCount) {
		this.opiCount = opiCount;
	}

	public Integer getGewaprice() {
		return gewaprice;
	}

	public void setGewaprice(Integer gewaprice) {
		this.gewaprice = gewaprice;
	}

	public Integer getGsellnum() {
		return gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public Integer getCsellnum() {
		return csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getAllSeats() {
		return allSeats;
	}

	public void setAllSeats(Integer allSeats) {
		this.allSeats = allSeats;
	}

	public MovieMpiSeatReportVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieMpiSeatReportVo(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

}
