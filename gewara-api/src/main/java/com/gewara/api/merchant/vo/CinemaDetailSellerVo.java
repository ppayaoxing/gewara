package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class CinemaDetailSellerVo implements Serializable{
	private static final long serialVersionUID = -9017278515943957586L;
	private Long movieId;
	private Long mpId;
	private String movieName;
	private String roomName;//影厅名称
	private String opentype;	//开放类型
	private Timestamp playTime; //放映时间
	private String concatprice;//单价
	private Long quantity;//影票数
	private Long totalcost;//总金额
	private Long totalcount;//总订单数
	private String edition; //版本
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public Timestamp getPlayTime() {
		return playTime;
	}
	public void setPlayTime(Timestamp playTime) {
		this.playTime = playTime;
	}
	public String getConcatprice() {
		return concatprice;
	}
	public void setConcatprice(String concatprice) {
		this.concatprice = concatprice;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}
	public Long getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(Long totalcount) {
		this.totalcount = totalcount;
	}
	public Long getMpId() {
		return mpId;
	}
	public void setMpId(Long mpId) {
		this.mpId = mpId;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
}
