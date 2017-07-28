/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.movie.vo.baochang.BaoChangBasePriceInfoVo;
import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.Date;

public class BaoChangMpiInfoVo extends BaoChangBasePriceInfoVo {
	private static final long serialVersionUID = -8070228638065466745L;
	private Long movieid;
	private String moviename;
	private Long mpid;
	private Date playdate;
	private String showtime;
	private String status;
	private Integer seatNum;
	private Integer seatPrice;
	private Integer seatGewaprice;
	private Timestamp validtime;

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return this.moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Date getPlaydate() {
		return this.playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getShowtime() {
		return this.showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSeatNum() {
		return this.seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getSeatPrice() {
		return this.seatPrice;
	}

	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}

	public Integer getSeatGewaprice() {
		return this.seatGewaprice;
	}

	public void setSeatGewaprice(Integer seatGewaprice) {
		this.seatGewaprice = seatGewaprice;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public boolean isLock() {
		return this.validtime != null && (new Timestamp(System.currentTimeMillis())).before(this.validtime);
	}

	public Timestamp getFullPlaytime() {
		String timeStr = DateUtil.formatDate(this.playdate) + " " + this.showtime + ":00";
		return DateUtil.parseTimestamp(timeStr);
	}

	public boolean isTimeOut() {
		return this.getFullPlaytime() != null
				&& this.getFullPlaytime().before(new Timestamp(System.currentTimeMillis()));
	}
}