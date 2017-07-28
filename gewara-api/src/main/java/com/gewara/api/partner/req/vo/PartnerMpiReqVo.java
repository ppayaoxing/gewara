/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.req.vo;

import com.gewara.api.partner.req.vo.PartnerPageReqVo;
import java.util.Date;

public class PartnerMpiReqVo extends PartnerPageReqVo {
	private static final long serialVersionUID = -752034056399243324L;
	private Long cinemaId;
	private Long movieId;
	private Long discountId;
	private Date playdate;
	private String characteristic;

	public Long getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Date getPlaydate() {
		return this.playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getCharacteristic() {
		return this.characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
}