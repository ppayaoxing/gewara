/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class CinemaDetailSellerVo implements Serializable {
	private static final long serialVersionUID = -9017278515943957586L;
	private Long movieId;
	private Long mpId;
	private String movieName;
	private String roomName;
	private String opentype;
	private Timestamp playTime;
	private String concatprice;
	private Long quantity;
	private Long totalcost;
	private Long totalcount;
	private String edition;

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public Timestamp getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(Timestamp playTime) {
		this.playTime = playTime;
	}

	public String getConcatprice() {
		return this.concatprice;
	}

	public void setConcatprice(String concatprice) {
		this.concatprice = concatprice;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}

	public Long getTotalcount() {
		return this.totalcount;
	}

	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}

	public Long getMpId() {
		return this.mpId;
	}

	public void setMpId(Long mpId) {
		this.mpId = mpId;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
}