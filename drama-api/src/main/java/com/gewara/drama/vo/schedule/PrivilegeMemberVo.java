/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.schedule;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class PrivilegeMemberVo extends BaseVo {
	private static final long serialVersionUID = 7660140476295168432L;
	private Long id;
	private String mobile;
	private String checkpass;
	private Timestamp starttime;
	private Timestamp endtime;
	private String status;
	private Double discount;
	private String distype;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Long memberid;
	private Timestamp bindtime;
	private Integer version;
	private Integer orderNum;
	private Integer ticketNum;
	private String elecard;
	private String greetings;
	private Timestamp schedulestarttime;
	private Timestamp scheduleendtime;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCheckpass() {
		return this.checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getDistype() {
		return this.distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
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

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Timestamp getBindtime() {
		return this.bindtime;
	}

	public void setBindtime(Timestamp bindtime) {
		this.bindtime = bindtime;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getTicketNum() {
		return this.ticketNum;
	}

	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getElecard() {
		return this.elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public String getGreetings() {
		return this.greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public Timestamp getSchedulestarttime() {
		return this.schedulestarttime;
	}

	public void setSchedulestarttime(Timestamp schedulestarttime) {
		this.schedulestarttime = schedulestarttime;
	}

	public Timestamp getScheduleendtime() {
		return this.scheduleendtime;
	}

	public void setScheduleendtime(Timestamp scheduleendtime) {
		this.scheduleendtime = scheduleendtime;
	}
}