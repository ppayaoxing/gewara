package com.gewara.drama.vo.cmd.order;

import java.io.Serializable;
import java.sql.Timestamp;

public class SearchInsureCommandVo implements Serializable {
	
	private static final long serialVersionUID = -2910423209801794773L;
	private Timestamp starttime;
	private Timestamp endtime;
	private String policyno;
	private String mobile;
	private String policyStatus;
	
	public SearchInsureCommandVo(){}
	
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
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
}
