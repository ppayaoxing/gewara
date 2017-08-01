package com.gewara.api.vo.order;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

public class SportOrderVo extends BaseVo {
	private String sportname;
	private String itemname;
	private String detail;
	private Date playdate;
	private Timestamp playtime;
	private String timelen;
	private String tradeNo;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSportname() {
		return sportname;
	}

	public String getItemname() {
		return itemname;
	}

	public String getDetail() {
		return detail;
	}

	public Date getPlaydate() {
		return playdate;
	}

	public Timestamp getPlaytime() {
		return playtime;
	}

	public String getTimelen() {
		return timelen;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public void setTimelen(String timelen) {
		this.timelen = timelen;
	}

}
