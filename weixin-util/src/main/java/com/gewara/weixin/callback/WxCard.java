package com.gewara.weixin.callback;

public class WxCard {
	private String card_id;
	private Long begin_time;
	private Long end_time;
	private String user_card_status;
	private String can_consume;		//为true时候 表示卡状态正常，为false时候有user_card_status	
	public WxCard(){
		
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public Long getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Long begin_time) {
		this.begin_time = begin_time;
	}
	public Long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}
	public String getUser_card_status() {
		return user_card_status;
	}
	public void setUser_card_status(String user_card_status) {
		this.user_card_status = user_card_status;
	}
	public String getCan_consume() {
		return can_consume;
	}
	public void setCan_consume(String can_consume) {
		this.can_consume = can_consume;
	}
	
}
