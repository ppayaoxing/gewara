/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.movie;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class TakeInfoVo extends BaseVo {
	private static final long serialVersionUID = -1177004058479369237L;
	private Long id;
	private String tradeno;
	private String serialno;
	private Timestamp playtime;
	private String ordertype;
	private Long placeid;
	private Timestamp synchtime;
	private Timestamp callbacktime;
	private Timestamp taketime;
	private Timestamp updatetime;
	private String synchtype;
	private String callback;
	private String synch;
	private Integer synchNum;

	public Serializable realId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getSerialno() {
		return this.serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public Timestamp getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public Timestamp getSynchtime() {
		return this.synchtime;
	}

	public void setSynchtime(Timestamp synchtime) {
		this.synchtime = synchtime;
	}

	public Timestamp getCallbacktime() {
		return this.callbacktime;
	}

	public void setCallbacktime(Timestamp callbacktime) {
		this.callbacktime = callbacktime;
	}

	public Timestamp getTaketime() {
		return this.taketime;
	}

	public void setTaketime(Timestamp taketime) {
		this.taketime = taketime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getSynchtype() {
		return this.synchtype;
	}

	public void setSynchtype(String synchtype) {
		this.synchtype = synchtype;
	}

	public String getCallback() {
		return this.callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getSynch() {
		return this.synch;
	}

	public void setSynch(String synch) {
		this.synch = synch;
	}

	public Integer getSynchNum() {
		return this.synchNum;
	}

	public void setSynchNum(Integer synchNum) {
		this.synchNum = synchNum;
	}
}