/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.req;

import com.gewara.drama.vo.partner.req.PartnerPageReqVo;
import java.sql.Timestamp;

public class PartnerDramaReqVo extends PartnerPageReqVo {
	private static final long serialVersionUID = 8732512022821048996L;
	private String dramatype;
	private String booking;
	private Timestamp starttime;
	private Timestamp endtime;

	protected PartnerDramaReqVo() {
	}

	public PartnerDramaReqVo(String appkey, String citycode) {
		this.appkey = appkey;
		this.citycode = citycode;
	}

	public String getDramatype() {
		return this.dramatype;
	}

	public void setDramatype(String dramatype) {
		this.dramatype = dramatype;
	}

	public String getBooking() {
		return this.booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
}