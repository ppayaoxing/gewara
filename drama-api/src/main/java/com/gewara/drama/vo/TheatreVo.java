package com.gewara.drama.vo;

import com.gewara.drama.vo.common.BaseInfoVo;

public class TheatreVo extends BaseInfoVo{
	private static final long serialVersionUID = 744078914460487494L;
	private String booking;

	public String getBooking() {
		return booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}
}
