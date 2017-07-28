/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.gworder.vo.BaoChangData;
import com.gewara.api.gworder.vo.CreateOrderReq;
import java.util.Date;
import java.util.Map;

public class CreateBaoChangOrderReq extends CreateOrderReq {
	private static final long serialVersionUID = 8648509662662203801L;
	private String mobile;
	private Long mpid;
	private Long partnerid;
	private Long movieid;
	private String membername;
	private Date appointmentDate;
	private String startTime;
	private String endTime;
	private BaoChangData baoChangData;
	private String origin;
	private Map<String, String> descMap;

	public CreateBaoChangOrderReq() {
	}

	public CreateBaoChangOrderReq(Long movieid, BaoChangData baoChangData, Date appointmentDate, String startTime,
			String endTime, Long partnerid) {
		this.movieid = movieid;
		this.baoChangData = baoChangData;
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.partnerid = partnerid;
	}

	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Map<String, String> getDescMap() {
		return this.descMap;
	}

	public void setDescMap(Map<String, String> descMap) {
		this.descMap = descMap;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public BaoChangData getBaoChangData() {
		return this.baoChangData;
	}

	public void setBaoChangData(BaoChangData baoChangData) {
		this.baoChangData = baoChangData;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
}