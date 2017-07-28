/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.callback;

public class WxCard {
	private String card_id;
	private Long begin_time;
	private Long end_time;
	private String user_card_status;
	private String can_consume;

	public String getCard_id() {
		return this.card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public Long getBegin_time() {
		return this.begin_time;
	}

	public void setBegin_time(Long begin_time) {
		this.begin_time = begin_time;
	}

	public Long getEnd_time() {
		return this.end_time;
	}

	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}

	public String getUser_card_status() {
		return this.user_card_status;
	}

	public void setUser_card_status(String user_card_status) {
		this.user_card_status = user_card_status;
	}

	public String getCan_consume() {
		return this.can_consume;
	}

	public void setCan_consume(String can_consume) {
		this.can_consume = can_consume;
	}
}