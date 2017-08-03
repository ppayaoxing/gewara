package com.gewara.drama.vo.partner.req;

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
		return dramatype;
	}
	public void setDramatype(String dramatype) {
		this.dramatype = dramatype;
	}
	public String getBooking() {
		return booking;
	}
	public void setBooking(String booking) {
		this.booking = booking;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	} 
	
	
}
