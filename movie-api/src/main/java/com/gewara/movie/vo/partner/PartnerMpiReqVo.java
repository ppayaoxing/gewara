package com.gewara.movie.vo.partner;

import java.util.Date;


/**
 * MPI 
 */
public class PartnerMpiReqVo extends PartnerPageReqVo {
	private static final long serialVersionUID = -752034056399243324L;
	// 影院ID
	private Long cinemaId;
	// 影片ID
	private Long movieId;
	// 特价活动ID
	private Long discountId;
	// 日期
	private Date playdate;
	// 特效厅，如IMAX等
	private String characteristic;

	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public Date getPlaydate() {
		return playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

}
