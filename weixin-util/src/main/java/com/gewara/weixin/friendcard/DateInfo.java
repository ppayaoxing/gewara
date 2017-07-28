/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class DateInfo implements Serializable {
	private static final long serialVersionUID = 7504866618209037778L;
	private String type;
	private Long begin_timestamp;
	private Long end_timestamp;

	public DateInfo() {
	}

	public DateInfo(Long begin_timestamp, Long end_timestamp) {
		this.type = "DATE_TYPE_FIX_TIME_RANGE";
		this.begin_timestamp = begin_timestamp;
		this.end_timestamp = end_timestamp;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getBegin_timestamp() {
		return this.begin_timestamp;
	}

	public void setBegin_timestamp(Long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public Long getEnd_timestamp() {
		return this.end_timestamp;
	}

	public void setEnd_timestamp(Long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
}