package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class DateInfo implements Serializable{
	private static final long serialVersionUID = 7504866618209037778L;
	private String type;			//仅支持DATE_TYPE_FIX_TIME_RANGE
	private Long begin_timestamp;
	private Long end_timestamp;					
	public DateInfo(){
		
	}
	public DateInfo(Long begin_timestamp, Long end_timestamp){
		this.type = "DATE_TYPE_FIX_TIME_RANGE";
		this.begin_timestamp = begin_timestamp;
		this.end_timestamp = end_timestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getBegin_timestamp() {
		return begin_timestamp;
	}
	public void setBegin_timestamp(Long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}
	public Long getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(Long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
}
