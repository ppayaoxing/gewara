package com.gewara.api.vo.order;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class TicketOrderVo extends GewaOrderVo {

	private String moviename;
	private String Cinemaname;
	private String roomname;
	private String seatprice;

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getCinemaname() {
		return Cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		Cinemaname = cinemaname;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getSeatprice() {
		return seatprice;
	}

	public void setSeatprice(String seatprice) {
		this.seatprice = seatprice;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

}
