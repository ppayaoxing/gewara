/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class TheatreProfileVo extends BaseVo {
	private static final long serialVersionUID = 8293331615143909101L;
	private Long id;
	private Long topicid;
	private String notifymsg1;
	private String notifymsg2;
	private String notifymsg3;
	private String notifyRemark;
	private String qrcodeRemark;
	private String takemethod;
	private String takemsg;
	private String opentype;
	private String status;
	private Integer eticketHour;
	private Integer eticketWeekHour;
	private Timestamp addtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotifymsg1() {
		return this.notifymsg1;
	}

	public void setNotifymsg1(String notifymsg1) {
		this.notifymsg1 = notifymsg1;
	}

	public String getNotifymsg2() {
		return this.notifymsg2;
	}

	public void setNotifymsg2(String notifymsg2) {
		this.notifymsg2 = notifymsg2;
	}

	public String getNotifymsg3() {
		return this.notifymsg3;
	}

	public void setNotifymsg3(String notifymsg3) {
		this.notifymsg3 = notifymsg3;
	}

	public String getNotifyRemark() {
		return this.notifyRemark;
	}

	public void setNotifyRemark(String notifyRemark) {
		this.notifyRemark = notifyRemark;
	}

	public String getQrcodeRemark() {
		return this.qrcodeRemark;
	}

	public void setQrcodeRemark(String qrcodeRemark) {
		this.qrcodeRemark = qrcodeRemark;
	}

	public String getTakemsg() {
		return this.takemsg;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public void setTakemsg(String takemsg) {
		this.takemsg = takemsg;
	}

	public Integer getEticketHour() {
		return this.eticketHour;
	}

	public void setEticketHour(Integer eticketHour) {
		this.eticketHour = eticketHour;
	}

	public Integer getEticketWeekHour() {
		return this.eticketWeekHour;
	}

	public void setEticketWeekHour(Integer eticketWeekHour) {
		this.eticketWeekHour = eticketWeekHour;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public boolean hasOpentype(String htype) {
		return StringUtils.isBlank(htype) ? false : StringUtils.equals(this.opentype, htype);
	}
}